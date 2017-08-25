package com.aidar.config;

import com.aidar.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.aidar.util.ApplicationUrls.*;

/**
 * @author Aidar Shaifutdinov.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.aidar.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProviderImpl authProvider;
    private final AccessDeniedHandler accessDeniedHandler;

    @Autowired
    public SecurityConfig(AuthProviderImpl authProvider, AccessDeniedHandler accessDeniedHandler) {
        this.authProvider = authProvider;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(SIGN_UP_URL, LOGIN_URL).anonymous()
                .antMatchers(BASE_BOOKS_URL, MY_BOOKS_URL).hasRole("USER");

        http.csrf().disable()
                .formLogin()
                .loginPage(LOGIN_URL)
                .loginProcessingUrl(LOGIN_URL + "/process")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl(BASE_BOOKS_URL, true)
                .failureUrl(LOGIN_URL + "?error=true")
                .and()
                .logout().logoutSuccessUrl(LOGIN_URL)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

}
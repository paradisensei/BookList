package com.aidar.util;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Aidar Shaifutdinov.
 */
public class UserRegistrationForm {

    private static final String BLANK_MESSAGE = "This field can`t be empty";
    private static final String PASSWORD_MESSAGE = "Password must be between 7 and 20 characters";

    @NotBlank(message = BLANK_MESSAGE)
    private String name;

    @NotBlank(message = BLANK_MESSAGE)
    private String email;

    @Size(min = 7, max = 20, message = PASSWORD_MESSAGE)
    private String password;

    @Size(min = 7, max = 20, message = PASSWORD_MESSAGE)
    private String passwordConfirmation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}

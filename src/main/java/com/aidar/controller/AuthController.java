package com.aidar.controller;

import com.aidar.service.UserService;
import com.aidar.util.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static com.aidar.util.ApplicationUrls.LOGIN_URL;
import static com.aidar.util.ApplicationUrls.SIGN_UP_URL;

/**
 * @author Aidar Shaifutdinov.
 */
@Controller
public class AuthController {

    private final UserService userService;

    private final Validator userValidator;

    @Autowired
    public AuthController(UserService userService, Validator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(SIGN_UP_URL)
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        return "auth/sign_up";
    }

    @PostMapping(SIGN_UP_URL)
    public String signUp(@ModelAttribute("user") @Valid UserRegistrationForm user,
                         Errors errors) {
        userValidator.validate(user, errors);
        if (errors.hasErrors()) {
            return "auth/sign_up";
        }
        userService.add(user);
        return "redirect:" + LOGIN_URL;
    }

    @GetMapping(LOGIN_URL)
    public String login(@RequestParam(value = "error", required = false) Boolean error,
                        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("submitUrl", LOGIN_URL + "/process");
        return "auth/login";
    }

}

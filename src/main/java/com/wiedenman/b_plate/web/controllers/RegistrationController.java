/*
 * Copyright (c) 2017. Landon Wiedenman.  For personal non-commercial use only.  Please contact me for commercial use.
 */

package com.wiedenman.b_plate.web.controllers;

import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.service.UserService;
import com.wiedenman.b_plate.web.model.User;
import com.wiedenman.b_plate.web.model.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.GET)  // Displays form
    public String registrationForm(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute(new User());

        return "registrationPage";
        }

    @RequestMapping(value = "register", method = RequestMethod.POST) // Process form
    public String registerUser(@ModelAttribute @Valid User newUser,
                                 final BindingResult result,
                                 Errors errors, Model model) {

        model.addAttribute("title", "Register");
//        String newUserEmail = newUser.getEmail();
//        Optional<User> existingUser = userDao.findByEmail(newUserEmail);

        if (errors.hasErrors()) {
            return "registrationPage";
        }
        try {
            userService.registerNewUser(newUser);
        } catch (EmailExistsException e) {
            result.addError(new FieldError("user", "email", e.getMessage()));
            model.addAttribute("user", newUser);
            return "registrationPage";
        }
        return "redirect:/login";

//        else if (existingUser.isPresent()) { // TODO: Add error as Error for existing user, pass to view
//            return "registrationPage";
//        }
////        newUser.setRole(userRole);  // TODO: make role setting
//        newUser.setEnabled(true);
//
//        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
//        newUser.setVerifyPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
//        userDao.save(newUser);
//        return "redirect:index";
    }
}

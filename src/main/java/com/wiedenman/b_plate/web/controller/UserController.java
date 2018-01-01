package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.exception.UsernameExistsException;
import com.wiedenman.b_plate.service.UserService;
import com.wiedenman.b_plate.web.comparator.UsernameComparator;
import com.wiedenman.b_plate.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users")
    public String index(Model model) {

        List<User> users = (List<User>) userService.findAll();
        Collections.sort(users, new UsernameComparator());

        model.addAttribute("users", users);
        model.addAttribute("title", "ALL USERS");

        return "user/index";
    }

    @RequestMapping(value = "user-edit-{id}", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable long id) {

        User user = userService.findOne(id);
        model.addAttribute("title", "EDIT USER");
        model.addAttribute("user", user);

        return "user/edit";
    }

    @RequestMapping(value = "user-edit", method = RequestMethod.POST)
    public String processEditUser(@ModelAttribute @Valid User user,
                                  final BindingResult result,
                                  Errors errors,
                                  Model model,
                                  final HttpServletRequest request) {

        model.addAttribute("title", "EDIT USER");
        user.setPassword(userService.findOne(user.getId()).getPassword());
        user.setVerifyPassword(userService.findOne(user.getId()).getVerifyPassword());
        if (errors.hasErrors()) {
            return "user/edit";
        } try {
            userService.save(user);
        } catch (EmailExistsException e) {
            result.addError(new FieldError("user", "email", e.getMessage()));
            model.addAttribute("user", user);
            return "user/edit";
        } catch (UsernameExistsException e) {
            result.addError(new FieldError("user", "username", e.getMessage()));
            model.addAttribute("user", user);
            return "user/edit";
        }
        return "user/edit";
    }

    @RequestMapping(value = "user-disable", method = RequestMethod.POST)
    public String disableUser(@RequestParam long user_id) throws EmailExistsException, UsernameExistsException {

        User user = userService.findOne(user_id);
        user.setEnabled(false);
        userService.save(user);

        return "redirect:users";
    }

    @RequestMapping(value = "user-enable", method = RequestMethod.POST)
    public String enableUser(@RequestParam long user_id) throws EmailExistsException, UsernameExistsException {

        User user = userService.findOne(user_id);
        user.setEnabled(true);
        userService.save(user);

        return "redirect:users";
    }
}

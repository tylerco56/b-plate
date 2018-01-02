package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.dao.RoleDao;
import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.exception.UsernameExistsException;
import com.wiedenman.b_plate.service.UserService;
import com.wiedenman.b_plate.web.comparator.UsernameComparator;
import com.wiedenman.b_plate.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
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

    @Autowired
    private RoleDao roleDao;

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
                                  Model model) {

        model.addAttribute("title", "EDIT USER");

        List<ObjectError> allErrors = errors.getAllErrors();
        ArrayList<ObjectError> filteredErrors = new ArrayList<>();
        for (ObjectError error : allErrors) {
            if (!error.getDefaultMessage().contains("Password")) {
                filteredErrors.add(error);
            }
        }

        User dbUser = userService.findOne(user.getId());
        user.setPassword(dbUser.getPassword());
        user.setVerifyPassword(dbUser.getVerifyPassword());

        if (filteredErrors.size() != 0) {
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

    @RequestMapping(value = "profile")
    public String profile(Model model, Principal principal) {

        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        model.addAttribute("title", "MY PROFILE");
        model.addAttribute("user", user);
        return "user/profile";
    }

    @RequestMapping(value = "update-profile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute @Valid User user,
                                final BindingResult result,
                                Errors errors,
                                Principal principal,
                                Model model) {

        model.addAttribute("title", "MY PROFILE");

        List<ObjectError> allErrors = errors.getAllErrors();
        ArrayList<ObjectError> filteredErrors = new ArrayList<>();
        for (ObjectError error : allErrors) {
            if (!error.getDefaultMessage().contains("Password")) {
                filteredErrors.add(error);
            }
        }

        User dbUser = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        user.setPassword(dbUser.getPassword());
        user.setVerifyPassword(dbUser.getVerifyPassword());
        user.setRole(roleDao.findById(dbUser.getRole().getId()));

        if (filteredErrors.size() != 0) {
            return "user/profile";
        } try {
            dbUser.setUsername(user.getUsername());
            dbUser.setEmail(user.getEmail());
            dbUser.setPhoneNumber(user.getPhoneNumber());
            dbUser.setFirstName(user.getFirstName());
            dbUser.setLastName(user.getLastName());
            dbUser.setEnabled(true);
            userService.save(dbUser);
        } catch (EmailExistsException e) {
            result.addError(new FieldError("user", "email", e.getMessage()));
            model.addAttribute("user", user);
            return "user/profile";
        } catch (UsernameExistsException e) {
            result.addError(new FieldError("user", "username", e.getMessage()));
            model.addAttribute("user", user);
            return "user/profile";
        }
        return "redirect:/profile";
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

    @RequestMapping(value = "close-my-account", method = RequestMethod.POST)
    public String closeMyAccount(@RequestParam long user_id,
                                 Principal principal) throws EmailExistsException, UsernameExistsException {

        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        user.setEnabled(false);
        userService.save(user);
        return "goodbye";
    }
}

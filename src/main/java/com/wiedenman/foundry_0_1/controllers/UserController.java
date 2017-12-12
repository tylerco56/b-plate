package com.wiedenman.foundry_0_1.controllers;

import com.wiedenman.foundry_0_1.models.*;
import com.wiedenman.foundry_0_1.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

// TODO: Make User class persistent

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Users");

        return "user/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String singleUser(Model model, @PathVariable int id) {

        User user = userDao.findOne(id);
        String formattedDate = user.getCreationDate().format(DateTimeFormatter.ofPattern("MMMM dd,  yyyy"));
        model.addAttribute("user", user);
        model.addAttribute("formattedDate", formattedDate);
        return "user/single";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)  // Displays form
    public String displayAddUser(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST) // Process form
    public String processAddUser(@ModelAttribute @Valid User newUser,
                                 Errors errors, Model model) {

        model.addAttribute("title", "Add User");
        String newUserEmail = newUser.getEmail();
//        .equals(userDao.findByEmail(newUser.getEmail());
        Optional<User> existingUser = userDao.findByEmail(newUserEmail);
        if (errors.hasErrors()) {
            return "user/add";

        } else if (existingUser.isPresent()) { // TODO: Add error as Error for existing user, pass to view
            return "user/add";
        }
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        newUser.setVerifyPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        userDao.save(newUser);
        return "redirect:index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET) // Display login form
    public String displayLogin(Model model) {
        model.addAttribute("title", "Login");

        User loginUser = new User();
        model.addAttribute(loginUser);
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute User loginUser,
                               Errors errors, Model model) {

        String candidate = loginUser.getPassword();
        String hashed = userDao.findByEmail(loginUser.getEmail()).get().getPassword();

        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("It matches"); // TODO: create the user session
            return "user/logged-in";
        }

        System.out.println("It does not match");  // TODO: create error for failed login and pass to view
        return "user/login";
    }
}

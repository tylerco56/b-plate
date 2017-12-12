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
        String existingEmail = String.valueOf(userDao.findByEmail(newUserEmail));
        if (errors.hasErrors()) {
            return "user/add";

        } else if (existingEmail.equals(newUserEmail)) { // TODO: Deal with org.hibernate.exception.ConstraintViolationException
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
    public String processLogin(@ModelAttribute @Valid User loginUser,
                               Errors errors, Model model, @RequestParam String email) {

        String candidate = loginUser.getPassword();
        String hashed = String.valueOf(userDao.findByEmail(email));

        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("It matches");
            return "user/logged-in";
        }

        System.out.println("It does not match");
        return "user/login";
    }
}




//    // Hash a password for the first time
//    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//
//    // gensalt's log_rounds parameter determines the complexity
//// the work factor is 2**log_rounds, and the default is 10
//    String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
//
//// Check that an unencrypted password matches one that has
//// previously been hashed
//if (BCrypt.checkpw(candidate, hashed))
//        System.out.println("It matches");
//        else
//        System.out.println("It does not match");
package com.wiedenman.b_plate.web.controllers;

import com.wiedenman.b_plate.web.Comparators.UsernameComparator;
import com.wiedenman.b_plate.web.model.*;
import com.wiedenman.b_plate.web.model.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    UserDao userDao;

    @RequestMapping(value = "users")
    public String index(Model model) {

        List<User> users = (List<User>) userDao.findAll();
        Collections.sort(users, new UsernameComparator());

        model.addAttribute("users", users);
        model.addAttribute("title", "ALL USERS");

        return "user/index";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String singleUser(Model model, @PathVariable long id) {

        User user = userDao.findOne(id);
        String formattedDate = user.getCreationDate().format(DateTimeFormatter.ofPattern("MMMM dd,  yyyy"));
        model.addAttribute("user", user);
        model.addAttribute("formattedDate", formattedDate);
        return "user/single"; // TODO: create html user/single
    }
}

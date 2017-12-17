package com.wiedenman.b_plate.web.controllers;

import com.wiedenman.b_plate.model.Page;
import com.wiedenman.b_plate.model.User;
import com.wiedenman.b_plate.service.PageService;
import com.wiedenman.b_plate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;

/**
 *   _                       _         _
 *  | |                     | |       | |
 *  | |__    ______   _ __  | |  __ _ | |_  ___
 *  | '_ \| |______| | '_ \ | | / _` || __|/ _ \
 *  | |_) |          | |_) || || (_| || |_|  __/
 *  |_.__/           | .__/ |_| \__,_| \__|\___|
 *      	         | |
 *  			     |_|
 *
 * @author by Landon Wiedenman - github.com/landongw/b-plate
 *
 * License: for personal non-commercial use only.  Please contact me for commercial uses.
 *
 * */

@Controller
@RequestMapping("page")
public class PageController {

    @Autowired
    private PageService pageService;


    @Autowired
    private UserService userService;

    @RequestMapping(value = "index")
    public String index(Model model, Principal principal) {
        Iterable<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);
        model.addAttribute("title", "pages");

        return "page/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String singlePage(Model model, @PathVariable long id, Principal principal) {

        Page page = pageService.findOne(id);
        model.addAttribute("page", page);
        model.addAttribute("title", page.getName());

        return "page/single";
    }

    @RequestMapping(path = "private-page", method = RequestMethod.POST)
    public String addTask(@ModelAttribute Page page, Principal principal) {
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        page.setPrivateUser(user.getId());
        pageService.save(page);
        return "page/single";
    }
}

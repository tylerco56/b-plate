package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.web.model.Page;
import com.wiedenman.b_plate.service.PageService;
import com.wiedenman.b_plate.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

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
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "pages")
    public String index(Model model) {
        Iterable<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);
        model.addAttribute("title", "PAGES");

        return "page/index";
    }

    @RequestMapping(value = "p-{url}", method = RequestMethod.GET)
    public String singlePage(Model model, @PathVariable String url) {

        Page page = pageService.findByUrl(url);
        model.addAttribute("page", page);
        model.addAttribute("title", page.getName());

        return "page/single";
    }

    @RequestMapping(value = "page-new")
    public String newPage(Model model) {

        Page page = new Page();
        model.addAttribute("title", "NEW PAGE");
        model.addAttribute("page", page);

        return "page/edit";
    }

    @RequestMapping(path = "/save-new-page", method = RequestMethod.POST)
    public String saveNewPage(@ModelAttribute @Valid Page newPage,
                              Errors errors,
                              Model model,
                              Principal principal) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "NEW PAGE");

            return "page/edit";
        }
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        newPage.setAuthor(user);
        newPage.setUpdated();
        pageService.save(newPage);

        return "page/edit";
    }

    @RequestMapping(value = "page-edit-{id}")
    public String editPage(Model model, @PathVariable long id) {

        Page page = pageService.findOne(id);
        model.addAttribute("title", "EDIT PAGE");
        model.addAttribute("page", page);

        return "page/edit";
    }

    @RequestMapping(path = "/save-page-{id}", method = RequestMethod.POST)
    public String savePage(@ModelAttribute @Valid Page page,
                           Errors errors,
                           Model model,
                           Principal principal) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "EDIT PAGE");
            model.addAttribute("page", page);
            return "page/edit";
        }
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        page.setAuthor(user);
        page.setUpdated();
        pageService.save(page);

        return "page/edit";
    }
}

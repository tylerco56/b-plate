package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.web.model.Page;
import com.wiedenman.b_plate.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "page-{id}", method = RequestMethod.GET)
    public String singlePage(Model model, @PathVariable long id) {

        Page page = pageService.findOne(id);
        model.addAttribute("page", page);
        model.addAttribute("title", page.getName());

        return "page/single";
    }
}

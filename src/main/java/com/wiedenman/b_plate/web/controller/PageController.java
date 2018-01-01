package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.exception.UrlExistsException;
import com.wiedenman.b_plate.web.model.Page;
import com.wiedenman.b_plate.service.PageService;
import com.wiedenman.b_plate.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
        return "page/new";
    }

    @RequestMapping(value = "page-new", method = RequestMethod.POST)
    public String saveNewPage(@ModelAttribute @Valid Page newPage,
                              final BindingResult result,
                              Errors errors,
                              Model model,
                              Principal principal) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "NEW PAGE");
            return "page/new";
        } try {
            User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            newPage.setAuthor(user);
            newPage.setUpdated();
            pageService.createNewPage(newPage);
            long id = newPage.getId();
            return "redirect:page-edit-" + id;
        } catch (UrlExistsException e) {
            result.addError(new FieldError("page", "url", e.getMessage()));
            model.addAttribute("page", newPage);
            return "page/new";
        }
    }

    @RequestMapping(value = "page-edit-{id}")
    public String editPage(Model model, @PathVariable long id) {

        Page page = pageService.findOne(id);
        model.addAttribute("title", "EDIT PAGE");
        model.addAttribute("page", page);

        return "page/edit";
    }

    @RequestMapping(value = "page-edit", method = RequestMethod.POST)
    public String processSavePage(@ModelAttribute @Valid Page page,
                           final BindingResult result,
                           Errors errors,
                           Model model,
                           Principal principal) {

        model.addAttribute("title", "EDIT PAGE");

        if (errors.hasErrors()) {
            model.addAttribute("page", page);
            return "page/edit";
        } try {
            User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            page.setAuthor(user);
            page.setUpdated();
            pageService.save(page);

            return "page/edit";
        } catch (UrlExistsException e) {
            result.addError(new FieldError("page", "url", e.getMessage()));
            model.addAttribute("page", page);
            return "page/edit";
        }
    }

    @RequestMapping(value = "page-delete", method = RequestMethod.POST)
    public String deletePage(@RequestParam long page_id) {

        pageService.delete(pageService.findOne(page_id));
        return "redirect:pages";
    }
}

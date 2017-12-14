package com.wiedenman.foundry_0_1.web.controllers;

import com.wiedenman.foundry_0_1.model.Page;
import com.wiedenman.foundry_0_1.model.User;
import com.wiedenman.foundry_0_1.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("page")
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "index")
    public String index(Model model) {
        Iterable<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);
        model.addAttribute("title", "Pages");

        return "page/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String singlePage(Model model, @PathVariable long id) {

        Page page = pageService.findOne(id);
//        String formattedDate = page.getPublished().format(DateTimeFormatter.ofPattern("MMMM dd,  yyyy"));
        model.addAttribute("page", page);
        model.addAttribute("title", page.getName());
//        model.addAttribute("formattedDate", formattedDate);
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

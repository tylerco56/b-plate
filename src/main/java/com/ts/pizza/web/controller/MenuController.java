package com.ts.pizza.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menu")
public class MenuController {

    @RequestMapping(value = "")
    public String index() {

        return "pizza/menu";
    }
}
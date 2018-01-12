package com.ts.pizza.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping(value = "")
    public String index() {

        return "pizza/order";
    }
}
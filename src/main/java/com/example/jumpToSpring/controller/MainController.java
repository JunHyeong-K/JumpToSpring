package com.example.jumpToSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.GetExchange;

@Controller
public class MainController {

    @GetMapping("/jump")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }





}

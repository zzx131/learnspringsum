package com.zzx.springbootbasedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LonginController {

    @GetMapping("/login")
    public void login() {
        System.out.println("hello word");
    }

    @RequestMapping(value = "/index/{number}")
    public String index(@PathVariable int number) {
        return "get index page successfully.";
    }
}

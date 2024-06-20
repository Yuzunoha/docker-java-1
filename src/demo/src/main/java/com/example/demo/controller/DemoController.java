package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public String test() {
        final var s = demoService.test();
        return s;
    }

}

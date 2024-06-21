package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @RequestMapping("/")
    public String test() {
        final var s = demoService.test();
        return s;
    }

    @RequestMapping("calc")
    public String calc() {
        return demoService.calc();
    }
}

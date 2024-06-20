package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String test() {
        final var s = "DemoServiceサービスです";
        return s;
    }

}

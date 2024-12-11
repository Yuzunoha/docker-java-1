package com.example.demo.controller;

import com.example.demo.service.DemoService;
import com.example.demo.service.Test1Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

  private final DemoService demoService;
  private final Test1Service test1Service;

  @RequestMapping("/")
  public String test() {
    final var s = demoService.test();
    return s;
  }

  @RequestMapping("calc")
  public String calc() {
    return demoService.calc();
  }

  @RequestMapping("testDynamoDb")
  public String testDynamoDb() {
    return demoService.testDynamoDb();
  }

  @RequestMapping("test1")
  public String test1() {
    var result = test1Service.test1Method1();
    return result;
  }
}

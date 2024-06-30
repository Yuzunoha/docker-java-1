package com.example.demo.controller;

import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @RequestMapping("testDynamoDb")
  public String testDynamoDb() {
    return demoService.testDynamoDb();
  }
}

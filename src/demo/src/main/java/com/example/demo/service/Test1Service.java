package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Test1Service {
  public String test1Method1() {
    return "test1Method1()です。";
  }
}

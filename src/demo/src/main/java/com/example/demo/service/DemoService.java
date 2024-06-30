package com.example.demo.service;

import lombok.RequiredArgsConstructor;

import java.util.function.BiPredicate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

  private final DynamoDbService dynamoDbService;

  public String test() {
    return "hello";
  }

  public String testDynamoDb() {
    // 書き込み
    this.dynamoDbService.randomPut();
    // 結果の返却
    return this.dynamoDbService.getAmazonDynamoDB().listTables().toString();
  }

  public String calc() {
    BiPredicate<Integer, Integer> calcSub = (a, b) -> {
      int left = (70 * a) + (80 * b);
      int right = 78 * (a + b);
      boolean result = (left == right);
      return result;
    };
    for (int a = 11; a < 1000; a++) {
      for (int b = 10; b < 1000; b++) {
        if (calcSub.test(a, b)) {
          return "A中学は " + a + " 人かつB中学は " + b + " 人";
        }
      }
    }
    return "解なし";
  }

}

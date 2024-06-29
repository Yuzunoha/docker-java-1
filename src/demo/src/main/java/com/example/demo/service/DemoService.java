package com.example.demo.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import java.util.function.BiPredicate;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  private AmazonDynamoDB amazonDynamoDB = null;

  public String test() {
    return "hello";
  }

  public String testDynamoDb() {
    return this.getAmazonDynamoDB().listTables().getTableNames().toString();
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

  public AmazonDynamoDB getAmazonDynamoDB() {
    if (null != this.amazonDynamoDB) {
      return this.amazonDynamoDB;
    }

    final AWSCredentialsProvider providers = new AWSCredentialsProviderChain(
        new EnvironmentVariableCredentialsProvider(),
        new ClasspathPropertiesFileCredentialsProvider(),
        new ProfileCredentialsProvider(),
        new EC2ContainerCredentialsProviderWrapper());
    final String endpoint = "http://dynamodb-local:8000";
    final String region = "dummy";
    final AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.setCredentials(providers);

    builder.setEndpointConfiguration(
        new EndpointConfiguration(endpoint, region));

    this.amazonDynamoDB = builder.build();
    return this.amazonDynamoDB;
  }
}

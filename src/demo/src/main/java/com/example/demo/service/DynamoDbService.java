package com.example.demo.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

@Service
public class DynamoDbService {

  private AmazonDynamoDB amazonDynamoDB = null;

  public AmazonDynamoDB getAmazonDynamoDB() {
    if (null != this.amazonDynamoDB) {
      return this.amazonDynamoDB;
    }

    final AWSCredentialsProvider providers = new AWSCredentialsProviderChain(
        new EnvironmentVariableCredentialsProvider(),
        new ClasspathPropertiesFileCredentialsProvider(),
        new ProfileCredentialsProvider(),
        new EC2ContainerCredentialsProviderWrapper());
    final String endpoint = System.getenv("DYNAMODB_ENDPOINT");
    final String region = System.getenv("AWS_DEFAULT_REGION");
    final AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.setCredentials(providers);

    builder.setEndpointConfiguration(
        new EndpointConfiguration(endpoint, region));

    this.amazonDynamoDB = builder.build();
    return this.amazonDynamoDB;
  }

  public void randomPut() {
    HashMap<String, AttributeValue> hashMap = new HashMap<String, AttributeValue>();
    hashMap.put("pk1", new AttributeValue("TestPk"));
    var sk1 = new AttributeValue();
    sk1.setN("" + (int) (Math.random() * 10000));
    hashMap.put("sk1", sk1);
    try {
      this.getAmazonDynamoDB().putItem("TestTable1", hashMap);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
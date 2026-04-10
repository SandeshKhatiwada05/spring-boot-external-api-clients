package com.apiconsume.webclientways.controller;

import com.apiconsume.webclientways.RecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getOneData")
    public RecordEntity restTemplateAPIConsume() {
        return this.restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/2",
                RecordEntity.class);
    }

    @PostMapping("/posts")
    public RecordEntity postData() {
        RecordEntity dataResponse = new RecordEntity(102, 1, "Hi hello", "Hello how are you?");
        return this.restTemplate.postForObject(
                "https://jsonplaceholder.typicode.com/posts",
                dataResponse,
                RecordEntity.class
        );
    }
}

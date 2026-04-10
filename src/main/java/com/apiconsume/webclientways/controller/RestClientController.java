package com.apiconsume.webclientways.controller;

import com.apiconsume.webclientways.RecordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
public class RestClientController {

    @Autowired
    private RestClient restClient;

    @GetMapping("/getRestClient")
    public RecordEntity getRecordViaRestClient(){
        RecordEntity recordViaRestClientProcess = restClient
                .get()
                .uri("jsonplaceholder.typicode.com/posts/3")
                .retrieve()
                .body(RecordEntity.class);
        log.info("Record of id:3 {}", recordViaRestClientProcess);
        return recordViaRestClientProcess;
    }
}

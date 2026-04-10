package com.apiconsume.webclientways.controller;

import com.apiconsume.webclientways.RecordEntity;
import com.apiconsume.webclientways.config.PostHTTPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTTPExchangeController {

    private static final Logger log = LoggerFactory.getLogger(HTTPExchangeController.class);
    @Autowired
    private PostHTTPService postHTTPService;

    @GetMapping("/{id}")
    public RecordEntity getRecordForHttpExchange(@PathVariable Integer id){
        RecordEntity record = postHTTPService.getRecord(id);
        log.info("/nRecord in HTTP Exchange {}", record);
        return record;
    }

}

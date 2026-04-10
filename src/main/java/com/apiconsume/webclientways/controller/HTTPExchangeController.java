package com.apiconsume.webclientways.controller;

import com.apiconsume.webclientways.RecordEntity;
import com.apiconsume.webclientways.config.PostHTTPService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HTTPExchangeController {

    @Autowired
    private PostHTTPService postHTTPService;

    @GetMapping("/{id}")
    public RecordEntity getRecordForHttpExchange(@PathVariable Integer id){
        RecordEntity recordForHttpExchange = postHTTPService.getRecord(id);
        log.info("/nRecord in HTTP Exchange {}", recordForHttpExchange);
        return recordForHttpExchange;
    }

}

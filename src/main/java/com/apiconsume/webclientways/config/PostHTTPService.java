package com.apiconsume.webclientways.config;

import com.apiconsume.webclientways.RecordEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange(url = "https://jsonplaceholder.typicode.com/posts")
public interface PostHTTPService {

    @GetExchange("/{id}")
    RecordEntity getRecord(@PathVariable Integer id);

    @PostExchange
    RecordEntity postRecord(@RequestBody RecordEntity recordEntity);

    @GetExchange
    List<RecordEntity> allRecords();
}

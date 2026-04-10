package com.apiconsume.webclientways.controller;

import com.apiconsume.webclientways.RecordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class WebClientController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/getWebClient")
    public RecordEntity webClientAPIConsume() throws InterruptedException {
        Mono<RecordEntity> monoRecordEntity = webClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts/3")
                .retrieve()
                .bodyToMono(RecordEntity.class);
        Thread.sleep(2000);
        monoRecordEntity.subscribe(item-> log.info(item.title()));
        return monoRecordEntity.block();
    }

    @PostMapping("/postWebClient")
    public RecordEntity webClienttPost(){
        return webClient
                .post()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .bodyValue(new RecordEntity(99, 2, "Avra kadabra", "Harry Potter was a good movie"))
                .retrieve()
                .bodyToMono(RecordEntity.class)
                .block();
    }
}

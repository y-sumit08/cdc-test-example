package com.example.cdctestexample.client;

import com.example.cdctestexample.model.CreateKafkaConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class KafkaConnectWebClient {

    @Autowired
    private WebClient webClient;

    public CreateKafkaConnector createConnector(CreateKafkaConnector request) {
        log.info("calling the create connector api of kafka connect rest service");
        return webClient.post()
                .uri("/connectors")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(request), CreateKafkaConnector.class)
                .retrieve()
                .bodyToMono(CreateKafkaConnector.class)
                .block();
    }

    public void deleteConnector(String connectorName) {
        log.info("calling the delete connector api of kafka connect rest service");
        webClient.delete()
                .uri("connectors")
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public CreateKafkaConnector retrieveStatus(String connectorName) {
        log.info("calling the retrieve connector status api of kafka connect rest service");
        return webClient.get()
                .uri("connectors/" + connectorName + "/status")
                .retrieve()
                .bodyToMono(CreateKafkaConnector.class)
                .block();
    }

}

package com.example.cdctestexample.controller;

import com.example.cdctestexample.client.KafkaConnectWebClient;
import com.example.cdctestexample.model.CreateKafkaConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sumit Yadav
 * Description: Controller class to expose different REST endpoints of Debezium connector api
 */

@RestController
@Slf4j
public class DebeziumConnectorApi {

    @Autowired
    private KafkaConnectWebClient kafkaConnectWebClient;


    @PostMapping(value = "/connectors/startStreaming", consumes = "application/json", produces = "application/json")
    public CreateKafkaConnector createConnector(@RequestBody CreateKafkaConnector kafkaConnectorRequest) {
        log.info("Request received by DebeziumConnectorApi to start streaming the data from database");
        try {
            return kafkaConnectWebClient.createConnector(kafkaConnectorRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @DeleteMapping(value = "/connectors/{connector-name}/stopStreaming")
    public void deleteConnector(@PathVariable("connector-name") String connectorName) {
        log.info("Request received by DebeziumConnectorApi to stop streaming the data from database");
        try {
            kafkaConnectWebClient.deleteConnector(connectorName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @GetMapping(value = "/connectors/{connector-name}/streamingStatus", produces = "application/json")
    public CreateKafkaConnector getConnectorStatus(@PathVariable("connector-name") String connectorName) {
        log.info("Request received by DebeziumConnectorApi to fetch the streaming status");
        try {
            return kafkaConnectWebClient.retrieveStatus(connectorName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

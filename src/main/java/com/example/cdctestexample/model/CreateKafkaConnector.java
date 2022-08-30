package com.example.cdctestexample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateKafkaConnector {
    @JsonProperty
    private String name;
    @JsonProperty
    private Config config;
    @JsonProperty
    private Connector connector;
    @JsonProperty
    private List<Task> tasks;
    @JsonProperty
    private String type;
}

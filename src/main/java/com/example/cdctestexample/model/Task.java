package com.example.cdctestexample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    @JsonProperty
    private int id;
    @JsonProperty
    private String connector;
    @JsonProperty
    private String task;
    @JsonProperty
    private String state;
    @JsonProperty("worker_id")
    private String workerId;
}

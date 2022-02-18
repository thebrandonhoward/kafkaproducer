package com.example.kafkaproducer.collaborators.models;

import lombok.Data;

@Data
public class IncomingMessage {
    private String topic;
    private String key;
    private String value;
}

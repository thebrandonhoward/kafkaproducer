package com.example.kafkaproducer.collaborators.models;

import lombok.Builder;
import lombok.Data;

//@Builder(builderClassName = "builder")
@Data
public class Invoice {

    private long id;
    private double netAmount;
    private double taxAmount;
    private double totalAmount;
}


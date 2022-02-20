package com.example.kafkaproducer.implementations.controllers;

import com.example.kafkaproducer.collaborators.models.IncomingInvoice;
import com.example.kafkaproducer.implementations.services.KafkaProducerService;
import com.example.kafkaproducer.utilities.InvoiceGeneratorUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InvoiceGeneratorRestController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/generate")
    public ResponseEntity generate(@RequestBody IncomingInvoice incomingInvoice) {
        kafkaProducerService.sendMessage("invoice", incomingInvoice.getId(), InvoiceGeneratorUtility.getNextInvoice(incomingInvoice.getId()));
        return ResponseEntity.ok().build();
    }
}

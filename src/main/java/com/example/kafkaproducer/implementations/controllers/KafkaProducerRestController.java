package com.example.kafkaproducer.implementations.controllers;

import com.example.kafkaproducer.collaborators.models.IncomingMessage;
import com.example.kafkaproducer.implementations.services.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaProducerRestController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/message")
    public ResponseEntity message(@RequestBody IncomingMessage incomingMessage) {
        kafkaProducerService.sendMessage(incomingMessage.getTopic(), incomingMessage.getKey(), incomingMessage.getValue());
        return ResponseEntity.ok().build();
    }
}

package com.example.kafkaproducer.implementations.services;

import com.example.kafkaproducer.collaborators.models.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Invoice> kafkaTemplate2;

    public void sendMessage(String topic, String key, String value) {
        log.info("({}) -> ({})", key, topic);

        kafkaTemplate.send(topic, key, value);
    }

    @SneakyThrows
    public void sendMessage(String topic, long key, Invoice value) {
        log.info("({}) -> ({})", key, topic);

        kafkaTemplate2.send(topic, Long.toString(key), value);
    }

}

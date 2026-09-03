package org.group2.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(topic, message);
    }
}

package org.group2.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Consumer {
    private List<String> messages = new ArrayList<>();

    public String getLastMessage() {
        Optional<String> lastElement = Optional.of(messages)
                .filter(l -> !l.isEmpty())
                .map(l -> l.get(l.size() - 1));

        return lastElement.orElse("Список сообщений пуст!");
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("Получено сообщение: " + message);
        messages.add(message);
    }
}

package org.group2.controller;

import lombok.SneakyThrows;
import org.group2.kafka.Consumer;
import org.group2.kafka.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BoomqController {

    private final Producer producer;
    private final Consumer consumer;

    public BoomqController(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @SneakyThrows
    @GetMapping
    public String boomqStub(@RequestParam("message") String message) {
        producer.send(message);

        Thread.sleep(3000);

        return consumer.getLastMessage();
    }
}

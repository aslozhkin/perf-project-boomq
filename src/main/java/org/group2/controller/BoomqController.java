package org.group2.controller;

import lombok.SneakyThrows;
import org.group2.kafka.Consumer;
import org.group2.kafka.Producer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class BoomqController {
    public static final String BASE_PATH = "api/v1";
    private int delay = 3000;

    private final Producer producer;
    private final Consumer consumer;

    public BoomqController(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    /**
     * Заглушка для интеграции int1
     * @param message передаваемое сообщение, пишется в кафку
     * @return возвращает полученное сообщение, прочитанное из кафки и добавляет к нему рандомный UUID
     */
    @SneakyThrows
    @GetMapping(BASE_PATH + "/int1")
    public String boomqStub(@RequestParam("message") String message) {
        producer.send(message);

        Thread.sleep(delay);

        return consumer.getLastMessage() + UUID.randomUUID();
    }

    /**
     * Ручка, что устанавливать время задержки ответа
     * @param delay задержка, передается в секундах
     */
    @PostMapping(BASE_PATH + "/delay")
    public void changeDelay(@RequestParam("delay") int delay) {
        this.delay = delay * 1000;
    }
}

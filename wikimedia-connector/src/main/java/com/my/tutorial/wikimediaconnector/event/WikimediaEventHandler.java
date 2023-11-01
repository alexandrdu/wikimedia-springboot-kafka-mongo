package com.my.tutorial.wikimediaconnector.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class WikimediaEventHandler {

    @Value("${my.tutorial.wikimedia.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaEventHandler(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(String data) {
        kafkaTemplate.send(topic, data);
    }
}

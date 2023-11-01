package com.my.tutorial.wikimediaeventconsumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.tutorial.wikimedia.generated.WikimediaEvent;
import com.my.tutorial.wikimediaeventconsumer.entity.WikimediaEventDocument;
import com.my.tutorial.wikimediaeventconsumer.repository.WikimediaRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class WikimediaConsumer {

    private final WikimediaRepository repository;
    private final ObjectMapper objectMapper;

    public WikimediaConsumer(WikimediaRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${my.tutorial.wikimedia.kafka.topic}", groupId = "wikimedia")
    public void consumeEvent(String data) {
        try {
            WikimediaEvent event = objectMapper.readValue(data, WikimediaEvent.class);
            WikimediaEventDocument document = new WikimediaEventDocument();
            document.setPayload(event);
            repository.save(document);
        } catch (JsonProcessingException e) {
            log.error(String.format("Failed to parse event %s", data), e);
        }
    }

}

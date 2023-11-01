package com.my.tutorial.wikimediaconnector.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.my.tutorial.wikimediaconnector.event.WikimediaEventHandler;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Component
@Log4j2
public class WikiMediaSubscriber {

    private final WebClient client;

    private final WikimediaEventHandler eventHandler;

    public WikiMediaSubscriber(WebClient client, WikimediaEventHandler eventHandler) {
        this.client = client;
        this.eventHandler = eventHandler;
    }

    public void subscribe() {
        ParameterizedTypeReference<ServerSentEvent<String>> type
            = new ParameterizedTypeReference<>() {};
        Flux<ServerSentEvent<String>> eventStream = client.get().retrieve().bodyToFlux(type);

        eventStream.subscribe(content -> {
            log.info("Wikimedia event received -> {}", content.data());
            eventHandler.produceMessage(content.data());
        });
    }
}

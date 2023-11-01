package com.my.tutorial.wikimediaconnector.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WikimediaConnectorConfig {

    @Bean
    public NewTopic wikimediaTopic(@Value("${my.tutorial.wikimedia.kafka.topic}") String topic) {
        return TopicBuilder.name(topic).build();
    }

    @Bean
    public WebClient wikimediaClient(@Value("${my.tutorial.wikimedia.client.url}") String url) {
        return WebClient.create(url);
    }

}

package com.my.tutorial.wikimediaconnector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.my.tutorial.wikimediaconnector.client.WikiMediaSubscriber;

@SpringBootApplication
public class WikimediaConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikimediaConnectorApplication.class);
    }

    @Bean
    public CommandLineRunner run(WikiMediaSubscriber subscriber) {
        return args -> subscriber.subscribe();
    }

}

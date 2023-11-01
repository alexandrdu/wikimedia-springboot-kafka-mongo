package com.my.tutorial.wikimediaeventconsumer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.my.tutorial.wikimedia.generated.WikimediaEvent;

import lombok.Data;

@Data
@Document(collection = "wikimedia_event")
public class WikimediaEventDocument {

    @Id
    private String id;

    private WikimediaEvent payload;

}

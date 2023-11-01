package com.my.tutorial.wikimediaeventconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.my.tutorial.wikimediaeventconsumer.entity.WikimediaEventDocument;

public interface WikimediaRepository extends MongoRepository<WikimediaEventDocument, Integer> {}

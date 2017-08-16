package com.boot.app.repository;


import com.boot.app.model.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BeerRepository extends MongoRepository<Beer, Long> {
    List<Beer> findAllByName(String name);
}
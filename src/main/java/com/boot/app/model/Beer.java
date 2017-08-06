package com.boot.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "beers")
public class Beer {

    @Id
    private int id;
    private String name;
    private String producer;
    private String country;
    private double volume;
    private LocalDate tasteDate;
}
package com.boot.app.controller;

import com.boot.app.model.Beer;
import com.boot.app.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final BeerService beerService;

    @GetMapping("/get")
    public Iterable<Beer> getAll() {
        return beerService.getAll();
    }

    @GetMapping("/get/name/{name}")
    public List<Beer> getByName(@PathVariable String name) {
        return beerService.getByName(name);
    }

    @GetMapping("/get/{id}")
    public Beer get(@PathVariable Long id) {
        return beerService.getById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<String> newBeer(@RequestBody Beer beer) {
        beerService.save(beer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
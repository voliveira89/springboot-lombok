package com.boot.app.controller;

import com.boot.app.model.Beer;
import com.boot.app.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.boot.app.controller.ApiController.API_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_ENDPOINT)
public class ApiController {

    static final String API_ENDPOINT = "/beer";

    private final BeerService beerService;

    @GetMapping("/{id}")
    public Beer get(@PathVariable Long id) {
        return beerService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Beer> getByName(@PathVariable String name) {
        return beerService.getByName(name);
    }

    @GetMapping
    public Iterable<Beer> getAll() {
        return beerService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> newBeer(@RequestBody Beer beer) throws URISyntaxException {
        Beer newBeer = beerService.save(beer);
        return ResponseEntity.created(new URI(API_ENDPOINT + "/get/" + newBeer.getId())).build();
    }
}

package com.boot.app.service;

import com.boot.app.model.Beer;
import com.boot.app.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    @Transactional(readOnly = true)
    public Iterable<Beer> getAll() {
        return beerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Beer> getByName(String name) {
        return beerRepository.findAllByName(name);
    }

    @Transactional(readOnly = true)
    public Beer getById(Long id) {
        return beerRepository.findOne(id);
    }

    @Transactional
    public Beer save(Beer beer) {
        return beerRepository.save(beer);
    }
}
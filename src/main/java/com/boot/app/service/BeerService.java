package com.boot.app.service;

import com.boot.app.model.Beer;
import com.boot.app.repository.BeerRepository;
import lombok.NonNull;
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
    public List<Beer> getByName(@NonNull String name) {
        return beerRepository.findAllByName(name);
    }

    @Transactional(readOnly = true)
    public Beer getById(@NonNull Long id) {
        return beerRepository.findOne(id);
    }

    @Transactional
    public Beer save(@NonNull Beer beer) {
        return beerRepository.save(beer);
    }
}

package com.company.web.springdemo.controllers;

import com.company.web.springdemo.models.Beer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/beers")
public class BeerRestController {

    private final List<Beer> beers;

    public BeerRestController() {
        beers = new ArrayList<>();

        beers.add(new Beer(1, "Glarus English Ale", 4.6));
        beers.add(new Beer(2, "Rhombus Porter", 5.0));
    }

    @GetMapping
    public List<Beer> get() {
        return beers;
    }

    @GetMapping("/{id}")
    public Beer get(@PathVariable int id) {
        return getByIdHelper(id);
    }

    @PostMapping
    public Beer create(@Valid @RequestBody Beer beer) {
        beers.add(beer);
        return beer;
    }

    @PutMapping("/{id}")
    public Beer update(@PathVariable int id, @Valid @RequestBody Beer beer) {
        Beer beerToUpdate = getByIdHelper(id);

        beerToUpdate.setName(beer.getName());
        beerToUpdate.setAbv(beer.getAbv());

        return beerToUpdate;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Beer beerToDelete = getByIdHelper(id);
        beers.remove(beerToDelete);
    }

    private Beer getByIdHelper(int id) {
        return beers.stream()
                .filter(beer -> beer.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Beer with id %d not found.", id)));
    }

}

package com.fer.insus.vin.rest;

import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.service.WineService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/wine")
public class WineController {

    private WineService wineService;

    @GetMapping
    public ResponseEntity<List<Wine>> getAllWines() {
        var wineList = wineService.getAllWines();
        return new ResponseEntity<>(wineList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wine> getWineById(@PathVariable Long id) {
        var wine = wineService.getWineById(id);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addNewWine(@Valid @RequestBody AddWineRequest addNewWineRequest) {
        wineService.addWine(addNewWineRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWineWithId(@PathVariable Long id) {
        wineService.deleteWineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateWineWithId(@PathVariable Long id ){
        // TODO update, dodat mapper
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

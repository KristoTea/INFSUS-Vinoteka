package com.fer.insus.vin.rest;

import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.service.SortService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sort")
@AllArgsConstructor
public class SortController {

    private SortService sortService;

    @GetMapping
    public ResponseEntity<List<Sort>> getAllSorts() {
        var sortList = sortService.getAllSorts();
        return new ResponseEntity<>(sortList, HttpStatus.OK);
    }
}

package com.fer.insus.vin;

import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.service.SortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SortServiceTests {

    @Autowired
    SortService sortService;

    @Test
    void shouldGetAllSortsSuccessfully() {
        // Given

        // When
        var sortsList = sortService.getAllSorts();

        // Then
        for (Sort sort : sortsList) {
            System.out.println(sort);
        }
    }
}

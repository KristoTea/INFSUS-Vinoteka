package com.fer.insus.vin.service.impl;

import com.fer.insus.vin.dao.SortRepository;
import com.fer.insus.vin.domain.Sort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SortServiceTests {

    private SortServiceJpa sortServiceJpa;

    @Mock
    private SortRepository sortRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sortServiceJpa = new SortServiceJpa(sortRepository);
    }

    @Test
    void testGetAllSorts() {
        // Given
        List<Sort> expectedSortList = new ArrayList<>();
        expectedSortList.add(createSort(1L, "Sort1", "Sort description"));
        expectedSortList.add(createSort(2L, "Sort2", "Sort description"));

        when(sortRepository.findAll()).thenReturn(expectedSortList);

        // When
        List<Sort> actualSortList = sortServiceJpa.getAllSorts();

        // Then
        assertEquals(expectedSortList, actualSortList);
    }

    private Sort createSort(Long id, String name, String description) {
        Sort sort = new Sort();
        sort.setId(id);
        sort.setName(name);
        sort.setDescription(description);
        return sort;
    }
}

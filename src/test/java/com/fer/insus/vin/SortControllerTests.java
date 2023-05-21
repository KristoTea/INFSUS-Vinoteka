package com.fer.insus.vin;

import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.rest.SortController;
import com.fer.insus.vin.service.SortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SortControllerTests {

    private SortController sortController;

    @Mock
    private SortService sortService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sortController = new SortController(sortService);
    }

    @Test
    void testGetAllSorts() {
        // Prepare
        List<Sort> expectedSortList = new ArrayList<>();
        expectedSortList.add(createSort(1L, "Sort1", "Sort1 Description"));
        expectedSortList.add(createSort(2L, "Sort2", "Sort2 Description"));

        when(sortService.getAllSorts()).thenReturn(expectedSortList);

        // Execute
        ResponseEntity<List<Sort>> response = sortController.getAllSorts();

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedSortList, response.getBody());
    }

    private Sort createSort(Long id, String name, String description) {
        Sort sort = new Sort();
        sort.setId(id);
        sort.setName(name);
        sort.setDescription(description);
        return sort;
    }
}

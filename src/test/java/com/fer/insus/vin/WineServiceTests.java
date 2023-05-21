package com.fer.insus.vin;

import com.fer.insus.vin.dao.SortRepository;
import com.fer.insus.vin.dao.WineRepository;
import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.WineRequest;
import com.fer.insus.vin.service.impl.WineServiceJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class WineServiceTests {
    @Mock
    private WineRepository wineRepository;

    @Mock
    private SortRepository sortRepository;

    private WineServiceJpa wineService;

    @BeforeEach
    void setup() {
        wineService = new WineServiceJpa(wineRepository, sortRepository);
    }

    @Test
    void testGetAllWines() {
        // Given
        var expectedWines = new ArrayList<Wine>();
        expectedWines.add(createWine(1L));
        expectedWines.add(createWine(2L));

        when(wineRepository.findAll()).thenReturn(expectedWines);

        // When
        var wines = wineService.getAllWines();

        // Then
        assertEquals(expectedWines, wines);
    }

    @Test
    void testGetWineById() {
        // Prepare
        Long wineId = 1L;
        var expectedWine = createWine(wineId);

        when(wineRepository.findById(wineId)).thenReturn(Optional.of(expectedWine));

        // Execute
        var wine = wineService.getWineById(wineId);

        // Verify
        assertEquals(expectedWine, wine);
    }

    @Test
    void testAddWine() {
        // Given
        var wineRequest = createWineRequest(1L);

        var sort = new Sort();
        sort.setId(1L);

        when(sortRepository.findById(anyLong())).thenReturn(Optional.of(sort));

        // When
        wineService.addWine(wineRequest);

        // Then
        verify(wineRepository, times(1)).save(any(Wine.class));
    }

    @Test
    void testDeleteWineById() {
        // Given
        var wineId = 1L;

        // When
        wineService.deleteWineById(wineId);

        // Then
        verify(wineRepository, times(1)).deleteById(wineId);
    }

    private WineRequest createWineRequest(Long id) {
        return new WineRequest("name"+id,
                2021,
                5.5,
                "maltster",
                "quality",
                "vineyard",
                10.0,
                "gastro_recommendation",
                "description",
                29.99,
                1L);
    }

    private Wine createWine(Long id) {
        return new Wine(id,
                "name"+id,
                2021,
                13.5,
                "maltster",
                "quality",
                "vineyard",
                10.0,
                "gastro_recommendation",
                "description",
                29.99,
                new Sort());
    }
}


package com.fer.insus.vin;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.WineController;
import com.fer.insus.vin.rest.WineRequest;
import com.fer.insus.vin.service.WineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class WineControllerTests {

    private WineController wineController;

    @Mock
    private WineService wineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wineController = new WineController(wineService);
    }

    @Test
    void testGetAllWines() {
        // Given
        var expectedWineList = new ArrayList<Wine>();
        expectedWineList.add(createWine(1L));
        expectedWineList.add(createWine(2L));

        when(wineService.getAllWines()).thenReturn(expectedWineList);

        // When
        var response = wineController.getAllWines();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedWineList, response.getBody());
    }

    @Test
    void testGetWineById() {
        // Given
        Long wineId = 1L;
        Wine expectedWine = createWine(wineId);

        when(wineService.getWineById(anyLong())).thenReturn(expectedWine);

        // When
        ResponseEntity<Wine> response = wineController.getWineById(wineId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedWine, response.getBody());
    }

    @Test
    void testAddNewWine() {
        // Given
        var wineRequest = new WineRequest("New Wine",
                                    2021,
                             13.5,
                                    "Maltster",
                                     "High",
                                    "Vineyard",
                            10.0,
                        "Gastro Recommendation",
                                "Description",
                                     29.99,
                                    1L);

        // When
        ResponseEntity<Void> response = wineController.addNewWine(wineRequest);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(wineService, times(1)).addWine(wineRequest);
    }

    @Test
    void testDeleteWineWithId() {
        // Given
        Long wineId = 1L;

        // When
        ResponseEntity<Void> response = wineController.deleteWineWithId(wineId);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(wineService, times(1)).deleteWineById(wineId);
    }

    @Test
    void testUpdateWineWithId() {
        // Given
        Long wineId = 1L;
        WineRequest wineRequest = new WineRequest("Updated Wine", 2022, 14.0, "Maltster", "High", "Vineyard",
                12.0, "Gastro Recommendation", "Description", 39.99, 1L);

        // When
        ResponseEntity<Void> response = wineController.updateWineWithId(wineId, wineRequest);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(wineService, times(1)).updateWine(wineId, wineRequest);
    }

    private Wine createWine(Long id) {
        return new Wine(id,
                "name",
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

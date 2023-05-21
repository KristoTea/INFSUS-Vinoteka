package com.fer.insus.vin.integration.tests;

import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.WineRequest;
import com.fer.insus.vin.service.WineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class WineIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WineService wineService;

    private List<Wine> wines;

    @BeforeEach
    void setup() {
        wines = new ArrayList<>();
        wines.add(new Wine(1L, "Wine1", 2020, 12.5, "Maltster1", "Good", "Vineyard1",
                10.0, "Recommendation1", "Description1", 10.0, new Sort()));
        wines.add(new Wine(2L, "Wine2", 2019, 13.0, "Maltster2", "Excellent", "Vineyard2",
                12.0, "Recommendation2", "Description2", 15.0, new Sort()));
    }

        @Test
        void testGetAllWines() throws Exception {
            when(wineService.getAllWines()).thenReturn(wines);

            mockMvc.perform(MockMvcRequestBuilders.get("/wine"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Wine1"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Wine2"))
                    .andDo(print());

            verify(wineService, times(1)).getAllWines();
        }

        @Test
        void testGetWineById() throws Exception {
            Long wineId = 1L;
            Wine expectedWine = wines.get(0);

            when(wineService.getWineById(wineId)).thenReturn(expectedWine);

            mockMvc.perform(MockMvcRequestBuilders.get("/wine/{id}", wineId))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Wine1"))
                    .andDo(print());

            verify(wineService, times(1)).getWineById(wineId);
        }


        @Test
        void testDeleteWineWithId() throws Exception {
            Long wineId = 1L;

            mockMvc.perform(MockMvcRequestBuilders.delete("/wine/{id}", wineId))
                    .andExpect(MockMvcResultMatchers.status().isNoContent())
                    .andDo(print());

            verify(wineService, times(1)).deleteWineById(wineId);
        }



    private WineRequest createWineRequest(String name) {
        return new WineRequest(name,
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

}

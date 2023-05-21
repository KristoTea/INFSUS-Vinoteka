package com.fer.insus.vin.service;


import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.domain.WineOrder;
import com.fer.insus.vin.rest.WineRequest;
import java.util.List;

public interface WineService {

    List<Wine> getAllWines();
    Wine getWineById(Long id);
    void addWine(WineRequest wineRequest);
    void deleteWineById(Long id);
    void updateWine(Long id, WineRequest wineRequest);
}

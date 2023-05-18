package com.fer.insus.vin.service;


import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.AddWineRequest;

import java.util.List;

public interface WineService {

    List<Wine> getAllWines();
    Wine getWineById(Long id);
    void addWine(AddWineRequest addWineRequest);
    void deleteWineById(Long id);
}

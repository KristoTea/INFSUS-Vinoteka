package com.fer.insus.vin.service.impl;

import com.fer.insus.vin.dao.SortRepository;
import com.fer.insus.vin.dao.WineRepository;
import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.AddWineRequest;
import com.fer.insus.vin.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WineServiceJpa implements WineService {

    private WineRepository wineRepository;

    private SortRepository sortRepository;

    @Override
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @Override
    public Wine getWineById(Long id) {
        return wineRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public void addWine(AddWineRequest addWineRequest) {
        var sort = sortRepository.findById(addWineRequest.sortId()).get();
        var wine = new Wine(addWineRequest.name(), addWineRequest.harvest(),
                addWineRequest.alcoholPercentage(), addWineRequest.maltster(),
                addWineRequest.quality(), addWineRequest.vineyard(),
                addWineRequest.temperatureOfServing(), addWineRequest.gastroRecommendation(),
                addWineRequest.description(), addWineRequest.price(), sort);
        wineRepository.save(wine);
    }

    @Override
    public void deleteWineById(Long id) {
        sortRepository.deleteById(id);
    }
}

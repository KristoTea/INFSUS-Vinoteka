package com.fer.insus.vin.service.impl;

import com.fer.insus.vin.dao.SortRepository;
import com.fer.insus.vin.dao.WineRepository;
import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.rest.WineRequest;
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
    public void addWine(WineRequest wineRequest) {
        var sort = sortRepository.findById(wineRequest.sortId()).get();
        var wine = new Wine(wineRequest.name(), wineRequest.harvest(),
                wineRequest.alcoholPercentage(), wineRequest.maltster(),
                wineRequest.quality(), wineRequest.vineyard(),
                wineRequest.temperatureOfServing(), wineRequest.gastroRecommendation(),
                wineRequest.description(), wineRequest.price(), sort);
        wineRepository.save(wine);
    }

    @Override
    public void deleteWineById(Long id) {
        wineRepository.deleteById(id);
    }

    @Override
    public void updateWine(Long id, WineRequest wineRequest) {
        var wine = wineRepository.findById(id).orElseThrow();
        updateWineElements(wine, wineRequest);
        wineRepository.save(wine);
    }

    private Wine updateWineElements(Wine wine, WineRequest wineRequest) {
        wine.setName(wineRequest.name());
        wine.setHarvest(wineRequest.harvest());
        wine.setAlcoholPercentage(wineRequest.alcoholPercentage());
        wine.setMaltster(wineRequest.maltster());
        wine.setQuality(wineRequest.quality());
        wine.setVineyard(wineRequest.vineyard());
        wine.setTemperatureOfServing(wineRequest.temperatureOfServing());
        wine.setGastroRecommendation(wineRequest.gastroRecommendation());
        wine.setDescription(wineRequest.description());
        wine.setPrice(wineRequest.price());
        var sort = sortRepository.findById(wineRequest.sortId()).get();
        wine.setSort(sort);

        return wine;
    }
}

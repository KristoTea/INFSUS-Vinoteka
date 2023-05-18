package com.fer.insus.vin.service.impl;

import com.fer.insus.vin.dao.SortRepository;
import com.fer.insus.vin.domain.Sort;
import com.fer.insus.vin.service.SortService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SortServiceJpa implements SortService {

    private SortRepository sortRepository;

    @Override
    public List<Sort> getAllSorts() {
        return sortRepository.findAll();
    }
}

package com.fer.insus.vin.rest;

import com.fer.insus.vin.domain.Sort;

public record WineInformation(Long id,
                              String name,
                              Integer harvest,
                              Double alcoholPercentage,
                              String maltster,
                              String quality,
                              String vineyard,
                              Double temperatureOfServing,
                              String gastroRecommendation,
                              String description,
                              Double price,
                              Sort sort) {
}

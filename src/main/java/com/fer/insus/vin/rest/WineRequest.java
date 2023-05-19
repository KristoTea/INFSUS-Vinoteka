package com.fer.insus.vin.rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record WineRequest(@NotBlank String name,
                          @NotNull Integer harvest,
                          @NotNull Double alcoholPercentage,
                          @NotBlank String maltster,
                          @NotBlank String quality,
                          @NotBlank String vineyard,
                          @NotNull Double temperatureOfServing,
                          @NotBlank String gastroRecommendation,
                          @NotBlank String description,
                          @NotNull Double price,
                          @NotBlank Long sortId) {
}
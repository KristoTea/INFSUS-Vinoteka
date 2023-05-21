package com.fer.insus.vin.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity(name = "wine")
@NoArgsConstructor
@AllArgsConstructor
public class Wine {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer harvest;

    private Double alcoholPercentage;

    private String maltster;

    private String quality;

    private String vineyard;

    private Double temperatureOfServing;

    private String gastroRecommendation;

    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name="sort_id")
    private Sort sort;

    @JsonManagedReference
    @ManyToMany(mappedBy = "wines")
    private List<WineOrder> orders;

    public Wine(String name, Integer harvest, Double alcoholPercentage,
                String maltster, String quality, String vineyard,
                Double temperatureOfServing, String gastroRecommendation,
                String description, Double price, Sort sort) {
        this.name = name;
        this.harvest = harvest;
        this.alcoholPercentage = alcoholPercentage;
        this.maltster = maltster;
        this.quality = quality;
        this.vineyard = vineyard;
        this.temperatureOfServing = temperatureOfServing;
        this.gastroRecommendation = gastroRecommendation;
        this.description = description;
        this.price = price;
        this.sort = sort;
    }
}

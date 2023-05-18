package com.fer.insus.vin.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity(name = "wine")
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

    @ManyToMany(mappedBy = "wines")
    private List<WineOrder> orders;
}

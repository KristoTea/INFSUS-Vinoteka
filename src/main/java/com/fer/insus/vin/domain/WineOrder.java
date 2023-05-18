package com.fer.insus.vin.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
// TODO anotacija za bilo kakav konstruktor
@Entity(name = "wine_order")
public class WineOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;

    @ManyToMany
    @JoinTable(
            name = "wineorder_wine",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "wine_id")
    )
    private List<Wine> wines;

    public WineOrder(OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public WineOrder() {

    }
}

enum OrderStatus {
    CREATED, PROCESSING, DELIVERED, CANCELED
}

enum PaymentMethod {
    CASH, CARD
}

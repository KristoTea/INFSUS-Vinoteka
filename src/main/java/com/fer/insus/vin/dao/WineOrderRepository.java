package com.fer.insus.vin.dao;

import com.fer.insus.vin.domain.WineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineOrderRepository extends JpaRepository<WineOrder, Long> {
}

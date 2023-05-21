package com.fer.insus.vin.dao;

import com.fer.insus.vin.domain.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {
}

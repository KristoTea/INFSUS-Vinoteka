package com.fer.insus.vin.dao;

import com.fer.insus.vin.domain.Wine;
import com.fer.insus.vin.domain.WineOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Long> {

    // TODO fix query
    // @Query("SELECT wineOrder FROM wine wine JOIN wine.orders wineOrder WHERE wine.id = :wineId")
    //List<WineOrder> findWineOrdersByWineId(@Param("wineId") Long wineId);
}

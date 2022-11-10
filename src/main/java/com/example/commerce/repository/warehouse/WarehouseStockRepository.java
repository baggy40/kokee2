package com.example.commerce.repository.warehouse;

import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WarehouseStockRepository extends JpaRepository<WarehouseStockEntity,Long> {

    @Query(value = "SELECT * FROM warehouse_stock_entity ORDER BY id desc limit 1", nativeQuery = true)
    public WarehouseStockEntity selectDescSQL();

}

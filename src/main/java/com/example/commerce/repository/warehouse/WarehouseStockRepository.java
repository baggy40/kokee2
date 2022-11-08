package com.example.commerce.repository.warehouse;

import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseStockRepository extends JpaRepository<WarehouseStockEntity,Long> {
}

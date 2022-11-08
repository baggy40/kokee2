package com.example.commerce.repository.warehouse;

import com.example.commerce.entity.warehouse.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity,Long> {
}

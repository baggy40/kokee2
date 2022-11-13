package com.example.commerce.repository.warehouse;

import com.example.commerce.entity.avg.AvgSUM;
import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WarehouseStockRepository extends JpaRepository<WarehouseStockEntity,Long> {

    @Query(value = "SELECT * FROM warehouse_stock_entity where item_id= :item_id and warehouse_id= :warehouse_id ORDER BY id desc limit 1", nativeQuery = true)
    public WarehouseStockEntity selectDescSQL(@Param("item_id") Long item_id, @Param("warehouse_id") Long warehouse_id);

    @Query(value = "SELECT ROUND(AVG(a.stock)) as coff_avg " +
            "FROM warehouse_stock_entity a " +
            "INNER JOIN item_entity b " +
            "on a.item_id = b.item_id " +
            "WHERE b.product_gubun = '커피' " +
            "GROUP by b.product_gubun", nativeQuery = true)
    public AvgSUM coffAvg();
}

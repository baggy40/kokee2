package com.example.commerce.repository;

import com.example.commerce.entity.avg.AvgSUM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvgRopository extends JpaRepository<AvgSUM,Long> {

    @Query(value = "SELECT ROUND(AVG(a.stock)) as coff_avg " +
            "FROM warehouse_stock_entity a " +
            "INNER JOIN item_entity b " +
            "on a.item_id = b.item_id " +
            "WHERE b.product_gubun = '커피' " +
            "GROUP by b.product_gubun", nativeQuery = true)
    public Integer coffAvg();

    @Query(value = "SELECT * " +
            "FROM coff_avg " +
            "WHERE id=1 ", nativeQuery = true)
    public AvgSUM ajaxAvg();
}

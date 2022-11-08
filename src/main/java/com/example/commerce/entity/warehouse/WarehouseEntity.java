package com.example.commerce.entity.warehouse;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long id;

    private String warehouse_name; //창고명

    private String location; //위치
}

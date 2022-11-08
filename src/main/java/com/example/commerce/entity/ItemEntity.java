package com.example.commerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String product_gubun;  //제품구분 커피 파우더
    private String product_name; //제품명
    private Integer price;  //단가

}

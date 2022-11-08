package com.example.commerce.entity.warehouse;

import com.example.commerce.entity.ItemEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class WarehouseStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gubun;  //구분 IN, OUT

    private Integer receiving;  //입고

    private Integer forwarding; //출고

    private Integer stock; //재고

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouseEntity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    @Column
    private LocalDateTime createDate;

//    public int getTotalPrice() {
//        int totalPrice = 0;
//        for(OrderItem orderItem : orderItems){
//            totalPrice += orderItem.getTotalPrice();
//        }
//        return totalPrice;
//    }

}

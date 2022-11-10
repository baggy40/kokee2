package com.example.commerce.dto.warehouse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarehouseStockDto {

    private String gubun; //구분 IN, OUT
    private Integer receiving; //입고
    private Integer forwarding; //출고
    private Integer stock; //재고
    private Integer item_id;
    private Integer warehouse_id;

    //날짜는 Entity에서 now로 만든다
}

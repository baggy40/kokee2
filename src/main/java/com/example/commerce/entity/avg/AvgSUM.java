package com.example.commerce.entity.avg;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AvgSUM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Integer arabica_sum;
    Integer robusta_sum;
    Integer colombia_sum;
    Integer prote_sum;
    Integer prote_gold_sum;
    Integer guate_sum;
    Integer papua_sum;
    Integer florence_sum;
}

package com.nht.springdemo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OeePerformanceDTO {
    private Long id;

    private Double ggOee;
    private Double gOee1s;
    private Double ttGp;
    private Double ttGg;
    private Double tt1s;
    private Integer redTamir;
    private Integer farkliUrun;
    private Integer urunGrubu;
    private LocalDateTime createdAt;
}

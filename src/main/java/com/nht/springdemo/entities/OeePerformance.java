package com.nht.springdemo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OeePerformance {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", type = org.hibernate.id.IncrementGenerator.class)
    private Long id;

    @NonNull
    private Double ggOee;
    @NonNull
    private Double gOee1s;
    @NonNull
    private Double ttGp;
    @NonNull
    private Double ttGg;
    @NonNull
    private Double tt1s;
    @NonNull
    private Integer redTamir;
    @NonNull
    private Integer farkliUrun;
    @NonNull
    private Integer urunGrubu;

    @NonNull
    private LocalDateTime createdAt;

}

package com.nht.springdemo.utils;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.model.OeePerformanceDTO;

public interface OeePerformanceMapper {

    OeePerformance dtoToEntity(OeePerformanceDTO oeeDTO);

    OeePerformanceDTO entityToDto(OeePerformance oeePerformance);
}

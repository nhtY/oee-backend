package com.nht.springdemo.services;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.model.OeePerformanceDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface OeePerformanceService {

    OeePerformanceDTO save(OeePerformanceDTO oeePerformanceDTO);

    OeePerformance getCurrentOeeData();
    List<OeePerformance> getAllOeeData();

    Page<OeePerformance> getLastTwentyOeeData();

    void deleteAll();
    void deleteAllByCreatedAtBefore(LocalDateTime end);

}

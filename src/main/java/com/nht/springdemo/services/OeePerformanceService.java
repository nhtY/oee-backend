package com.nht.springdemo.services;

import com.nht.springdemo.model.OeePerformanceDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface OeePerformanceService {

    OeePerformanceDTO save(OeePerformanceDTO oeePerformanceDTO);

    OeePerformanceDTO getCurrentOeeData();
    List<OeePerformanceDTO> getAllOeeData();

    Page<OeePerformanceDTO> getLastTwentyOeeData();

    void deleteAll();
    void deleteAllByCreatedAtBefore(LocalDateTime end);

}

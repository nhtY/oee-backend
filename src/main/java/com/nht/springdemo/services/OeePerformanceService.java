package com.nht.springdemo.services;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.repositories.OeePerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OeePerformanceService {

    private final OeePerformanceRepository oeePerformanceRepository;


    @Autowired
    public OeePerformanceService(OeePerformanceRepository oeePerformanceRepository) {
        this.oeePerformanceRepository = oeePerformanceRepository;
    }

    public OeePerformance save(OeePerformance oeePerformance) {
        return oeePerformanceRepository.save(oeePerformance);
    }

    public OeePerformance getCurrentOeeData() {
        return oeePerformanceRepository.findAll(Pageable.ofSize(1)).getContent().get(0);
    }

    public List<OeePerformance> getAllOeeData() {
        return oeePerformanceRepository.findAll();
    }

    public Page<OeePerformance> getLastTwentyOeeData() {
        return oeePerformanceRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "createdAt")));
    }

    public void deleteAll() {
        oeePerformanceRepository.deleteAll();
    }

    public void deleteAllByCreatedAtBefore(LocalDateTime end) {
        oeePerformanceRepository.deleteAllByCreatedAt(end);
    }
}

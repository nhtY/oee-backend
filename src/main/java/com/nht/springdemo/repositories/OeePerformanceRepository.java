package com.nht.springdemo.repositories;

import com.nht.springdemo.entities.OeePerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OeePerformanceRepository extends JpaRepository<OeePerformance, Long> {
}

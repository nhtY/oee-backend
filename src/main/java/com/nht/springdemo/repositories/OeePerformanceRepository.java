package com.nht.springdemo.repositories;

import com.nht.springdemo.entities.OeePerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface OeePerformanceRepository extends JpaRepository<OeePerformance, Long> {

    @Transactional
    @Modifying // for updates and deletes (statements that do not produce a resultset)
    @Query(value = "DELETE FROM OeePerformance op WHERE op.createdAt <:end")
    void deleteAllByCreatedAt(LocalDateTime end);
}

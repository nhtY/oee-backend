package com.nht.springdemo.services;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.model.OeePerformanceDTO;
import com.nht.springdemo.repositories.OeePerformanceRepository;
import com.nht.springdemo.utils.OeePerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OeePerformanceServiceImpl implements OeePerformanceService {

    private final OeePerformanceRepository oeePerformanceRepository;

    private final OeePerformanceMapper mapper;

    @Autowired
    public OeePerformanceServiceImpl(OeePerformanceRepository oeePerformanceRepository, OeePerformanceMapper mapper) {
        this.oeePerformanceRepository = oeePerformanceRepository;
        this.mapper = mapper;
    }

    public OeePerformanceDTO save(OeePerformanceDTO oeePerformanceDTO) {
        return mapper.entityToDto(
                oeePerformanceRepository.save(mapper.dtoToEntity(oeePerformanceDTO))
        );
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

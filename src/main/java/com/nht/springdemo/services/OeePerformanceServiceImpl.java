package com.nht.springdemo.services;

import com.nht.springdemo.model.OeePerformanceDTO;
import com.nht.springdemo.repositories.OeePerformanceRepository;
import com.nht.springdemo.utils.OeePerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public OeePerformanceDTO getCurrentOeeData() {
        return mapper.entityToDto(
                oeePerformanceRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "createdAt"))).getContent().get(0)
        );
    }

    public List<OeePerformanceDTO> getAllOeeData() {
        return oeePerformanceRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Page<OeePerformanceDTO> getLastTwentyOeeData() {
        return oeePerformanceRepository.findAll(
                PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "createdAt"))
        ).map(mapper::entityToDto); // this is the map() method of the Page abject.
    }

    public void deleteAll() {
        oeePerformanceRepository.deleteAll();
    }

    public void deleteAllByCreatedAtBefore(LocalDateTime end) {
        oeePerformanceRepository.deleteAllByCreatedAt(end);
    }
}

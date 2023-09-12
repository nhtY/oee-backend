package com.nht.springdemo.controller;

import com.nht.springdemo.services.OeePerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/oee")
@CrossOrigin("http://localhost:3000")
public class OeePerformanceController {

    private final OeePerformanceService oeePerformanceService;

    @GetMapping("/current")
    public ResponseEntity getCurrentOeeData() {
        return ResponseEntity.ok(oeePerformanceService.getCurrentOeeData());
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(oeePerformanceService.getAllOeeData());
    }

    @GetMapping("/last-20")
    public ResponseEntity getlLastTwenty() {
        return ResponseEntity.ok(oeePerformanceService.getLastTwentyOeeData());
    }
}

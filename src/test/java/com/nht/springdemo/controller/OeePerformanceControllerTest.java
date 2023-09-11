package com.nht.springdemo.controller;

import com.nht.springdemo.services.OeePerformanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
class OeePerformanceControllerTest {

    @MockBean
    OeePerformanceServiceImpl oeePerformanceService;

    @Test
    void getCurrentOeeData() {
    }
}
package com.nht.springdemo.dataLoader;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.repositories.OeePerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FakeDataLoader {
    Logger log= LoggerFactory.getLogger(this.getClass().getName());

    private final OeePerformanceRepository oeePerformanceRepository;


    @Autowired
    public FakeDataLoader(OeePerformanceRepository oeePerformanceRepository) {
        this.oeePerformanceRepository = oeePerformanceRepository;
        startLoader();
    }

    private void startLoader() {
        log.debug("I am startLoader...");
        oeePerformanceRepository.save(
                OeePerformance.builder()
                        .ggOee(65.789)
                        .gOee1s(77.345)
                        .ttGp(2.345)
                        .ttGg(1.679)
                        .tt1s(3.1234)
                        .farkliUrun(4)
                        .redTamir(12)
                        .urunGrubu(3)
                        .build()
        );

//        for (int i=0; i<10; i++) {
//
//        }

    }
}

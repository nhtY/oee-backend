package com.nht.springdemo.dataLoader;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.repositories.OeePerformanceRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class FakeDataLoader { // implements DisposableBean
    Logger log= LoggerFactory.getLogger(this.getClass().getName());

    private final OeePerformanceRepository oeePerformanceRepository;
    //private final Thread loaderThread;


    @Autowired
    public FakeDataLoader(OeePerformanceRepository oeePerformanceRepository) {
        this.oeePerformanceRepository = oeePerformanceRepository;
        //this.loaderThread = initLoaderThread();
    }

    private Thread initLoaderThread() {
        log.debug("I am startLoader...");

        Runnable runnable = () -> {

            log.debug("In run of Runnable...");
            int hatali = 0;

            while (!Thread.interrupted()) {
                log.debug("In loop of Runnable...");
                Random random = new Random(System.currentTimeMillis());

                oeePerformanceRepository.deleteAllByCreatedAt(LocalDateTime.now().minusSeconds(20));

                hatali += random.nextInt(3);
                oeePerformanceRepository.save(
                        OeePerformance.builder()
                        .ggOee(random.nextDouble() * 10 + 60)
                        .gOee1s(random.nextDouble() * 20 + 60)
                        .ttGp(random.nextDouble() * 5)
                        .ttGg(random.nextDouble() * 5)
                        .tt1s(random.nextDouble() * 5)
                        .farkliUrun(13)
                        .redTamir(hatali)
                        .urunGrubu(12)
                        .createdAt(LocalDateTime.now())
                        .build()
                );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.debug("Error: {}\t|\tThread Interrupted - status: {}.", e.getMessage(), Thread.currentThread().isInterrupted());
                    break;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setName("Fake Data Loader Thread");

        log.debug("Fake data loader thread has been created.");

        return thread;
    }

//    @PostConstruct
//    public void postConstruct() {
//        log.debug("## PostConstruct is called");
//        log.debug("Thread Name:  {}", this.loaderThread.getName());
//        log.debug("Thread is being started...");
//        this.loaderThread.start();
//    }
//
//    @PreDestroy
//    public void preDestroy() throws InterruptedException {
//        log.debug("## PreDestroy");
//        log.debug("Thread will be interrupted");
//
//        log.debug("Is {} interrupted? {}", this.loaderThread.getName(), this.loaderThread.isInterrupted());
//        loaderThread.interrupt();
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        log.debug("## DisposableBean.destroy: The FakeDataLoader bean has been terminated");
//        log.debug("Is {} interrupted? {}", this.loaderThread.getName(), this.loaderThread.isAlive());
//    }

}
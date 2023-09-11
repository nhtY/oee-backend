package com.nht.springdemo.dataLoader;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Fake1 implements BeanNameAware {

    private Integer count;

    public Fake1() {
        log.debug("A FAKE1 bean is created");
        count = 0;
        loopOperation();
    }

    private void loopOperation() {
        while (true) {

            log.debug("Fake1 ...COUNT= {}", count);
            count ++;
            if (count == 200) break;
        }
        log.debug("Fake1 loop stooped");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## 5 postConstruct: The PostConstruct annotated method has been called.");
    }

    @Override
    public void setBeanName(String name) {
        log.debug("Bean Name: {}", name);
    }
}

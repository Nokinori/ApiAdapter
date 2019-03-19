package com.api.sim;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.ParentContextApplicationContextInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
@Slf4j
@Getter
public class SimApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().profiles("dev","WebSecurity").sources(SimApplication.class).run(args);
        log.info("Spring sim url: http://localhost:8010/");
    }
}


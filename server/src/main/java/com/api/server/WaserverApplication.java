package com.api.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@Slf4j
public class WaserverApplication {

    public static void main(String[] args) {
        if (args.length > 0 && args[0] != null && args[0].contentEquals("prod"))
            new SpringApplicationBuilder().profiles("main").profiles("prod").sources(WaserverApplication.class).run(args);
        else
            new SpringApplicationBuilder().profiles("main").profiles("dev").sources(WaserverApplication.class).run(args);

        log.info("Spring server url: http://localhost:8080/");
    }
}


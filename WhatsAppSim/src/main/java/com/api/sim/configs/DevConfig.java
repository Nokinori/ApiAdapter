package com.api.sim.configs;

import com.api.sim.dbmock.DaoMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.api.sim")
@EnableWebMvc
@Profile("dev")
@Slf4j
public class DevConfig  {

    @Bean
    public DaoMock daoMock() {
        return new DaoMock();
    }

}
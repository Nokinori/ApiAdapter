package com.api.server.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.api.server")
@Profile("main")
public class MainConfig {


}

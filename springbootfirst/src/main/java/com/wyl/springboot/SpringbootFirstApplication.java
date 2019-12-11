package com.wyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootFirstApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootFirstApplication.class, args);
        SpringApplication sa = new SpringApplication(SpringbootFirstApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }
}
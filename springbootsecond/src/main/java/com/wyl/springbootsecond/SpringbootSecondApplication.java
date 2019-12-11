package com.wyl.springbootsecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootSecondApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootSecondApplication.class, args);
        SpringApplication sa = new SpringApplication(SpringbootSecondApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }


}
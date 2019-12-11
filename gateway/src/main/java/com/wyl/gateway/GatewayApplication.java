package com.wyl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
//        SpringApplication.run(GatewayApplication.class, args);
        SpringApplication sa = new SpringApplication(GatewayApplication.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }

}

package com.aaron.learn.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author aaron
 * @date 2020/11/6-15:45
 * @description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStarterApplication.class, args);
    }

}

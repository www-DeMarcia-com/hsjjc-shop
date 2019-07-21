package com.hsjjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
//@EnableCaching
public class SsoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsoServiceApplication.class, args);
	}
}

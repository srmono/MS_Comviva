package com.itgurukul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZomatoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZomatoServiceRegistryApplication.class, args);
	}

}

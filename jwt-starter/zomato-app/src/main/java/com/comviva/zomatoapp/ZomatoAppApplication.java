package com.comviva.zomatoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZomatoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZomatoAppApplication.class, args);
	}

}

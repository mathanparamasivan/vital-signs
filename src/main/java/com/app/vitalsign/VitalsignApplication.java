package com.app.vitalsign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VitalsignApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalsignApplication.class, args);
	}

}

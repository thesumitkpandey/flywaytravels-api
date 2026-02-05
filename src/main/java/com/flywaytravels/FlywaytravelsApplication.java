package com.flywaytravels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlywaytravelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywaytravelsApplication.class, args);
	}

}

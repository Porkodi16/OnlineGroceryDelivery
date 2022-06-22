package com.edu.OnlineGroceryDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

 @SpringBootApplication
 
 @EnableJpaRepositories
public class OnlineGroceryDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGroceryDeliveryApplication.class, args);
	}

}

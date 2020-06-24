package com.cognizant.menuItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//Application Class
@SpringBootApplication
@EnableDiscoveryClient
public class MenuitemServiceApplication {
	
	//Main function
	public static void main(String[] args) {
		SpringApplication.run(MenuitemServiceApplication.class, args);
	}

}

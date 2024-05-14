package com.Springzada.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Springzada.API.config.APIconfig;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		// Load environment variables
		APIconfig.loadEnv();

		// Start
		SpringApplication.run(ApiApplication.class, args);
	}

}

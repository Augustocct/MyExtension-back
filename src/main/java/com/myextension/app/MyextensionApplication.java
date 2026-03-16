package com.myextension.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyextensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyextensionApplication.class, args);
	}

}

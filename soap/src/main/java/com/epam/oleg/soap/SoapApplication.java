package com.epam.oleg.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.epam.oleg")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
	}

}

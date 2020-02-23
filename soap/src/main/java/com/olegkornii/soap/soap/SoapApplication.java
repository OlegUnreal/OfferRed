package com.olegkornii.soap.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.epam.oleg")
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

}

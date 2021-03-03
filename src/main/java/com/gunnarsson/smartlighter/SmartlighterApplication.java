package com.gunnarsson.smartlighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SmartlighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartlighterApplication.class, args);
	}

}
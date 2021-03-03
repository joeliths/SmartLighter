package com.gunnarsson.smartlighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SmartlighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartlighterApplication.class, args);
	}

	@RestController
	public static class UserController {


	}
}
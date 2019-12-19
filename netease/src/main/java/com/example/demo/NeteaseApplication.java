package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
@Controller
@SpringBootApplication
@ComponentScan("com.example.demo")
public class NeteaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeteaseApplication.class, args);
	}

}

package com.cg.employeee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class EmployeeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeeApplication.class, args);
	}
	
}

package com.capestart.cricketscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.capestart.cricketscore.controller.*"})
public class CricketScoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketScoreManagementSystemApplication.class, args);
	}

}

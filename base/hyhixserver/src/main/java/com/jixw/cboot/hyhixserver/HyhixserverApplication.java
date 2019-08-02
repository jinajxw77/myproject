package com.jixw.cboot.hyhixserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HyhixserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyhixserverApplication.class, args);
	}

}

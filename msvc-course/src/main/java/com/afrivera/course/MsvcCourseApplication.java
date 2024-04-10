package com.afrivera.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCourseApplication.class, args);
	}

}

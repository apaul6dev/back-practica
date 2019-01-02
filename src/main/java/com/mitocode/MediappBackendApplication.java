package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SPRING BOOT 1.5
//import org.springframework.boot.web.support.SpringBootServletInitializer

//SPRING BOOT 2
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//https://stackoverflow.com/questions/38843015/spring-boot-springbootservletinitializer-is-deprecated
public class MediappBackendApplication { //extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MediappBackendApplication.class, args);
	}
	
}

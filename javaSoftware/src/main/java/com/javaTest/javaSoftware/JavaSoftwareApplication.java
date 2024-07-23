package com.javaTest.javaSoftware;

import com.javaTest.javaSoftware.services.UsuariosService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JavaSoftwareApplication {

	@Autowired
	UsuariosService usuariosService;

	public static void main(String[] args) {
		SpringApplication.run(JavaSoftwareApplication.class, args);
	}



}
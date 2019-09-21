package com.shopshopista.loginss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shopshopista.loginss.*")
public class LoginSsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSsApplication.class, args);
	}

}

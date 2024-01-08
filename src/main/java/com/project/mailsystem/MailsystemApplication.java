package com.project.mailsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsystemApplication.class, args);

		Email email = new Email("Josefina", "Fronton");


	}

}

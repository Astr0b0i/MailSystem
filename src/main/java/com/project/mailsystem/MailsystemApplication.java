package com.project.mailsystem;

import com.project.mailsystem.models.UsersEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsystemApplication.class, args);
			//UsersEntity email = new UsersEntity("Josefina", "Fronton");
			//System.out.println(email.showInfo());
		}

}

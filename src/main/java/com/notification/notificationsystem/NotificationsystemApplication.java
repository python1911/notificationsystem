package com.notification.notificationsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NotificationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsystemApplication.class, args);
	}

	// 🔐 TEMPORARY: Generates a hash for 'admin123'
	@Bean
	public CommandLineRunner generatePasswordHash(BCryptPasswordEncoder encoder) {
		return args -> {
			String rawPassword = "admin123";
			String hashedPassword = encoder.encode(rawPassword);
			System.out.println("🔐 Hashed 'admin123': " + hashedPassword);
		};
	}
}

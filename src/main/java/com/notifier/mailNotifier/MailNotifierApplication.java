package com.notifier.mailNotifier;

import com.notifier.mailNotifier.repo.UserRequestRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRequestRepo.class)
public class MailNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailNotifierApplication.class, args);
	}

}

package com.notifier.mailNotifier;

import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepo.class)
public class MailNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailNotifierApplication.class, args);
	}
//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder(){
//		return  new BCryptPasswordEncoder();
//	}
}

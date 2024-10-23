package com.example.questService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QuestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestServiceApplication.class, args);
	}

}

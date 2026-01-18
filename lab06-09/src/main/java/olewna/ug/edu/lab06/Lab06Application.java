package olewna.ug.edu.lab06;

import olewna.ug.edu.lab06.domain.ChatGPTQuestion;
import olewna.ug.edu.lab06.service.ChatGPTService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class Lab06Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab06Application.class, args);
	}

//	@Bean
//	public CommandLineRunner setUpApp(ChatGPTService QuestionService) {
//		return (args) -> {
//			QuestionService.learing();
//		};
//	}
}

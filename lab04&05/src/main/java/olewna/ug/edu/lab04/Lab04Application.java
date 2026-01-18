package olewna.ug.edu.lab04;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import olewna.ug.edu.lab04.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class Lab04Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab04Application.class, args);
	}

	@Bean
	public CommandLineRunner appSetup(QuestionService questionManager){
		return args -> {
			System.out.println("CommandLineRunner started...");
			String file = "src/main/resources/chat-gpt-questions.csv";
			BufferedReader reader = null;
			String line = "";
			try {
				reader = new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null) {
					String[] row = line.split(";");
					if(!row[0].equals("id")) {
						questionManager.addQuestion(new ChatGPTQuestion(row[1],row[2], LocalDateTime.parse(row[3]), Boolean.valueOf(row[4]), Integer.valueOf(row[5])));
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				reader.close();
			}
			questionManager.addQuestion(new ChatGPTQuestion( "Co to znaczy hola po polsku?", "Hola oznacza czesc z języka hiszpańskiego", LocalDateTime.parse("2022-05-12T15:10:00"),true, 24));
			questionManager.addQuestion(new ChatGPTQuestion( "Kim był Henryk Sienkiewicz?", "Henryk Sienkiewicz był wybitnym pisarzem polskim", LocalDateTime.parse("2022-05-12T15:10:00"),false, 1));
			questionManager.addQuestion(new ChatGPTQuestion( "Czy javascript to najlepszy język programowania?", "Oczywiście! Jeśli Ty tak uważasz to tak jest!", LocalDateTime.parse("2022-05-12T15:10:00"),true, 49));
		};
	}

}

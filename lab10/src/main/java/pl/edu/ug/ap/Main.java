package pl.edu.ug.ap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.ap.service.PersonService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    public CommandLineRunner setUpApp(PersonService personService) {
        return (args) -> {
            personService.fillData();
            personService.learning();
        };
    }
}

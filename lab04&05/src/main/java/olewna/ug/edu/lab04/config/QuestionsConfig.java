package olewna.ug.edu.lab04.config;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class QuestionsConfig {
    static List<ChatGPTQuestion> newQuestion = new ArrayList<>();
    static int counter = -1;
    static {
        newQuestion.add(new ChatGPTQuestion("Czym jestes?", "Jestem AI.", LocalDateTime.parse("2022-05-12T15:10:00"), true, 2));
        newQuestion.add(new ChatGPTQuestion("Czym jest Python?", "Python to niskopoziomowy język programowania.", LocalDateTime.parse("2022-05-12T15:10:00"),true, 17));
        newQuestion.add(new ChatGPTQuestion("Kto wynalazł komputer?", "Charles Babbage.", LocalDateTime.parse("2022-05-12T15:10:00"),true,420));
    }

    @Bean
    @Scope("prototype")
    ChatGPTQuestion createBean() {
        counter++;
        return newQuestion.get(counter);
    }
}

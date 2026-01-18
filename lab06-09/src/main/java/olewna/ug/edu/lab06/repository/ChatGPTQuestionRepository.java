package olewna.ug.edu.lab06.repository;

import olewna.ug.edu.lab06.domain.ChatGPTQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatGPTQuestionRepository extends JpaRepository<ChatGPTQuestion, Long> {
    List<ChatGPTQuestion> findByQuestionAndDate(String question, LocalDateTime date);
    List<ChatGPTQuestion> findByDateOrQuestion(LocalDateTime date, String question);
    @Query("SELECT question FROM ChatGPTQuestion question")
    List<ChatGPTQuestion> getAllQuestions();

}

package pl.edu.ug.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ap.domain.ChatGPT;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatGPTRepository extends JpaRepository<ChatGPT, Long> {
    @Query("SELECT q FROM ChatGPT q LEFT JOIN FETCH q.goodAnswer LEFT JOIN FETCH q.wrongAnswers")
    List<ChatGPT> findAllQuestions();
    @Query("SELECT DISTINCT q FROM ChatGPT q LEFT JOIN FETCH q.goodAnswer LEFT JOIN FETCH q.wrongAnswers JOIN q.persons p WHERE p.id = :personId")
    List<ChatGPT> findChatGPTByPersonsId(Long personId);
    @Override
    Optional<ChatGPT> findById(Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM chatgpt WHERE (:question = question OR :question IS NULL) AND (:timesAsked = timesAsked OR :timesAsked IS NULL) AND (:answeredCorrect = answeredCorrect OR :answeredCorrect IS NULL)")
    List<ChatGPT> findBySearchedParams(@Param("question") String question, @Param("timesAsked") int timesAsked, @Param("answeredCorrect") boolean answeredCorrect);
}
package pl.edu.ug.ap.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.ug.ap.domain.WrongAnswer;
import pl.edu.ug.ap.repository.WrongAnswerRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class WrongAnswerService {
    private final WrongAnswerRepository wrongAnswerRepository;
    public WrongAnswer addWrongAnswer(WrongAnswer answer) {
        return wrongAnswerRepository.save(answer);
    }
    public Optional<WrongAnswer> findWrongAnswerById(Long id) {
        return wrongAnswerRepository.findById(id);
    }
    public void deleteWrongAnswer(Long id) {
        wrongAnswerRepository.deleteById(id);
    }
}

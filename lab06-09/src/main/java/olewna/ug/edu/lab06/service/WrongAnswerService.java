package olewna.ug.edu.lab06.service;

import jakarta.transaction.Transactional;
import olewna.ug.edu.lab06.domain.WrongAnswer;
import olewna.ug.edu.lab06.repository.WrongAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class WrongAnswerService {
    final WrongAnswerRepository wrongAnswerRepository;

    public WrongAnswerService(WrongAnswerRepository wrongAnswerRepository) {
        this.wrongAnswerRepository = wrongAnswerRepository;
    }

    public WrongAnswer addWrongAnswer(WrongAnswer wrongAnswer) {
        return wrongAnswerRepository.save(wrongAnswer);
    }

    public Optional<WrongAnswer> findWrongAnswerById(Long id) {
        return wrongAnswerRepository.findById(id);
    }
}

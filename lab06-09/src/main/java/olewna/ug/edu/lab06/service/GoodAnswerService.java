package olewna.ug.edu.lab06.service;

import jakarta.transaction.Transactional;
import olewna.ug.edu.lab06.domain.GoodAnswer;
import olewna.ug.edu.lab06.repository.GoodAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class GoodAnswerService {
    final GoodAnswerRepository goodAnswerRepository;

    public GoodAnswerService(GoodAnswerRepository goodAnswerRepository) {
        this.goodAnswerRepository = goodAnswerRepository;
    }

    public GoodAnswer addGoodAnswer(GoodAnswer goodAnswer) {
        return goodAnswerRepository.save(goodAnswer);
    }

    public Optional<GoodAnswer> findGoodAnswerById(Long id) {
        return goodAnswerRepository.findById(id);
    }
}

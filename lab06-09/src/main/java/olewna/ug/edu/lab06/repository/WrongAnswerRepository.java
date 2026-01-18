package olewna.ug.edu.lab06.repository;

import olewna.ug.edu.lab06.domain.WrongAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrongAnswerRepository extends CrudRepository<WrongAnswer, Long> {
}

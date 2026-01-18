package olewna.ug.edu.lab06.repository;

import olewna.ug.edu.lab06.domain.GoodAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodAnswerRepository extends CrudRepository<GoodAnswer, Long> {
}

package pl.edu.ug.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ap.domain.GoodAnswer;

@Repository
public interface GoodAnswerRepository extends JpaRepository<GoodAnswer, Long> {
}

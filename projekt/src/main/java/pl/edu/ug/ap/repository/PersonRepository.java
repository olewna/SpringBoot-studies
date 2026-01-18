package pl.edu.ug.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ap.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
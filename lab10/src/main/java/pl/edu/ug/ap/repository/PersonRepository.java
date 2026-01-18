package pl.edu.ug.ap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ap.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}

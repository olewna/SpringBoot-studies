package olewna.ug.edu.lab06.service;

import jakarta.transaction.Transactional;
import olewna.ug.edu.lab06.domain.Person;
import olewna.ug.edu.lab06.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }
}

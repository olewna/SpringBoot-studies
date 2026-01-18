package pl.edu.ug.ap.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.ug.ap.domain.Person;
import pl.edu.ug.ap.repository.PersonRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    public Person createAccount(Person person) {
        return personRepository.save(person);
    }
    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
    public Person updatePersonById(Long id, Person personToUpdate) {
        Optional<Person> actualPerson = personRepository.findById(id);
        if (actualPerson.isPresent()) {
            Person person = actualPerson.get();
            person.setFirstname(personToUpdate.getFirstname());
            person.setLastname(personToUpdate.getLastname());
            person.setEmail(personToUpdate.getEmail());
            return personRepository.save(person);
        }
        return null;
    }
}

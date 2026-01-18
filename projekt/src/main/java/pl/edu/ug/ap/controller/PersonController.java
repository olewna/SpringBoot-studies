package pl.edu.ug.ap.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ap.domain.Person;
import pl.edu.ug.ap.service.PersonService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findPersonById(@PathVariable("id") String id) {
        return new ResponseEntity<>(personService.findPersonById(Long.parseLong(id)), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createAccount(person), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Person>> deletePerson(@PathVariable("id") String id) {
        Optional<Person> personToDelete = personService.findPersonById(Long.parseLong(id));
        if (personToDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            personService.deletePerson(Long.parseLong(id));
            return new ResponseEntity<>(personToDelete, HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person personToUpdate) {
        Person response = personService.updatePersonById(Long.parseLong(id), personToUpdate);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package pl.edu.ug.ap.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.ap.domain.ChatGPT;
import pl.edu.ug.ap.domain.Person;
import pl.edu.ug.ap.repository.ChatGPTRepository;
import pl.edu.ug.ap.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ChatGPTRepository chatGPTRepository;

    public PersonService(PersonRepository personRepository, ChatGPTRepository chatGPTRepository) {
        this.personRepository = personRepository;
        this.chatGPTRepository = chatGPTRepository;
    }

    public void fillData() {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();

        p1.setFirstname("Person 1");
        p2.setFirstname("Person 2");
        p3.setFirstname("Person 3");
        p4.setFirstname("Person 4");

        p1.setLastname("Nazwisko 1");
        p2.setLastname("Nazwisko 2");
        p3.setLastname("Nazwisko 3");
        p4.setLastname("Nazwisko 4");

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
        personRepository.save(p4);

        ChatGPT q1 = new ChatGPT();
        ChatGPT q2 = new ChatGPT();
        ChatGPT q3 = new ChatGPT();
        ChatGPT q4 = new ChatGPT();
        ChatGPT q5 = new ChatGPT();
        ChatGPT q6 = new ChatGPT();
        ChatGPT q7 = new ChatGPT();
        ChatGPT q8 = new ChatGPT();

        q1.setQuestion("Question 1");
        q2.setQuestion("Question 2");
        q3.setQuestion("Question 3");
        q4.setQuestion("Question 4");
        q5.setQuestion("Question 5");
        q6.setQuestion("Question 6");
        q7.setQuestion("Question 7");
        q8.setQuestion("Question 8");

        q1.setAnswer("Answer 1");
        q2.setAnswer("Answer 2");
        q3.setAnswer("Answer 3");
        q4.setAnswer("Answer 4");
        q5.setAnswer("Answer 5");
        q6.setAnswer("Answer 6");
        q7.setAnswer("Answer 7");
        q8.setAnswer("Answer 8");

        q1.setPerson(p1);
        q2.setPerson(p1);
        q3.setPerson(p1);
        q4.setPerson(p2);
        q5.setPerson(p2);
        q6.setPerson(p3);
        q7.setPerson(p4);
        q8.setPerson(p4);

        chatGPTRepository.save(q1);
        chatGPTRepository.save(q2);
        chatGPTRepository.save(q3);
        chatGPTRepository.save(q4);
        chatGPTRepository.save(q5);
        chatGPTRepository.save(q6);
        chatGPTRepository.save(q7);
        chatGPTRepository.save(q8);
    }

    public void learning() {
        for (ChatGPT question : chatGPTRepository.findAll()) {
            System.out.println(question);
        }
        for (Person person : personRepository.findAll()) {
            System.out.println(person);
        }
    }
}

package olewna.ug.edu.lab06.service;

import jakarta.transaction.Transactional;
import olewna.ug.edu.lab06.domain.ChatGPTQuestion;
import olewna.ug.edu.lab06.domain.GoodAnswer;
import olewna.ug.edu.lab06.domain.Person;
import olewna.ug.edu.lab06.domain.WrongAnswer;
import olewna.ug.edu.lab06.repository.ChatGPTQuestionRepository;
import olewna.ug.edu.lab06.repository.GoodAnswerRepository;
import olewna.ug.edu.lab06.repository.PersonRepository;
import olewna.ug.edu.lab06.repository.WrongAnswerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatGPTService {
    final ChatGPTQuestionRepository chatGPTRepository;
    final GoodAnswerRepository goodAnswerRepository;
    final WrongAnswerRepository wrongAnswerRepository;
    final PersonRepository personRepository;

    public ChatGPTService(ChatGPTQuestionRepository chatGPTRepository, GoodAnswerRepository goodAnswerRepository, PersonRepository personRepository, WrongAnswerRepository wrongAnswerRepository) {
        this.chatGPTRepository = chatGPTRepository;
        this.goodAnswerRepository = goodAnswerRepository;
        this.wrongAnswerRepository = wrongAnswerRepository;
        this.personRepository = personRepository;
    }
    public ChatGPTQuestion addQuestion(ChatGPTQuestion question) {
        return chatGPTRepository.save(question);
    }
    public List<ChatGPTQuestion> getQuestions() { return chatGPTRepository.getAllQuestions(); }
    public Optional<ChatGPTQuestion> findChatGPTQuestionById(Long id) {
        return chatGPTRepository.findById(id);
    }
    public void deleteQuestionById(Long id){
        chatGPTRepository.deleteById(id);
    }

    public void learing() {
        ChatGPTQuestion myQuestion = new ChatGPTQuestion("Kto był w Paryżu?", LocalDateTime.parse("2022-05-12T15:10:00"), true, 21);

        List<ChatGPTQuestion> questions = new ArrayList<>();
        questions.add(myQuestion);
        chatGPTRepository.saveAll(questions);

        Person user1 = new Person("Oskar Lewna");
        user1.setQuestions(questions);
        Person personRetrieved = personRepository.save(user1);

        List<Person> persons = new ArrayList<>();
        persons.add(user1);
        myQuestion.setPersons(persons);

        WrongAnswer wrongAnswer1 = new WrongAnswer("Pan Miotk.");
        wrongAnswer1.setQuestion(myQuestion);
        WrongAnswer wrongAnswerRetrieved = wrongAnswerRepository.save(wrongAnswer1);

        List<WrongAnswer> wrongAnswers = new ArrayList<>();
        wrongAnswers.add(wrongAnswer1);
        myQuestion.setWrongAnswers(wrongAnswers);

        GoodAnswer goodAnswer = new GoodAnswer("Napoleon");
        goodAnswer.setQuestion(myQuestion);
        GoodAnswer goodAnswerRetrieved = goodAnswerRepository.save(goodAnswer);

        myQuestion.setGoodAnswer(goodAnswer);
    }
}

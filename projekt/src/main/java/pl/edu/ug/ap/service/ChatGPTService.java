package pl.edu.ug.ap.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.ug.ap.domain.ChatGPT;
import pl.edu.ug.ap.domain.GoodAnswer;
import pl.edu.ug.ap.domain.Person;
import pl.edu.ug.ap.domain.WrongAnswer;
import pl.edu.ug.ap.repository.ChatGPTRepository;
import pl.edu.ug.ap.repository.GoodAnswerRepository;
import pl.edu.ug.ap.repository.PersonRepository;
import pl.edu.ug.ap.repository.WrongAnswerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ChatGPTService {
    private final ChatGPTRepository chatGPTRepository;
    private final PersonRepository personRepository;
    private final GoodAnswerRepository goodAnswerRepository;
    private final WrongAnswerRepository wrongAnswerRepository;
    public List<ChatGPT> findAll() {
        return chatGPTRepository.findAllQuestions();
    }
    public List<ChatGPT> findQuestionsByPersonId(long id) {
        return chatGPTRepository.findChatGPTByPersonsId(id);
    }

    public Optional<ChatGPT> findQuestionById(long id) {
        return chatGPTRepository.findById(id);
    }
    public ChatGPT createQuestion(ChatGPT question) {
        return chatGPTRepository.save(question);
    }
    public void deleteQuestion(long id) {
        chatGPTRepository.deleteById(id);
    }
    public ChatGPT updateQuestionById(Long id, ChatGPT questionToUpdate) {
        Optional<ChatGPT> foundQuestion = chatGPTRepository.findById(id);
        if (foundQuestion.isPresent()) {
            ChatGPT question = foundQuestion.get();
            question.setQuestion(questionToUpdate.getQuestion());
            question.setDate(questionToUpdate.getDate());
            question.setAnsweredCorrect(questionToUpdate.isAnsweredCorrect());
            question.setTimesAsked(questionToUpdate.getTimesAsked());
            question.setGoodAnswer(questionToUpdate.getGoodAnswer());
            question.setWrongAnswers(questionToUpdate.getWrongAnswers());
            question.setPersons(questionToUpdate.getPersons());
            return chatGPTRepository.save(question);
        }
        return null;
    }
    public List<ChatGPT> findQuestionsBySearchParams(String question, Integer timesAsked, Boolean answeredCorrect) {
        return chatGPTRepository.findBySearchedParams(question, timesAsked, answeredCorrect);
    }

    public void fillData() {
        ChatGPT question1 = new ChatGPT();
        ChatGPT question2 = new ChatGPT();
        ChatGPT question3 = new ChatGPT("Ile osób zda ten semestr na UG?", LocalDateTime.now(), true, 222);
        question1.setQuestion("Kim był Henryk Sienkiewicz?");
        question2.setQuestion("Ile jest godzin praktyk do odrobienia na Informatyce Praktycznej na UG?");
        question1.setDate(LocalDateTime.now());
        question2.setDate(LocalDateTime.now());
        question1.setTimesAsked(1124);
        question2.setTimesAsked(89);
        question1.setAnsweredCorrect(true);
        question2.setAnsweredCorrect(false);
        chatGPTRepository.saveAll(List.of(question1, question2, question3));

        Person person1 = new Person("Oskar", "Lewna", "oskarlewna@email.com");
        Person person2 = new Person("John", "King", "jk2012@xd.pl");
        person1.setQuestions(List.of(question1, question2));
        person2.setQuestions(List.of(question1, question3));
        personRepository.saveAll(List.of(person1, person2));
        question1.setPersons(List.of(person1, person2));
        question2.setPersons(List.of(person1));
        question3.setPersons(List.of(person2));

        GoodAnswer answer1 = new GoodAnswer();
        answer1.setGoodAnswer("Był pisarzem polskim.");
        GoodAnswer answer3 = new GoodAnswer();
        answer3.setGoodAnswer("Nikt XD");
        goodAnswerRepository.saveAll(List.of(answer1, answer3));
        question1.setGoodAnswer(answer1);
        question3.setGoodAnswer(answer3);

        WrongAnswer wrongAnswer1 = new WrongAnswer();
        wrongAnswer1.setWrongAnswer("Przepraszam, nie umiem udzielić odpowiedzi na to pytanie bo jestem tylko głupią sztuczną inteligencją.");
        WrongAnswer wrongAnswer2 = new WrongAnswer();
        wrongAnswer2.setWrongAnswer("Z raportów z poprzednich lat wynika, że 480 godzin.");
        WrongAnswer wrongAnswer3 = new WrongAnswer();
        wrongAnswer3.setWrongAnswer("Statystycznie rzecz biorąc 84%.");
        wrongAnswer1.setQuestion(question1);
        wrongAnswer2.setQuestion(question2);
        wrongAnswer3.setQuestion(question3);
        wrongAnswerRepository.saveAll(List.of(wrongAnswer1, wrongAnswer2, wrongAnswer3));
        question1.setWrongAnswers(List.of(wrongAnswer1));
        question2.setWrongAnswers(List.of(wrongAnswer2, wrongAnswer1));
        question3.setWrongAnswers(List.of(wrongAnswer3, wrongAnswer1));
    }
}

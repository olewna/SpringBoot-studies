package olewna.ug.edu.lab06.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHATGPTQUESTIONS")
public class ChatGPTQuestion {
    private long id;
    private String question;
    private LocalDateTime date;
    private boolean answeredCorrect;
    private int timesAsked;
    private GoodAnswer goodAnswer;
    private List<WrongAnswer> wrongAnswers;
    private List<Person> persons;
    
    public ChatGPTQuestion() {}
    public ChatGPTQuestion(String question, LocalDateTime date, boolean answeredCorrect, int timesAsked) {
        this.question = question;
        this.date = date;
        this.answeredCorrect = answeredCorrect;
        this.timesAsked = timesAsked;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JoinColumn(name = "CHATGPTQUESTIONS_ID", nullable = false)
    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public boolean isAnsweredCorrect() {
        return answeredCorrect;
    }
    public void setAnsweredCorrect(boolean answeredCorrect) {
        this.answeredCorrect = answeredCorrect;
    }
    public int getTimesAsked() {
        return timesAsked;
    }
    public void setTimesAsked(int timesAsked) {
        this.timesAsked = timesAsked;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public GoodAnswer getGoodAnswer() {
        return goodAnswer;
    }
    public void setGoodAnswer(GoodAnswer goodAnswer) {
        this.goodAnswer = goodAnswer;
    }
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Person> getPersons() {
        return persons;
    }
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<WrongAnswer> getWrongAnswers() { return wrongAnswers; }

    public void setWrongAnswers(List<WrongAnswer> wrongAnswers) { this.wrongAnswers = wrongAnswers; }

    @Override
    public String toString() {
        return "ChatGPTQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
//                ", goodAnswer=" + goodAnswer +
//                ", wrongAnswers=" + wrongAnswers +
                ", date=" + date +
                ", answeredCorrect=" + answeredCorrect +
                ", timesAsked=" + timesAsked +
//                ", persons=" + persons +
                '}';
    }
}

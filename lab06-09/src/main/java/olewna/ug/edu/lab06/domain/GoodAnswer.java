package olewna.ug.edu.lab06.domain;

import jakarta.persistence.*;

@Entity
public class GoodAnswer {
    private long id;
    private String answer;
    private ChatGPTQuestion question;

    public GoodAnswer() {
    }

    public GoodAnswer(String a) {
        this.answer = a;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String a) {
        this.answer = a;
    }

    @OneToOne(mappedBy = "goodAnswer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ChatGPTQuestion getQuestion() {
        return question;
    }
    public void setQuestion(ChatGPTQuestion question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "GoodAnswer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
//                ", question=" + question +
                '}';
    }
}



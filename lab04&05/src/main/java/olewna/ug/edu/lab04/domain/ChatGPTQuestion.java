package olewna.ug.edu.lab04.domain;

import java.time.LocalDateTime;

public class ChatGPTQuestion {
    private String id;
    private String question;
    private String answer;
    private LocalDateTime date;
    private boolean answeredCorrect;
    private int timesAsked;

    public ChatGPTQuestion() {}
    public ChatGPTQuestion(String id, String question, String answer, LocalDateTime date, boolean answeredCorrect, int timesAsked) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.answeredCorrect = answeredCorrect;
        this.timesAsked = timesAsked;
    }
    public ChatGPTQuestion(String question, String answer, LocalDateTime date, boolean answeredCorrect, int timesAsked) {
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.answeredCorrect = answeredCorrect;
        this.timesAsked = timesAsked;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}

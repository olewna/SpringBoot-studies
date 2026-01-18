package olewna.ug.edu.lab06.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    private long id;
    private String firstname;
    private List<ChatGPTQuestion> questions;

    public Person() {
    }

    public Person(String firstname) {
        this.firstname = firstname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<ChatGPTQuestion> getQuestions() {
        return questions;
    }
    public void setQuestions(List<ChatGPTQuestion> questions) {
        this.questions = questions;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
//                ", questions=" + questions +
                '}';
    }
}



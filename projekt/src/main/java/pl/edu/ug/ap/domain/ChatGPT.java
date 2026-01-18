package pl.edu.ug.ap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chatgpt")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPT {

    public ChatGPT(String question, LocalDateTime date, boolean answeredCorrect, int timesAsked) {
        this.question = question;
        this.date = date;
        this.answeredCorrect = answeredCorrect;
        this.timesAsked = timesAsked;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 999)
    private String question;
    @NotNull
    @NotBlank
    private LocalDateTime date;
    @NotNull
    private boolean answeredCorrect;
    @NotNull
    @Min(value = 1)
    private int timesAsked;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "chatgpt_person",
            joinColumns = { @JoinColumn(name = "chatgpt_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") })
    private List<Person> persons;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "good_answer_id", referencedColumnName = "id")
    private GoodAnswer goodAnswer;

    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<WrongAnswer> wrongAnswers;
}

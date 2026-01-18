package pl.edu.ug.ap.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
public class ChatGPT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    private String answer;

    @ManyToOne
    private Person person;

}

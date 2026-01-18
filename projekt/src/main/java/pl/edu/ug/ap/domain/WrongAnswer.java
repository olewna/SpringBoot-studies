package pl.edu.ug.ap.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wrong_answer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WrongAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank
    @NotBlank
    @Size(min = 2, max = 999)
    private String wrongAnswer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ChatGPT question;
}

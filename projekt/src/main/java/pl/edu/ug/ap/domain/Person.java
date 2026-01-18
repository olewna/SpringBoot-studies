package pl.edu.ug.ap.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    public Person(String firstname, String lastname, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstname;
    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastname;
    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    @Email
    private String email;
    @ManyToMany(mappedBy = "persons", fetch = FetchType.EAGER, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JsonIgnore
    private List<ChatGPT> questions;
}

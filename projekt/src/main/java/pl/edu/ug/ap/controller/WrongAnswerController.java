package pl.edu.ug.ap.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ap.domain.WrongAnswer;
import pl.edu.ug.ap.service.WrongAnswerService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/wronganswer")
public class WrongAnswerController {
    private final WrongAnswerService wrongAnswerService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<WrongAnswer>> findWrongAnswerById(@PathVariable("id") String id) {
        return new ResponseEntity<>(wrongAnswerService.findWrongAnswerById(Long.parseLong(id)), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<WrongAnswer> addWrongAnswer(@RequestBody WrongAnswer answer) {
        return new ResponseEntity<>(wrongAnswerService.addWrongAnswer(answer), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<WrongAnswer>> deleteWrongAnswer(@PathVariable("id") String id) {
        Optional<WrongAnswer> wrongAnswerToDelete = wrongAnswerService.findWrongAnswerById(Long.parseLong(id));
        if (wrongAnswerToDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            wrongAnswerService.deleteWrongAnswer(Long.parseLong(id));
            return new ResponseEntity<>(wrongAnswerToDelete, HttpStatus.OK);
        }
    }
}

package pl.edu.ug.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ap.domain.ChatGPT;
import pl.edu.ug.ap.service.ChatGPTService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;
    @Autowired
    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }
    @GetMapping
    public ResponseEntity<List<ChatGPT>> getQuestions() {
        return new ResponseEntity<>(chatGPTService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<List<ChatGPT>> getQuestionsByPersonId(@PathVariable("id") String id) {
        return new ResponseEntity<>(chatGPTService.findQuestionsByPersonId(Long.parseLong(id)), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ChatGPT>> getQuestionById(@PathVariable("id") String id) {
        return new ResponseEntity<>(chatGPTService.findQuestionById(Long.parseLong(id)), HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ChatGPT> createQuestion(@RequestBody ChatGPT question) {
        return new ResponseEntity<>(chatGPTService.createQuestion(question), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<ChatGPT>> deleteQuestion(@PathVariable("id") String id) {
        Optional<ChatGPT> questionToDelete = chatGPTService.findQuestionById(Long.parseLong(id));
        if (questionToDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            chatGPTService.deleteQuestion(Long.parseLong(id));
            return new ResponseEntity<>(questionToDelete, HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ChatGPT> updateQuestion(@PathVariable("id") String id, @RequestBody ChatGPT questionToUpdate) {
        ChatGPT response = chatGPTService.updateQuestionById(Long.parseLong(id), questionToUpdate);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<ChatGPT>> searchQuestions(@RequestParam(name = "question", required = false) String question, @RequestParam(name = "timesAsked", required = false) Integer timesAsked, @RequestParam(name = "answeredCorrect", required = false) Boolean answeredCorrect) {
        return new ResponseEntity<>(chatGPTService.findQuestionsBySearchParams(question, timesAsked, answeredCorrect), HttpStatus.OK);
    }
}

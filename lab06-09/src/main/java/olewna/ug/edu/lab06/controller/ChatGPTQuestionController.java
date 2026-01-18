package olewna.ug.edu.lab06.controller;

import olewna.ug.edu.lab06.domain.ChatGPTQuestion;
import olewna.ug.edu.lab06.service.ChatGPTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChatGPTQuestionController {
    private final ChatGPTService questionManager;

    public ChatGPTQuestionController(ChatGPTService questionManager) {
        this.questionManager = questionManager;
    }

    @PostMapping("/api/question")
    ResponseEntity<ChatGPTQuestion> addQuestion(@RequestBody ChatGPTQuestion question) {
        return new ResponseEntity<>(questionManager.addQuestion(question), HttpStatus.CREATED);
    }
    @GetMapping("/api/question")
    ResponseEntity<List<ChatGPTQuestion>> getQuestions() {
        return new ResponseEntity<>(questionManager.getQuestions(), HttpStatus.OK);
    }
    @GetMapping("/api/question/{id}")
    ResponseEntity<Optional<ChatGPTQuestion>> getQuestionById(@PathVariable String id) {
        return new ResponseEntity<>(questionManager.findChatGPTQuestionById(Long.parseLong(id)), HttpStatus.OK);
    }
    @GetMapping("/api/question/delete/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionManager.deleteQuestionById(Long.parseLong(id));
    }

}
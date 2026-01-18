package olewna.ug.edu.lab04.controller.api;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import olewna.ug.edu.lab04.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private final QuestionService questionManager;

    public QuestionController(QuestionService questionManager) {
        this.questionManager = questionManager;
    }

    @PostMapping("/api/question")
    ResponseEntity<ChatGPTQuestion> addQuestion(@RequestBody ChatGPTQuestion question) {
        return new ResponseEntity<>(questionManager.addQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/api/question")
    List<ChatGPTQuestion> getQuestions() {
        return questionManager.getAllQuestions();
    }

    @PostMapping("/api/question/update/{id}")
    public ChatGPTQuestion updateQuestion(@PathVariable String id, @RequestBody ChatGPTQuestion question) {
        question.setId(id);
        return questionManager.updateQuestion(question);
    }

    @GetMapping("/api/question/delete/{id}")
    public boolean deleteQuestion(@PathVariable String id) {
        return questionManager.deleteQuestion(id);
    }

    @GetMapping("/api/question/{id}")
    public ResponseEntity<ChatGPTQuestion> findQuestionById(@PathVariable String id) {
        ChatGPTQuestion question =  questionManager.findById(id);
        if(question==null){
            throw new QuestionNotFoundException();
        }
        return ResponseEntity.ok().body(question);
    }
}

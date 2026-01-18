package olewna.ug.edu.lab04.controller.web;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import olewna.ug.edu.lab04.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class WebQuestionController {
    private final QuestionService questionManager;
    private final GPTValidator gptValidator;

    public WebQuestionController(QuestionService questionManager, GPTValidator gptValidator) {
        this.questionManager = questionManager;
        this.gptValidator = gptValidator;
    }

    @GetMapping("/question")
    public String questions(Model model) {
        model.addAttribute("questions", questionManager.getAllQuestions());

        return "question-all";
    }

    @GetMapping("/question/form")
    public String questionForm(@RequestParam(name="id", required = false) String id, Model model) {
        model.addAttribute("newQuestion", new ChatGPTQuestion("", "", LocalDateTime.now(), true, 1));

        return "question-form";
    }

    @PostMapping("/question")
    public String questionAdd(@ModelAttribute ChatGPTQuestion newQuestion, Model model) {
        System.out.println("Nowe pytanie: " + newQuestion);
        Errors result = new BeanPropertyBindingResult(newQuestion, "question");
        gptValidator.validate(newQuestion, result);

        if(result.hasErrors()) {
            model.addAttribute("message", result.getAllErrors().get(0).getDefaultMessage());
            return "question-form";
        }

        for (ChatGPTQuestion question : questionManager.getAllQuestions()) {
            if (question.getQuestion().equals(newQuestion.getQuestion())) {
                model.addAttribute("message", "Question must be unique");
                return "question-form";
            }
        }

        ChatGPTQuestion addQuestion = questionManager.addQuestion(newQuestion);
        if (newQuestion == null) {
            model.addAttribute("message", "Question could not be created");
            return "question-form";
        }
        model.addAttribute("message", "Dodano");

        model.addAttribute("questions", questionManager.getAllQuestions());

        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "question-all";
    }

    @GetMapping("/question/update/{id}")
    public String questionEditForm(@PathVariable("id") String id, @ModelAttribute ChatGPTQuestion newQuestion, Model model) {
        ChatGPTQuestion questionToEdit = questionManager.findById(id);
        model.addAttribute("newQuestion", questionToEdit);

        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "question-edit";
    }

    @PostMapping("/question/update/{id}")
    public String questionEdit(@PathVariable("id") String id, @ModelAttribute ChatGPTQuestion question, Model model) {
        Errors result = new BeanPropertyBindingResult(question, "question");
        gptValidator.validate(question, result);

        if(result.hasErrors()) {
            model.addAttribute("message", result.getAllErrors().get(0).getDefaultMessage());
            return "question-edit";
        }

        for (ChatGPTQuestion q : questionManager.getAllQuestions()) {
            if (q.getQuestion().equals(question.getQuestion())) {
                model.addAttribute("message", "Question must be unique");
                return "question-edit";
            }
        }

        ChatGPTQuestion updatedQuestion = questionManager.updateQuestion(question);
        if (updatedQuestion == null) {
            model.addAttribute("message", "Question could not be created");
            return "question-edit";
        }

        System.out.println("Update: " + updatedQuestion);
        model.addAttribute("message", "Zaaktualizowano");

        model.addAttribute("questions", questionManager.getAllQuestions());
        return "question-all";
    }

    @GetMapping("/question/delete/{id}")
    public String questionDelete(@PathVariable("id") String id, Model model) {
        if (questionManager.deleteQuestion(id)) {
            model.addAttribute("message", "Operacja powiodła się");
            model.addAttribute("questions", questionManager.getAllQuestions());
        } else {
            model.addAttribute("message", "Operacja nie powiodła się");
        }

        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "redirect:/question";
    }

    @GetMapping("/question/{id}")
    public String questionByID(@PathVariable("id") String id, Model model) {
        model.addAttribute("questionById", questionManager.findById(id));
        return "question-all";
    }
}

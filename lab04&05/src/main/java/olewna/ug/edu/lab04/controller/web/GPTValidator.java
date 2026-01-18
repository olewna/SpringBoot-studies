package olewna.ug.edu.lab04.controller.web;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;

@Component
public class GPTValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return ChatGPTQuestion.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        ChatGPTQuestion question = (ChatGPTQuestion) target;

        ValidationUtils.rejectIfEmpty(errors, "question", "Question cannot be empty");

        if(question.getQuestion().length() <= 10) {
            errors.rejectValue("question", "question.characters", "Question must be at least 10 characters long");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "timesAsked", "Question must have amount of times asked");

        if(question.getTimesAsked() < 1) {
            errors.rejectValue("timesAsked", "timesAsked.amount", "The question cannot be asked less than 1 time");
        }

        ValidationUtils.rejectIfEmpty(errors, "answer", "Answer cannot be empty");

        if(question.getAnswer().length() <= 3) {
            errors.rejectValue("answer", "answer.characters", "Answer must be at least 3 characters long");
        }

        ValidationUtils.rejectIfEmpty(errors, "date", "Date cannot be empty");

        if(question.getDate().isAfter(LocalDateTime.now())) {
            errors.rejectValue("date", "date.future", "Date cannot be from future");
        }

        ValidationUtils.rejectIfEmpty(errors, "answeredCorrect", "Answer must be false or true");

    }
}

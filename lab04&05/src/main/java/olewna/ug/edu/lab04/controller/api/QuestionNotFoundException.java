package olewna.ug.edu.lab04.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such question from our beloved chatGPT in DB :(")
public class QuestionNotFoundException extends RuntimeException{
}

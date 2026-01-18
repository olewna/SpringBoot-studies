package olewna.ug.edu.lab04.service;

import olewna.ug.edu.lab04.domain.ChatGPTQuestion;

import java.util.List;

public interface QuestionServ {
    ChatGPTQuestion addQuestion(ChatGPTQuestion question);
    List<ChatGPTQuestion> getAllQuestions();
    boolean deleteQuestion(String id);
    ChatGPTQuestion findById(String id);
    ChatGPTQuestion updateQuestion(ChatGPTQuestion question);
}

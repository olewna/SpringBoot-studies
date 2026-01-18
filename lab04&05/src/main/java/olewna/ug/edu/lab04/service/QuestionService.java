package olewna.ug.edu.lab04.service;

import olewna.ug.edu.lab04.controller.api.QuestionNotFoundException;
import olewna.ug.edu.lab04.domain.ChatGPTQuestion;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class QuestionService implements QuestionServ{
    // DB
    List<ChatGPTQuestion> db = Collections.synchronizedList(new ArrayList<>());


    @Override
    public ChatGPTQuestion addQuestion(ChatGPTQuestion question) {
        ChatGPTQuestion newQuestion = new ChatGPTQuestion(UUID.randomUUID().toString(), question.getQuestion(), question.getAnswer(), question.getDate(), question.isAnsweredCorrect(), question.getTimesAsked());
        db.add(newQuestion);
        return newQuestion;
    }

    @Override
    public List<ChatGPTQuestion> getAllQuestions() {
        return db;
    }

    @Override
    public boolean deleteQuestion(String id) {
        ChatGPTQuestion deleteQuestion = null;

        for(ChatGPTQuestion q : db) {
            if (id.equals(q.getId())) {
                deleteQuestion = q;
            }
        }

        if (deleteQuestion != null) {
            db.remove(deleteQuestion);
            return true;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public ChatGPTQuestion findById(String id) {
        for(ChatGPTQuestion q : db) {
            if (q.getId().equals(id)){
                return q;
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public ChatGPTQuestion updateQuestion(ChatGPTQuestion question) {
        question.setDate(LocalDateTime.now());
        for(int i = 0; i < db.size(); i++) {
            if(db.get(i).getId().equals(question.getId())) {
                db.set(i, question);
                return question;
            }
        }
        throw new QuestionNotFoundException();
    }
}

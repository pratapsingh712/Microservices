package com.raghav.quizappp.service;

import com.raghav.quizappp.dao.QuestionDao;
import com.raghav.quizappp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(questionDao.findAll(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}

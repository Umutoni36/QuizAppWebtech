package com.OnlineApplicationProject.Service.impl;


import com.OnlineApplicationProject.Repository.QuizRepo;
import com.OnlineApplicationProject.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl {
    @Autowired
   private QuizRepo quizRepo;

    public Quiz RegisterUser(Quiz quiz){
     Quiz savequiz= quizRepo.save(quiz);
     return savequiz;
    }
    public List<Quiz> allquiz(){
        List<Quiz> data= quizRepo.findAll();
        return data;
    }
    public Quiz quizperid(Integer id){
        return quizRepo.Retrivequizperid(id);
    }

}

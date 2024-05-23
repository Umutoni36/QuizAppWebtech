package com.OnlineApplicationProject.Service.impl;

import com.OnlineApplicationProject.Repository.QuestionRepo;
import com.OnlineApplicationProject.Entity.Questions;
import com.OnlineApplicationProject.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl {
    @Autowired
   private QuestionRepo questionRepo;

    public Questions Registerquestion(Questions questions){
     Questions savequestion= questionRepo.save(questions);

     return savequestion;
    }

    public List<Questions> allquestions(Quiz quix){
        return  questionRepo.getingbyquizid(quix);
    }


}

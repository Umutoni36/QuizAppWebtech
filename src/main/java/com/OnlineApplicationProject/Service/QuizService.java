package com.OnlineApplicationProject.Service;

import com.OnlineApplicationProject.Entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz RegisterUser(Quiz quiz);

    List<Quiz> allquiz();

    Quiz quizperid(Integer id);
}

package com.OnlineApplicationProject.Controller;

import com.OnlineApplicationProject.Service.impl.QuizServiceImpl;
import com.OnlineApplicationProject.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuizController {
    @Autowired private QuizServiceImpl quizServiceImpl;


    @PostMapping("/registerQuiz")
    private String RegisterQuiz( Quiz quiz){
        quizServiceImpl.RegisterUser(quiz);
        return "redirect:/Project/RegisterQuiz.jsp";
    }

    @GetMapping("/Register_form")
    public String displayQuizzes(Model model) {
        List<Quiz> quizzes = quizServiceImpl.allquiz();
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("message", "");
        return "/Registerquest";
    }

    @GetMapping("/Userquiz_form")
    public String displayQuizzestouser(Model model) {
        List<Quiz> quizzes = quizServiceImpl.allquiz();
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("message", "");
        return "/UserDashboard";
    }


}

package com.OnlineApplicationProject.Controller;

import com.OnlineApplicationProject.Service.impl.MarksServiceImpl;
import com.OnlineApplicationProject.Service.impl.QuestionServiceImpl;
import com.OnlineApplicationProject.Service.impl.QuizServiceImpl;
import com.OnlineApplicationProject.Entity.Marks;
import com.OnlineApplicationProject.Entity.Questions;
import com.OnlineApplicationProject.Entity.Quiz;
import com.OnlineApplicationProject.Entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionServiceImpl;
    @Autowired
    private MarksServiceImpl marksServiceImpl;
    @Autowired
    private QuizServiceImpl quizServiceImpl;

    public Integer  Count_marks=0;
    @PostMapping("/registerQuestion")
    private String registerQuestion(Questions questions, HttpSession session,Model model) {
        Questions saveQuestion = questionServiceImpl.Registerquestion(questions);
              if (saveQuestion != null) {
            model.addAttribute("message", "Insert Successfully");
        } else {
            model.addAttribute("message", "Fail to Insert");
        }
        return "redirect:/Register_form";
    }

    @GetMapping("/question/{id}")
    private String getQuestionById(@PathVariable("id") Integer id,
                                    @RequestParam(value = "currentQuestionIndex", defaultValue = "0") int currentQuestionIndex,
                                    Model model,HttpSession session) {
        Quiz quiz = new Quiz();
        quiz.setId(id);
        if(currentQuestionIndex==0){
            Count_marks=0;
        }
        Quiz quizdata= quizServiceImpl.quizperid(id);

        model.addAttribute("quizduaration",quizdata.getQuizduratuion());
        List<Questions> questionById = questionServiceImpl.allquestions(quiz);
        model.addAttribute("question_list", questionById);
        model.addAttribute("currentQuestionIndex", currentQuestionIndex);
        model.addAttribute("quizId", id); // Pass the same id to the view
        session.setAttribute("quizInProgress",id);
        return "/UserdoQuiz";
    }
    @PostMapping("/question")
    public String retrieveQuestion(@RequestParam("currentQuestionIndex") int currentQuestionIndex,
                               @RequestParam("totalQuestions") int totalQuestions,
                               @RequestParam("quizId") Integer id,
                               @RequestParam("action") String action,
                               @RequestParam("corectanswer") String correct_answer,
                               @RequestParam(value = "answer",defaultValue = "x") String answer,
                               Model model,
                               HttpSession session) {


        if(action.equals("next")){
           if (answer.equals(correct_answer)) {
               Count_marks += 1;
           }

           currentQuestionIndex++;
           return "redirect:/question/" + id + "?currentQuestionIndex=" + currentQuestionIndex;
        }else{
           if(answer.equals(correct_answer)) {
               Count_marks += 1;
           }

           ///Set attribute
           Quiz quiz = new Quiz();
           quiz.setId(id);
           int userid= (int) session.getAttribute("userid");
           User  user=new User();
           user.setId(userid);

           //Insert a data on marks table in  database
           Marks  marks=new Marks();
           marks.setMarks(Count_marks);
           marks.setMarks_data(quiz);
           marks.setUser_data(user);
           marksServiceImpl.RegisterMarks(marks);
           model.addAttribute("marks", Count_marks);

           return "/CompleteQuiz";
        }

    }



}






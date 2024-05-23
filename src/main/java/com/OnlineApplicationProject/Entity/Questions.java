package com.OnlineApplicationProject.Entity;

import jakarta.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Integer id;
    @ManyToOne
    @JoinColumn(name = "Quiz_Id")
    private Quiz questions_datas;
    private String question_name;
    private  String answer_option1;
    private  String answer_option2;
    private  String correct_option;

    public Questions() {
    }

    public Questions(Integer id, Quiz questions_datas, String question_name, String answer_option1, String answer_option2, String correct_option) {
        this.id = id;
        this.questions_datas = questions_datas;
        this.question_name = question_name;
        this.answer_option1 = answer_option1;
        this.answer_option2 = answer_option2;
        this.correct_option = correct_option;
    }

    public Quiz getQuestions_datas() {
        return questions_datas;
    }

    public void setQuestions_datas(Quiz questions_datas) {
        this.questions_datas = questions_datas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getAnswer_option1() {
        return answer_option1;
    }

    public void setAnswer_option1(String answer_option1) {
        this.answer_option1 = answer_option1;
    }

    public String getAnswer_option2() {
        return answer_option2;
    }

    public void setAnswer_option2(String answer_option2) {
        this.answer_option2 = answer_option2;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(String correct_option) {
        this.correct_option = correct_option;
    }
}

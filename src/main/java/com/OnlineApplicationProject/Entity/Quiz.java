package com.OnlineApplicationProject.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String Name;
    private int quizduratuion;
    @OneToMany(mappedBy = "marks_data")
    private List<Marks> marks_d = new ArrayList<>();

    @OneToMany(mappedBy = "questions_datas")
    private List<Questions> questions_data = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(Integer id, String name, int quizduratuion, List<Marks> marks_d, List<Questions> questions_data) {
        this.id = id;
        Name = name;
        this.quizduratuion = quizduratuion;
        this.marks_d = marks_d;
        this.questions_data = questions_data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Marks> getMarks_d() {
        return marks_d;
    }

    public void setMarks_d(List<Marks> marks_d) {
        this.marks_d = marks_d;
    }

    public List<Questions> getQuestions_data() {
        return questions_data;
    }

    public void setQuestions_data(List<Questions> questions_data) {
        this.questions_data = questions_data;
    }

    public int getQuizduratuion() {
        return quizduratuion;
    }

    public void setQuizduratuion(int quizduratuion) {
        this.quizduratuion = quizduratuion;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "Name='" + Name + '\'' +
                '}';
    }
}

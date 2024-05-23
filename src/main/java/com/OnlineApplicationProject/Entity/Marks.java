package com.OnlineApplicationProject.Entity;

import jakarta.persistence.*;

@Entity
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marks_id;
    private float marks;

    @ManyToOne
    @JoinColumn(name = "Quiz_id")
    private Quiz marks_data;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user_data;

    public Marks() {
    }

    public Marks(Integer marks_id, float marks, Quiz marks_data, User user_data) {
        this.marks_id = marks_id;
        this.marks = marks;
        this.marks_data = marks_data;
        this.user_data = user_data;
    }

    public Integer getMarks_id() {
        return marks_id;
    }

    public void setMarks_id(Integer marks_id) {
        this.marks_id = marks_id;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public Quiz getMarks_data() {
        return marks_data;
    }

    public void setMarks_data(Quiz marks_data) {
        this.marks_data = marks_data;
    }

    public User getUser_data() {
        return user_data;
    }

    public void setUser_data(User user_data) {
        this.user_data = user_data;
    }
}

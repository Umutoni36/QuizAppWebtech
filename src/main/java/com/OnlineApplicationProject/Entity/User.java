package com.OnlineApplicationProject.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Fullname;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(mappedBy = "user_data")
    private List<Marks> marks_dd = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String fullname, String email, String password, List<Marks> marks_dd) {
        this.id = id;
        Fullname = fullname;
        this.email = email;
        this.password = password;
        this.marks_dd = marks_dd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Marks> getMarks_dd() {
        return marks_dd;
    }

    public void setMarks_d(List<Marks> marks_dd) {
        this.marks_dd = marks_dd;
    }
}

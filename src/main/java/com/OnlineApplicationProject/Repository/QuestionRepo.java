package com.OnlineApplicationProject.Repository;

import com.OnlineApplicationProject.Entity.Questions;
import com.OnlineApplicationProject.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions,Integer> {


    @Query("select u from Questions u where  u.questions_datas=:quiz_ids")
    List<Questions> getingbyquizid(@Param("quiz_ids") Quiz quiz_id);

}

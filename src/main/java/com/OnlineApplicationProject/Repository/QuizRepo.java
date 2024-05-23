package com.OnlineApplicationProject.Repository;


import com.OnlineApplicationProject.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
    @Query("FROM Quiz ")
    List<Quiz> Retrivealldata();

    @Query("FROM Quiz where id=:quizid ")
    Quiz Retrivequizperid(@Param("quizid") Integer quiz_id);


}

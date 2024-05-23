package com.OnlineApplicationProject.Repository;

import com.OnlineApplicationProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User User_login(@Param("email") String email, @Param("password") String password);
}

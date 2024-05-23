package com.OnlineApplicationProject.Repository;

import com.OnlineApplicationProject.Entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminUserRepo extends JpaRepository<AdminUser,Integer> {
    @Query("SELECT u FROM AdminUser u WHERE u.email = :email AND u.password = :password")
    AdminUser admin_login(@Param("email") String email, @Param("password") String password);
}

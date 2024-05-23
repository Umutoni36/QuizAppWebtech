package com.OnlineApplicationProject.Service.impl;

import com.OnlineApplicationProject.Repository.MarksRepo;
import com.OnlineApplicationProject.Entity.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksServiceImpl {
    @Autowired
   private MarksRepo marksRepo;

    public Marks RegisterMarks(Marks marks){
     Marks savemarks= marksRepo.save(marks);
     return savemarks;
    }
}

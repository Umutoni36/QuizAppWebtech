package com.OnlineApplicationProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@ServletComponentScan
@SpringBootApplication
public class OnlineQuizApplication {

	public static void main(String[] args) {SpringApplication.run(OnlineQuizApplication.class, args);	}

}

package com.OnlineApplicationProject.Security;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/QuizRestriction")
public class RestrictionFilter extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer condition = (Integer) session.getAttribute("quizInProgress");
        session.invalidate();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Project/index.jsp");
        dispatcher.forward(request,response);


    }

}

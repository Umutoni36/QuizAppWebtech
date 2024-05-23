package com.OnlineApplicationProject.Security;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebListener
public class TrackingListener implements HttpSessionListener, ServletContextListener {
    private static final Logger logger = LogManager.getLogger(TrackingListener.class);

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();


        if (session.getAttribute("loggedInUser")!=null) {
            System.out.println("User logged in: " + session.getAttribute("loggedInUser"));
            logger.info("User logged in: " + session.getAttribute("loggedInUser"));
        }
        if (session.getAttribute("quizInProgress")!=null)
            System.out.println("User started the quiz : " + session.getAttribute("quizInProgress"));
        logger.info("User started the quiz: " + session.getAttribute("quizInProgress"));

        }


}


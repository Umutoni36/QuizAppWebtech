package com.OnlineApplicationProject.Security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/Project/AdminUI.jsp",
        "/Project/UserDashboard.jsp",
        "/Project/CompleteQuiz.jsp",
        "/Project/RegisterQuiz.jsp",
        "/Project/Quiz.jsp",
        "/Project/Register.jsp"
})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();

        boolean isAdminLoggedIn = session != null && session.getAttribute("loggedInAdmin") != null;
        boolean isUserLoggedIn = session != null && session.getAttribute("loggedInUser") != null;

        if (isUserLoggedIn && isUserPage(requestURI)) {
            chain.doFilter(request, response);
        } else if (isAdminLoggedIn && isAdminPage(requestURI)) {
            chain.doFilter(request, response);
        } else if (!isUserLoggedIn && isRistrictionPage(requestURI)) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Project/" + getRedirectPage(isUserLoggedIn));
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Project/index.jsp");
        }
    }
    private boolean isUserPage(String requestURI) {
        return requestURI.endsWith("/Project/CompleteQuiz.jsp") ||
                requestURI.endsWith("/Project/Quiz.jsp") ||
                requestURI.endsWith("/Project/UserDashboard.jsp");
    }

    private boolean isAdminPage(String requestURI) {
        return requestURI.endsWith("/Project/AdminUI.jsp") ||
                requestURI.endsWith("/Project/RegisterQuiz.jsp") ||
                requestURI.endsWith("/Project/Register.jsp");
    }
    private boolean isRistrictionPage(String requestURI) {
        return requestURI.endsWith("/Project/AdminUI.jsp") ||
                requestURI.endsWith("/Project/RegisterQuiz.jsp") ||
                requestURI.endsWith("/Project/Register.jsp")||
                requestURI.endsWith("/Project/CompleteQuiz.jsp") ||
                requestURI.endsWith("/Project/Quiz.jsp") ||
                requestURI.endsWith("/Project/UserDashboard.jsp");
    }

    private String getRedirectPage(boolean isUserLoggedIn) {
        return "index.jsp";
    }


}

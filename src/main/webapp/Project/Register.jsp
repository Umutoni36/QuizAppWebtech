<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for centering the form and box shadow background */
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            background-color: #ffffff;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-control {
            border-radius: 5px;
        }
        .btn-primary {
            border-radius: 5px;
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="AdminUI.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3 form-container">
            <h2>Create Quiz</h2>

            <form id="quizForm"method="post" action="/registerQuestion">
                <div class="mb-3">
                    <label for="quizName" class="form-label">Quiz Name</label>
                        <select id="quizName" name="questions_datas" class="form-control">
                            <option > Select  quiz name</option>
                            <option></option>
                            <c:forEach var="quiz" items="${quizzes}">
                                <option value="${quiz.id}">${quiz.name}</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="mb-3">
                    <label for="question" class="form-label">Question</label>
                    <input type="text" class="form-control" id="question" name="question_name" placeholder="Enter question" required>
                </div>
                <div class="mb-3">
                    <label for="option1" class="form-label">Option 1</label>
                    <input type="text" class="form-control" id="option1" name="answer_option1" placeholder="Enter option 1" required>
                </div>
                <div class="mb-3">
                    <label for="option2" class="form-label">Option 2</label>
                    <input type="text" class="form-control" id="option2" name="answer_option2" placeholder="Enter option 2" required>
                </div>
                <div class="mb-3">
                    <label for="option1" class="form-label">Correct Answer</label>
                    <input type="text" class="form-control" id="answer" name="correct_option" placeholder="Enter option 1" required>
                </div>
                <button type="submit" class="btn btn-primary">Create Quiz</button>
                <div class="row justify-content-center" style="margin-top: 50px;color: cadetblue; text-align: center" > <h5  style="font-family: 'Bahnschrift'">
                       ${message}

                </h5></div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
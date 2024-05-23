<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">

                <div class="card-body">
                    <h5 class="card-title">Welcome to the User Dashboard</h5>
                    <p class="card-text">Choose a quiz from the list below to get started.</p>
                    <ul class="list-group">
                        <c:forEach var="quiz" items="${quizzes}">
                            <li class="list-group-item" style="color: black;">
                                <a href="/question/${quiz.id}">${quiz.name}</a>
                            </li>
                        </c:forEach>
                    </ul>

                </div>

            </div>
            <p class="mt-3 text-center"><a href="/logout">Sign out</a></p>
        </div>
    </div>
</div>
</body>
</html>
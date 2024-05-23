<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Name Form</title>
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
<jsp:include page="AdminUI.jsp.jsp"></jsp:include>
<div class="container">

    <div class="row">
        <div class="col-md-7 offset-md-4 form-container">
            <h2>Enter Quiz Name</h2>
            <form action="/registerQuiz" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" id="quizName" name="name" placeholder="Enter quiz name" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="quizduration" name="quizduratuion" placeholder="Enter quiz time duration" required>
                </div>
                <button type="submit" class="btn btn-primary">Start Quiz</button>
            </form>
            <div class="row justify-content-center" style="margin-top: 50px;color: #41852f; margin-left: 25%" > <h5 style="font-family: 'Arial Narrow'">
                ${message}
            </h5></div>
        </div>


    </div>

</div>


<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
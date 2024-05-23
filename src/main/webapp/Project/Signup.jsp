<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Sign Up </h2>
            <form action="/signup" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Sign Up</button>

            </form>
        </div>


    </div>
    <p class="mt-3 text-center">If you have an account? <a href="/Project/index.jsp">Sign In here</a>.</p>

    <div class="row justify-content-center" style="margin-top: 50px;color: cadetblue" > <h5  style="font-family: 'Arial Narrow'">
        <%
            Object numbersAttribute = request.getAttribute("message");
            if (numbersAttribute != null) {
        %>
        <%= numbersAttribute %>
        <%
            }
        %>
    </h5></div>
</div>
</body>
</html>
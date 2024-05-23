<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
            <h2 class="text-center mb-4">Login</h2>
            <form action="/login" method="Post">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <input type="checkbox" id="rememberMe" name="rememberMe">
                    <label for="rememberMe">Remember Me</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
            <p class="mt-3 text-center">Don't have an account? <a href="/Project/Signup.jsp">Sign up here</a>.</p>
        </div>
    </div>
</div>
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

<script>
    window.onload = function() {
        var rememberMeCheckbox = document.getElementById("rememberMe");
        var emailInput = document.getElementById("email");
        var passwordInput = document.getElementById("password");
        if (document.cookie.includes("rememberMe")) {
            rememberMeCheckbox.checked = true;
            var cookieValue = document.cookie.replace(/(?:(?:^|.*;\s*)rememberMe\s*\=\s*([^;]*).*$)|^.*$/, "$1");
            var email = cookieValue.split(":")[0];
            var password = cookieValue.split(":")[1];
            emailInput.value = email;
            passwordInput.value = password;
        }
    };
</script>
</body>
</html>
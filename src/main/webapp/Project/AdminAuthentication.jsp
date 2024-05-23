<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <div class="col-md-6" >
            <h2 class="text-center mb-4" STYLE="font-family: Bahnschrift">ADMINISTRATOR LOGIN</h2>
            <form action="/adminLogin" method="Post">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block" style="width: 250px; margin-left: 27%">Login</button>
            </form>

        </div>
    </div>
</div>
<div class="row justify-content-center" style="margin-top: 50px;color:#ad1836" > <h5 style="font-family: 'Cambria Math'">
    <%
        Object numbersAttribute = request.getAttribute("message");
        if (numbersAttribute != null) {
    %>
    <%= numbersAttribute %>
    <%
        }
    %>
</h5></div>

</body>
</html>
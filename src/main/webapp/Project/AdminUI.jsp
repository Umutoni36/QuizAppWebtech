<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        /* Custom styles for dashboard */
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            background-color: #343a40;
            padding-top: 60px;
        }
        .sidebar-brand {
            color: #fff;
            font-size: 24px;
            font-weight: bold;
            padding: 20px;
            text-align: center;
        }
        .sidebar-nav-link {
            color: #fff;
            padding: 10px;
            display: block;
            text-align: center;
            transition: 0.3s;
        }
        .sidebar-nav-link:hover {
            background-color: #495057;
            text-decoration: none;
        }
        .main-content {
            margin-left: 250px;
            padding: 20px;
        }
        .navbar {
            background-color: #343a40;
            color: #fff;
        }
        .navbar-brand {
            color: #fff !important;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <div class="sidebar-brand">Admin Dashboard</div>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link sidebar-nav-link" href="#"><i class="fas fa-home"></i> Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link sidebar-nav-link" href="#"><i class="fas fa-users"></i> Users</a>
        </li>
        <li class="nav-item">
            <a class="nav-link sidebar-nav-link" href="/Project/RegisterQuiz.jsp"><i class="fas fa-cog"></i>Add New Quiz</a>
        </li>
        <li class="nav-item">
            <a class="nav-link sidebar-nav-link" href="/Register_form"><i class="fas fa-cog"></i>Add Questions</a>
        </li>
    </ul>
</div>



<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .navbar a.active {
            background-color: #666;
        }
    </style>
    <script>
        function changeTheme(themeColor) {
            document.body.style.backgroundColor = themeColor;
            fetch('/update-theme?theme=' + encodeURIComponent(themeColor), { method: 'POST' })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to update theme');
                    }

                    if (themeColor === '#000') {
                        document.querySelector('.navbar-light').style.display = 'none';
                        document.querySelector('.navbar-dark').style.display = 'block';
                    } else {
                        document.querySelector('.navbar-light').style.display = 'block';
                        document.querySelector('.navbar-dark').style.display = 'none';
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }
    </script>
</head>
<body>

<div class="navbar">
    <button onclick="changeTheme('#000')">Dark Mode</button>
    <button onclick="changeTheme('#f8f9fa')">Light Mode</button>
</div>



</body>
</html>
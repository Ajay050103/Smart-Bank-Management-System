<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Created</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #e0f7fa, #f1f8e9);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: white;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 400px;
    }

    h1 {
        color: #2e7d32;
        font-size: 20px;
        margin: 15px 0;
    }

    button {
        margin-top: 30px;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #00796b;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #004d40;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Account Number: <%= request.getAttribute("accountNumber") %></h1>
    <h1>Password: <%= request.getAttribute("password") %></h1>
    <button onclick="history.back()">BACK</button>
</div>
</body>
</html>

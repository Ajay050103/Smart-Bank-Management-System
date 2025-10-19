<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Details</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #f0f4f8, #d9e2ec);
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
        color: #2c3e50;
        margin-bottom: 20px;
    }

    h2 {
        color: #34495e;
        font-size: 18px;
        line-height: 1.6;
    }

    button {
        margin-top: 30px;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Account Holder Details</h1>
    <h2>
        Account Number: <%= session.getAttribute("A/cno") %><br>
        Balance: ₹<%= request.getAttribute("balance") %>
    </h2>
    <button onclick="history.back()">BACK</button>
</div>
</body>
</html>

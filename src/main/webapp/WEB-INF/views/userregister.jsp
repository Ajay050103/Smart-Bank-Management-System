<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
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
        margin-bottom: 30px;
    }

    input[type="number"], input[type="submit"] {
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 16px;
    }

    input[type="submit"] {
        background-color: #00796b;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #004d40;
    }

    .message {
        margin-top: 20px;
        color: #d32f2f;
        font-weight: bold;
    }

    button {
        margin-top: 20px;
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
    <h1>New User Registration</h1>
    <form action="createpassword" method="post">
        <input type="number" name="accountNumber" placeholder="Account Number" required><br>
        <input type="number" name="password" placeholder="Password" required><br>
        <input type="submit" value="Register">
    </form>
    <div class="message">
        <%= request.getAttribute("message") %><br>
        <%= request.getAttribute("message3") %>
    </div>
    <button onclick="history.back()">BACK</button>
</div>
</body>
</html>

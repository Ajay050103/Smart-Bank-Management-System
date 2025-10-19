<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<style>
  body {
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
    padding: 40px;
    text-align: center;
  }
  h1 {
    color: #333;
    margin-bottom: 30px;
  }
  form {
    display: inline-block;
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    text-align: left;
  }
  input[type="number"],
  input[type="text"] {
    padding: 10px;
    width: 100%;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="submit"] {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
  .message {
    margin-top: 20px;
    font-weight: bold;
    color: #d9534f;
  }
  button {
    margin-top: 30px;
    padding: 10px 20px;
    background-color: #555;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
</head>
<body>
<h1>User Login Here</h1>
<form action="loginchek" method="post">
  Account Number:<br>
  <input type="number" name="accountNumber"><br>
  Password:<br>
  <input type="text" name="password"><br>
  <input type="submit" value="Login">
</form>

<button onclick="history.back()">BACK</button>

<div class="message">
  <%= request.getAttribute("message2") %>
</div>
</body>
</html>

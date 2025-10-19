<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<style>
  body {
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
    padding: 40px;
    text-align: center;
  }
  h1 {
    color: #333;
  }
  form {
    display: inline-block;
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }
  input[type="text"] {
    padding: 10px;
    width: 250px;
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
    color: green;
    font-weight: bold;
  }
</style>
</head>
<body>
<h1>Change Password</h1>
<form action="changePassword" method="post">
  New Password: <br>
  <input type="text" name="newpassword"><br><br>
  Confirm Password: <br>
  <input type="text" name="confirmpasword"><br><br>
  <input type="submit" value="Submit">
</form>
<button onclick="history.back()">BACK</button>
<div class="message">
  <%= request.getAttribute("message1") %>
</div>
</body>
</html>

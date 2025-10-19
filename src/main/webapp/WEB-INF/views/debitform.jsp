<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Debit Amount</title>
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
    background-color: red;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: darkred;
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
<h1>Debit Amount</h1>
<form action="admindebit" method="post">
  Account Number:<br>
  <input type="number" name="accountNumber"><br>
  Amount:<br>
  <input type="number" name="amount"><br>
  Description:<br>
  <input type="text" name="description"><br>
  <input type="submit" value="DEBIT">
</form>

<div class="message">
  <%= request.getAttribute("failed") %>
  <%= request.getAttribute("debit") %>
</div>

<button onclick="history.back()">BACK</button>
</body>
</html>

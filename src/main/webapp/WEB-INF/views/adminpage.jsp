<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<style>
  body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  h1 {
    color: #333;
    margin-bottom: 30px;
  }

  form {
    text-align: center;
    margin-bottom: 30px;
  }
  input[type="text"],
  input[type="email"],
  input[type="number"] {
    padding: 8px;
    width: 300px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-bottom: 15px;
  }

  input[type="submit"] {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .button-group {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 15px;
  }

  .button-group button {
    padding: 10px 20px;
    width: 220px;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
  }

  .credit { background-color: green; }
  .debit { background-color: red; }
  .history { background-color: red; }
  .logout { background-color: #555; }
</style>
</head>
<body>
<h1>Create New Account</h1>
<form action="createnewuser" method="post">
  <input type="text" name="name" placeholder="User Name" required><br>
  <input type="email" name="email" placeholder="Email" required><br>
  <input type="number" name="aadharNumber" placeholder="Aadhar Number" required><br>
  <input type="submit" value="Submit">
</form>
<div class="button-group">
  <button class="credit" onclick="window.location.href='admincreditform'">CREDIT</button>
  <button class="debit" onclick="window.location.href='admindebitform'">DEBIT</button>
  <button class="history" onclick="window.location.href='admintranshistory'">Transactions History</button>
  <button class="logout" onclick="history.back()">Logout</button>
</div>
</body>
</html>

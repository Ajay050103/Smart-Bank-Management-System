<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<style>
  body {
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
    padding: 40px;
    text-align: center;
  }
  h1 {
    color: #333;
    margin-bottom: 40px;
  }
  button {
    display: block;
    width: 250px;
    margin: 15px auto;
    padding: 12px 20px;
    font-size: 16px;
    font-weight: bold;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  button.green {
    background-color: green;
  }
  button.blue {
    background-color: blue;
  }
  button.black {
    background-color: black;
  }
  button.gray {
    background-color: #555;
  }
</style>
</head>
<body>
  <h1>Welcome to your Account: <%= session.getAttribute("A/cno") %></h1>

  <button class="green" onclick="window.location.href='usercheckbalance'">Check Balance</button>
  <button class="blue" onclick="window.location.href='usertransferamountform'">Transfer Amount</button>
  <button class="black" onclick="window.location.href='userhistory'">History</button>
  <button class="blue" onclick="window.location.href='loanapply'">Apply for Loan</button>
  <button class="green" onclick="window.location.href='loanstatus'">My Loan Status</button>
  <button class="gray" onclick="history.back()">Logout</button>
</body>
</html>

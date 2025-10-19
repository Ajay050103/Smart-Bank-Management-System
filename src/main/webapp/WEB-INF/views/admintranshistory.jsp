<%@page import="com.model.Transactions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<style>
  body {
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
    padding: 30px;
  }
  h1 {
    color: #333;
    text-align: center;
  }
  form {
    text-align: center;
    margin-bottom: 20px;
  }
  input[type="number"] {
    padding: 8px;
    width: 250px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="submit"] {
    padding: 8px 16px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-left: 10px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
  }
  th, td {
    padding: 12px;
    border: 1px solid #ccc;
    text-align: center;
  }
  th {
    background-color: #007bff;
    color: white;
  }
  tr:nth-child(even) {
    background-color: #f9f9f9;
  }
  button {
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #555;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    display: block;
    margin-left: auto;
    margin-right: auto;
  }
</style>
</head>
<body>
<h1>ALL TRANSACTIONS HISTORY</h1>
<form action="statement" method="post">
  Account Number: <input type="number" name="accountNumber">
  <input type="submit" value="GET STATEMENT">
</form>

<table>
<tr> 
    <th>Transaction ID</th>
    <th>Date & Time</th>
    <th>Account Number</th>
    <th>Amount</th>
    <th>Payment Type</th>
    <th>Description</th>
    <th>Balance</th>
</tr>
<%
  List<Transactions> transaction = (List<Transactions>) request.getAttribute("transahistory");
  if (transaction != null) {
    for (Transactions trans : transaction) {
%>
<tr>
    <td><%= trans.getTransId() %></td>
    <td><%= trans.getTimeStamp() %></td>
    <td><%= trans.getAccountNumber() %></td>
    <td><%= trans.getAmmount() %></td>
    <td><%= trans.getType() %></td>
    <td><%= trans.getDescription() %></td>
    <td><%= trans.getBalance() %></td>
</tr>
<%
    }
  }
%>
</table><br>
<button onclick="history.back()">BACK</button>
</body>
</html>

<%@page import="com.model.Transactions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement</title>
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
  table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
    margin-bottom: 20px;
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
<h1>ACCOUNT HOLDER STATEMENT HISTORY</h1>

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
  List<Transactions> transaction = (List<Transactions>) request.getAttribute("statement");
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
</table>

<button onclick="history.back()">BACK</button>
</body>
</html>

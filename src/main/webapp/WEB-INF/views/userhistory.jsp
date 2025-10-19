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
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #f0f4f8, #d9e2ec);
        display: flex;
        flex-direction: column;
        align-items: center;
        min-height: 100vh;
    }

    h1 {
        margin-top: 40px;
        color: #2c3e50;
    }

    table {
        margin-top: 20px;
        border-collapse: collapse;
        width: 90%;
        max-width: 1000px;
        background-color: white;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #3498db;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    button {
        margin: 30px 0;
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
<h1>Transaction History</h1>
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
        List<Transactions> transaction = (List<Transactions>) request.getAttribute("history"); 
        for(Transactions trans : transaction){
    %>
    <tr>
        <td><%= trans.getTransId() %></td>
        <td><%= trans.getTimeStamp() %></td>
        <td><%= trans.getAccountNumber() %></td>
        <td>₹<%= trans.getAmmount() %></td>
        <td><%= trans.getType() %></td>
        <td><%= trans.getDescription() %></td>
        <td>₹<%= trans.getBalance() %></td>
    </tr>
    <% } %>
</table>
<button onclick="history.back()">BACK</button>
</body>
</html>

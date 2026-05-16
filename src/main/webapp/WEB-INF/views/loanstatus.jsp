<%@page import="com.model.LoanApplication"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Loan Applications</title>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(to right, #f0f4f8, #d9e2ec);
    padding: 30px;
    text-align: center;
  }
  h1 { color: #2c3e50; }
  table {
    margin: 20px auto;
    border-collapse: collapse;
    width: 95%;
    background: #fff;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  }
  th, td { border: 1px solid #ddd; padding: 10px; }
  th { background: #00796b; color: #fff; }
  .PENDING { color: #f39c12; font-weight: bold; }
  .APPROVED { color: #27ae60; font-weight: bold; }
  .REJECTED { color: #e74c3c; font-weight: bold; }
  button {
    margin-top: 20px;
    padding: 10px 20px;
    background: #3498db;
    color: #fff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
  }
</style>
</head>
<body>
<h1>My Loan Applications</h1>
<p>Account: <%= session.getAttribute("A/cno") %></p>

<table>
  <tr>
    <th>Loan ID</th>
    <th>Type</th>
    <th>Amount</th>
    <th>Tenure</th>
    <th>Applied On</th>
    <th>Status</th>
    <th>EMI</th>
    <th>Remarks</th>
  </tr>
  <%
    List<LoanApplication> loans = (List<LoanApplication>) request.getAttribute("loans");
    if (loans != null && !loans.isEmpty()) {
      for (LoanApplication loan : loans) {
  %>
  <tr>
    <td><%= loan.getLoanId() %></td>
    <td><%= loan.getLoanType() %></td>
    <td>&#8377;<%= loan.getLoanAmount() %></td>
    <td><%= loan.getTenureMonths() %> months</td>
    <td><%= loan.getAppliedDate() %></td>
    <td class="<%= loan.getStatus() %>"><%= loan.getStatus() %></td>
    <td><%= loan.getEmiAmount() > 0 ? "&#8377;" + loan.getEmiAmount() : "-" %></td>
    <td><%= loan.getAdminRemarks() != null ? loan.getAdminRemarks() : "-" %></td>
  </tr>
  <% } } else { %>
  <tr><td colspan="8">No loan applications found.</td></tr>
  <% } %>
</table>

<button onclick="window.location.href='loanapply'">Apply New Loan</button>
<button onclick="history.back()">BACK</button>
</body>
</html>

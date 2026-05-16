<%@page import="com.model.LoanApplication"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Applications - Admin</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background: #f2f2f2;
    padding: 24px;
  }
  h1 { text-align: center; color: #333; }
  .message {
    text-align: center;
    font-weight: bold;
    color: #007bff;
    margin-bottom: 16px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    background: #fff;
    margin-top: 16px;
  }
  th, td { border: 1px solid #ddd; padding: 8px; text-align: left; font-size: 14px; }
  th { background: #007bff; color: #fff; }
  .actions form { display: inline; margin: 2px 0; }
  .actions input[type="text"] { width: 120px; padding: 4px; }
  .actions button { padding: 4px 10px; cursor: pointer; border: none; border-radius: 4px; color: #fff; }
  .approve { background: green; }
  .reject { background: red; }
  .back-btn {
    display: block;
    margin: 24px auto;
    padding: 10px 20px;
    background: #555;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
</head>
<body>
<h1>Loan Application Management</h1>
<div class="message"><%= request.getAttribute("message") %></div>

<table>
  <tr>
    <th>ID</th>
    <th>Account</th>
    <th>Type</th>
    <th>Amount</th>
    <th>Tenure</th>
    <th>Income</th>
    <th>Purpose</th>
    <th>Applied</th>
    <th>Status</th>
    <th>EMI</th>
    <th>Actions</th>
  </tr>
  <%
    List<LoanApplication> loans = (List<LoanApplication>) request.getAttribute("loans");
    if (loans != null) {
      for (LoanApplication loan : loans) {
  %>
  <tr>
    <td><%= loan.getLoanId() %></td>
    <td><%= loan.getAccountNumber() %></td>
    <td><%= loan.getLoanType() %></td>
    <td>&#8377;<%= loan.getLoanAmount() %></td>
    <td><%= loan.getTenureMonths() %> mo</td>
    <td>&#8377;<%= loan.getMonthlyIncome() %></td>
    <td><%= loan.getPurpose() %></td>
    <td><%= loan.getAppliedDate() %></td>
    <td><%= loan.getStatus() %></td>
    <td><%= loan.getEmiAmount() > 0 ? "&#8377;" + loan.getEmiAmount() : "-" %></td>
    <td class="actions">
      <% if ("PENDING".equals(loan.getStatus())) { %>
      <form action="loanapprove" method="post">
        <input type="hidden" name="loanId" value="<%= loan.getLoanId() %>">
        <input type="text" name="remarks" placeholder="Remarks">
        <button type="submit" class="approve">Approve</button>
      </form>
      <form action="loanreject" method="post">
        <input type="hidden" name="loanId" value="<%= loan.getLoanId() %>">
        <input type="text" name="remarks" placeholder="Reason">
        <button type="submit" class="reject">Reject</button>
      </form>
      <% } else { %>
        <%= loan.getAdminRemarks() != null ? loan.getAdminRemarks() : "-" %>
      <% } %>
    </td>
  </tr>
  <% } } %>
</table>

<button class="back-btn" onclick="history.back()">BACK</button>
</body>
</html>

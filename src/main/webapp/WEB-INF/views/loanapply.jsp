<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply for Loan</title>
<style>
  body {
    background: linear-gradient(to right, #e0f7fa, #f1f8e9);
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    padding: 40px;
    text-align: center;
  }
  .container {
    background: #fff;
    max-width: 480px;
    margin: 0 auto;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    text-align: left;
  }
  h1 { text-align: center; color: #2e7d32; }
  label { display: block; margin-top: 12px; font-weight: bold; color: #333; }
  input, select, textarea {
    width: 100%;
    padding: 10px;
    margin-top: 6px;
    border: 1px solid #ccc;
    border-radius: 6px;
    box-sizing: border-box;
  }
  input[type="submit"] {
    margin-top: 20px;
    background: #00796b;
    color: #fff;
    border: none;
    cursor: pointer;
    font-weight: bold;
  }
  .message { text-align: center; margin-top: 16px; color: #d32f2f; font-weight: bold; }
  button {
    display: block;
    margin: 20px auto 0;
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
<div class="container">
  <h1>Loan Application</h1>
  <p style="text-align:center;">Account: <%= session.getAttribute("A/cno") %></p>

  <form action="loansubmit" method="post">
    <label>Loan Type</label>
    <select name="loanType" required>
      <option value="Personal">Personal Loan</option>
      <option value="Home">Home Loan</option>
      <option value="Education">Education Loan</option>
      <option value="Business">Business Loan</option>
    </select>

    <label>Loan Amount (&#8377;)</label>
    <input type="number" name="loanAmount" min="1000" step="0.01" required>

    <label>Tenure (Months)</label>
    <input type="number" name="tenureMonths" min="1" max="360" required>

    <label>Monthly Income (&#8377;)</label>
    <input type="number" name="monthlyIncome" min="1" step="0.01" required>

    <label>Purpose</label>
    <textarea name="purpose" rows="3" placeholder="Reason for loan" required></textarea>

    <input type="submit" value="Submit Application">
  </form>

  <div class="message"><%= request.getAttribute("message") %></div>
</div>
<button onclick="window.location.href='loanstatus'">View My Loan Status</button>
<button onclick="history.back()">BACK</button>
</body>
</html>

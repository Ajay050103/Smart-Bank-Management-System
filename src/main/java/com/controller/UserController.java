package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.LoanApplication;
import com.model.Transactions;
import com.service.LoanService;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	LoanService loanService;
	
	@GetMapping("/register")
	public String userRegister() {
		return "userregister";
	}
	
	
	
	
	@GetMapping("/usertransferamountform")
	public String userTransferAmountForm() {
		return "usertransferamountform";
	}
	@GetMapping("/login")
	public String userLogin() {
		return "loginpage";
	}
//	user register
	
	@PostMapping("/createpassword")
	public String createPassword(HttpServletRequest req, Model model) {
		String accountNumber = req.getParameter("accountNumber");
		String password = req.getParameter("password");
		HttpSession session= req.getSession();
		session.setAttribute("accountNumber", accountNumber);
		model.addAttribute("message", "Entered Wrong Ac/no or Password  please check!!!");
		boolean passwordcheck = userService.getUserByAccountNumber(accountNumber,password);
		if(passwordcheck) {
			return "createpassword";
		}
		else {
			return "userregister";
		}
	}
//	change password
	@PostMapping("/changePassword")
	public String changePassword(HttpServletRequest req,Model model) {
		String newPassword = req.getParameter("newpassword");
		String confirmPassword = req.getParameter("confirmpasword");
		String password = (String)req.getSession().getAttribute("accountNumber");
		boolean changePassword = userService.changePassword(newPassword,confirmPassword,password);
		req.setAttribute("message1", "Enter correct password");
		if(changePassword) {
			return "loginpage";
		}
		else{
		return"createpassword";	
		}
		
	}
	
//	loginchek
	@PostMapping("/loginchek")
	public String loginCheck(HttpServletRequest req,Model model) {
		String accountNumber = req.getParameter("accountNumber");
		String password = req.getParameter("password");
		req.getSession().setAttribute("A/cno", accountNumber);
		model.addAttribute("message2","invalid account number or password");
		model.addAttribute("message3","please register here");
		String jsppage = userService.loginCheck(accountNumber,password);
		
		return jsppage;
	}
	
//user 	amount transfer through account number
	@PostMapping("usermoneytransfer")
	public String userAmountTransfer(HttpServletRequest req ,Model model) {
		
		String receiverAcNo = req.getParameter("receiverAccontNumber");
		double amount = Double.parseDouble(req.getParameter("amount"));
		String senderAcNo = (String)req.getSession().getAttribute("A/cno");
		boolean transfer = userService.userAmountTransfer(senderAcNo,amount,receiverAcNo);
		if(transfer) {
			model.addAttribute("message", "Amount Transfer Successfull to "+receiverAcNo);
			return "usertransferamountform";
		}
		else {
			model.addAttribute("message", "Transaction Failed  !! Check A/C no (OR) BALANCE ");
			return"usertransferamountform";
		}
	}
//	Check User Balance
	@GetMapping("/usercheckbalance")
	public String userCheckBalance(HttpServletRequest req ,Model model) {
		String accountNumber =(String) req.getSession().getAttribute("A/cno");
		double balance=userService.getBalance(accountNumber);
		model.addAttribute("balance", balance);
		return "usercheckbalance";
	}
//	userHistory
	@GetMapping("/userhistory")
	public String userHistory(HttpServletRequest req ,Model model) {
		String accountNuumber=(String) req.getSession().getAttribute("A/cno");
		List<Transactions> transactions=userService.getHistory(accountNuumber);
		model.addAttribute("history", transactions);
		return"userhistory";
	}

	@GetMapping("/loanapply")
	public String loanApplyForm() {
		return "loanapply";
	}

	@PostMapping("/loansubmit")
	public String submitLoanApplication(HttpServletRequest req, Model model) {
		String accountNumber = (String) req.getSession().getAttribute("A/cno");
		double loanAmount = Double.parseDouble(req.getParameter("loanAmount"));
		String loanType = req.getParameter("loanType");
		int tenureMonths = Integer.parseInt(req.getParameter("tenureMonths"));
		double monthlyIncome = Double.parseDouble(req.getParameter("monthlyIncome"));
		String purpose = req.getParameter("purpose");

		boolean applied = loanService.applyForLoan(accountNumber, loanAmount, loanType, tenureMonths, monthlyIncome,
				purpose);
		if (applied) {
			model.addAttribute("message", "Loan application submitted successfully. Status: PENDING");
		} else {
			model.addAttribute("message",
					"Application failed. Check amount/tenure/income or you may already have a pending loan.");
		}
		return "loanapply";
	}

	@GetMapping("/loanstatus")
	public String loanStatus(HttpServletRequest req, Model model) {
		String accountNumber = (String) req.getSession().getAttribute("A/cno");
		List<LoanApplication> loans = loanService.getLoansByAccount(accountNumber);
		model.addAttribute("loans", loans);
		return "loanstatus";
	}
}

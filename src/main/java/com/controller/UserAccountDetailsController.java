package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.Transactions;
import com.model.UserAccountDetails;
import com.service.UserAccountDetailsService;
import com.utils.AccountNumberGenerator;
import com.utils.UserPasswordGenerator;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class UserAccountDetailsController {
	@Autowired
	UserAccountDetailsService userAccountDetailsService;

	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	
	@Autowired
	UserPasswordGenerator userPasswordGenerator;
//	create new user Accoount form
	@RequestMapping("/useraccountform")
	public String userAccountForm() {
		return "adminpage";// This loads /WEB-INF/views/useraccountform.jsp
		
	}
//	creditform
    @GetMapping("/admincreditform")
    public String showCreditForm() {
        return "creditform";  // Resolves to /WEB-INF/views/creditform.jsp
    }
//	Debitform
    @GetMapping("/admindebitform")
    public String showDebitForm() {
        return "debitform";  // Resolves to /WEB-INF/views/creditform.jsp
    }
    
//	User Account Creation By admin
	@PostMapping("/createnewuser")
	public String createAccountbyAdmin(Model model,HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String aadharNumber = req.getParameter("aadharNumber");		
		String accountNumber = accountNumberGenerator.userAccountNumber();
		String password = userPasswordGenerator.userPassword();
		UserAccountDetails userAccountDetails= new UserAccountDetails();
		userAccountDetails.setName(name);
		userAccountDetails.setAccountNumber(accountNumber);
		userAccountDetails.setPassword(password);
		userAccountDetails.setEmail(email);
		userAccountDetails.setAadharNumber(aadharNumber);
		userAccountDetails.setRegistered(false);
		userAccountDetails.setOtp("");
//		send accountNumber and password to  UI
		model.addAttribute("accountNumber", accountNumber);
		model.addAttribute("password", password);
//		save the new user 
		System.out.println(userAccountDetails);
		userAccountDetailsService.saveNewUser(userAccountDetails);
		return "usercreated";
	}

//	credit amount
	@PostMapping("/admincredit")
	public String credit(HttpServletRequest req , Model model ){
		String accountNumber = req.getParameter("accountNumber");
		long amount = Long.parseLong(req.getParameter("amount"));
		String description = req.getParameter("description");
		boolean credit = userAccountDetailsService.creditByAdmin(accountNumber, amount, description);
		if (credit) {
			model.addAttribute("credit", "Amount credited to a/c no : "+accountNumber);
			return "creditform";
		}
		else {
			model.addAttribute("failed","No account with a/c no : " +accountNumber);
			return"creditform";
		}
	}	
//	debit amount
	@PostMapping("/admindebit")
	public String debit(HttpServletRequest req , Model model ){
		String accountNumber = req.getParameter("accountNumber");
		long amount = Long.parseLong(req.getParameter("amount"));
		String description = req.getParameter("description");
		boolean debit = userAccountDetailsService.debititByAdmin(accountNumber, amount, description);
		if (debit) {
			model.addAttribute("debit", "Amount debited to a/c no : "+accountNumber);
			return "debitform";
		}
		else {
			model.addAttribute("failed","No account with a/c no : " +accountNumber +"Or Insufficient funds");
			return"debitform";
		}
	}
//	All Transaction History
	@GetMapping("admintranshistory")
	public String getAllTransactionsbyAdmin( HttpServletRequest http,Model model) {
		List<Transactions> transactions = userAccountDetailsService.getAllTransactionsbyAdmin();
		model.addAttribute("transahistory",transactions);
		return "admintranshistory";
	}
//Transactions Statement
	@PostMapping("/statement")
	public String getTransactionsStatement(HttpServletRequest req) {
		String accountNumber = req.getParameter("accountNumber");
		List <Transactions> statement=userAccountDetailsService.getUserStatement(accountNumber);
		req.setAttribute("statement", statement);
		return "statement";
	}
}

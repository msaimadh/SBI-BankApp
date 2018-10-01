package com.capgemini.bankapplication.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapplication.customer.service.CustomerService;

import com.capgemini.bankapplication.entities.BankAccount;
import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.exception.LowBalanceException;
import com.capgemini.bankapplication.service.BankAccountService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankAccountService bankAccountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@ModelAttribute Customer customer, HttpServletRequest request, HttpSession session) {
		Customer c = customerService.authenticate(customer);
		session = request.getSession();
		if (c != null) {
			session.setAttribute("customer", c);
			return "home";
		}
		return "redirect:/home"; // check
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getlogoutPage(Model model) {
		return "logout";
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public String getEditPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);
		System.out.println(customer);
		return "editProfilePage";
	}

	@RequestMapping(value = "/editProfile.do", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute Customer customer, HttpServletRequest request) {
		if (customerService.updateProfile(customer) != null)
			return "successEdit";
		return "error";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String getPasswordEditPage(){
		return "changePassword";
	}

	@RequestMapping(value = "/changePassword.do", method = RequestMethod.POST)
	public String updatePassword(@ModelAttribute Customer customer, @RequestParam String oldPassword,
			@RequestParam String newPassword, HttpServletRequest request, HttpSession session) {
		customer=(Customer) session.getAttribute("customer");
		if (customerService.updatePassword(customer, oldPassword, newPassword)) {
			session.setAttribute("customer", customer);
			return "successfulPasswordChange";
		}
		return "errorPage";
	}

	@RequestMapping(value = "/checkBalance.do", method = RequestMethod.GET)
	public String getBalancePage() {
		return "checkBalance";
	}

	@RequestMapping(value = "/transferAmount", method = RequestMethod.GET)
	public String getFundTransferPage() {
		return "transferAmount";
	}

	@RequestMapping(value = "/transferAmount.do", method = RequestMethod.POST)
	public String fundTransfer(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam long fromAccount, @RequestParam long toAccount, @RequestParam double amount)
			throws LowBalanceException {
		Customer customer = (Customer) session.getAttribute("customer");
		if (bankAccountService.fundTransfer(fromAccount, toAccount, amount)) {
			session.setAttribute("customer", customer);
			return "successfullTransfer";
		}
		return "errorPage";
	}

}	
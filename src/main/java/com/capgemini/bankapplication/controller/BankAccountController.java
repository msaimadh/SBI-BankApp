package com.capgemini.bankapplication.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapplication.customer.service.Customerservice;
import com.capgemini.bankapplication.entities.BankAccount;
import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.exception.InsufficientAccountBalanceException;
import com.capgemini.bankapplication.exception.NegativeAmountException;
import com.capgemini.bankapplication.service.BankAccountService;

@Controller
public class BankAccountController {

		@Autowired
		private BankAccountService bankaccountService;

		@RequestMapping("/k")
		public String sayHello() {
			return "index";
		}

		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getHeaderPage() {
			return "header";
		}

		@RequestMapping(value = "/balance", method = RequestMethod.GET)
		public String getBalancePage(HttpSession session, HttpServletRequest request, Model model) throws SQLException {
			BankAccount account;
			session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");
			System.out.println(customer);
			double balance = bankaccountService.getBalance(customer.getAccount().getAccountId());
		
			model.addAttribute("balance", balance);
			return "balance";
		}

		@RequestMapping(value = "/transfer", method = RequestMethod.GET)
		public String getFundTransferPage() {
			return "transfer";
		}

		@RequestMapping(value = "/transfer", method = RequestMethod.POST)
		public String fundTransfer(HttpSession session, HttpServletRequest request, Model model,
				@RequestParam long fromAccount, @RequestParam long toAccount, @RequestParam double amount) throws InsufficientAccountBalanceException, NegativeAmountException, SQLException {
			Customer customer = (Customer) session.getAttribute("customer");
			bankaccountService.fundTransfer(fromAccount, toAccount, amount);
			session.setAttribute("customer", customer);
			request.setAttribute("success", true);
			return "successFundTransfer";

		}

	}
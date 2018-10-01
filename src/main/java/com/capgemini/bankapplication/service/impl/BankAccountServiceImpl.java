package com.capgemini.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapplication.exception.LowBalanceException;
import com.capgemini.bankapplication.repository.BankAccountRepository;
import com.capgemini.bankapplication.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			if (balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			} else
				throw new LowBalanceException("You Dont Have sufficient balance");
		}
		return -1;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			bankAccountRepository.updateBalance(accountId, balance + amount);
			return bankAccountRepository.getBalance(accountId);
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		double balance = withdraw(fromAccount, amount);
		if (balance != -1) {
			if (deposit(toAccount, amount) == -1) {
				deposit(fromAccount, amount);
				return false;
			}
			return true;
		}
		return false;
	}
}
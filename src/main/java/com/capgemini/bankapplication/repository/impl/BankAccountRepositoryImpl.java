package com.capgemini.bankapplication.repository.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.repository.BankAccountRepository;



@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) {
		double balance = jdbcTemplate.queryForObject("SELECT account_balance FROM bankaccount Where account_id=?",
				new Object[] { accountId }, Double.class);
		return balance;
	}

	@Override
	public double updateBalance(long accountId, double newBalance) {
		double balance = jdbcTemplate.update("update bankaccount set account_balance=? where account_id=?",
				new Object[] { newBalance, accountId });
		return balance;
	}

}

package com.capgemini.bankapplication.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//	private DataSource dataSource;

//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}

	@Override
	public double getBalance(long accountId) {
		double balance = jdbcTemplate.queryForObject("SELECT  balance FROM bankAccount WHERE accountId = ?",
				new Object[] { accountId }, Double.class);
		return balance;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		int count = jdbcTemplate.update("UPDATE bankAccount SET balance = ? WHERE accountId = ?",
				new Object[] { newBalance, accountId });
		return count != 0;
	}

}
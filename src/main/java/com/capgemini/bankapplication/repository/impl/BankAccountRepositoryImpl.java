package com.capgemini.bankapplication.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public double getBalance(long accountId) throws DataAccessException{
		try {double balance = jdbcTemplate.queryForObject("SELECT  balance FROM bankAccount WHERE accountId = ?",
				new Object[] { accountId }, Double.class);
		return balance;
	} catch (DataAccessException e) {
		e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
		throw e;}
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) throws DataAccessException {
		try{int count = jdbcTemplate.update("UPDATE bankAccount SET balance = ? WHERE accountId = ?",
				new Object[] { newBalance, accountId });
		return count != 0;
	} catch (DataAccessException e) {
		e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
		throw e;

}
	}
}
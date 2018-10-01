package com.capgemini.bankapplication.customer.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.customer.repository.CustomerRepository;
import com.capgemini.bankapplication.entities.BankAccount;
import com.capgemini.bankapplication.entities.Customer;



@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer authenticate(Customer customer) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM customer, bankAccount where customer.accountId = bankAccount.accountId and customerEmail = ? AND customerPassword = ?",
				new Object[] { customer.getCustomerEmail(), customer.getCustomerPassword() }, new CustomerRowMapper());
	}

	@Override
	public Customer updateProfile(Customer customer) {
		int count = jdbcTemplate.update(
				"update customer set customerName= ? ,customerPassword= ? ,customerEmail= ? ,customerAddress= ? , customerDateOfBirth= ? where customerId= ? ",
				new Object[] { customer.getCustomerName(), customer.getCustomerPassword(), customer.getCustomerEmail(),
						customer.getCustomerAddress(), customer.getCustomerDateOfBirth(), customer.getCustomerId() });
		return count != 0 ? customer : null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		int count = jdbcTemplate.update(
				" update customer set customerPassword= ? WHERE customerId = ? AND customerPassword = ?",
				new Object[] { newPassword, customer.getCustomerId(), oldPassword });
		return count != 0;
	}

	private class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

			BankAccount account = new BankAccount();
			account.setAccountId(rs.getInt(8));
			account.setAccountType(rs.getString(10));
			account.setAccountBalance(rs.getDouble(9));

			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setCustomerPassword(rs.getString(3));
			customer.setCustomerEmail(rs.getString(4));
			customer.setCustomerAddress(rs.getString(5));
			customer.setCustomerDateOfBirth(rs.getDate(6).toLocalDate());
			customer.setCustomerAccount(account);

			return customer;
		}

	}
}
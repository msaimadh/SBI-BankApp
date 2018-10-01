package com.capgemini.bankapplication.customer.service;

import com.capgemini.bankapplication.entities.Customer;

public interface Customerservice {
	public Customer authenticate(Customer customer);
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);


}

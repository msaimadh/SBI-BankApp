package com.capgemini.bankapplication.customer.service;

import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.exception.PasswordChangeFailedException;

import com.capgemini.bankapplication.exception.UpdationFailedException;
import com.capgemini.bankapplication.exception.UserNotFoundException;

public interface CustomerService {

	public Customer authenticate(Customer customer) throws UserNotFoundException;
	public Customer updateProfile(Customer customer) throws  UpdationFailedException;
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) throws PasswordChangeFailedException ;

}




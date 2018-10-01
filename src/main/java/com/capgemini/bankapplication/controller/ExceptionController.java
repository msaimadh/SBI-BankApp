package com.capgemini.bankapplication.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.bankapplication.exception.LowBalanceException;
import com.capgemini.bankapplication.exception.PasswordChangeFailedException;
import com.capgemini.bankapplication.exception.UpdationFailedException;
import com.capgemini.bankapplication.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {
@ExceptionHandler(value=UserNotFoundException.class)
public String handleException(UserNotFoundException ex,HttpServletRequest request) {
	request.setAttribute("success",ex);
	return "success";
}

@ExceptionHandler(value = LowBalanceException.class)
public String handlheErrorf(HttpServletRequest request, LowBalanceException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}

@ExceptionHandler(value = PasswordChangeFailedException.class)
public String handlheErrorf(HttpServletRequest request, PasswordChangeFailedException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}

@ExceptionHandler(value = UpdationFailedException.class)
public String handlheErrorf(HttpServletRequest request, UpdationFailedException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}
@ExceptionHandler(value = SQLException.class)
public String handlheErrorf(HttpServletRequest request, SQLException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}
}


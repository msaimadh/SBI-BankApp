<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="cyan">
<%@include file="header.jsp" %>
<form action="login" method="post">
<label>CustomerId</label>
<input type="number" name="customerId" />
<br><br>
<label>Password</label>
<input type="password" name="password" />
<br><br>
<input type="submit" value="submit"/>
</form>
</body>
</html>
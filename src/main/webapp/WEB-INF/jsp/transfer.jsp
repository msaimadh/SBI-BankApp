<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Page</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="transfer" method="post">
<label>From Account :</label>
<input type="number" value="${sessionScope.customer.account.accountId}" readonly name="fromAccount"/>
<br><br>
<label>To Account :</label>
<input type="number" name="toAccount"/>
<br><br>
<label>amount :</label>
<input type="number" name="amount"/>
<br><br>
<input type="submit" value="transfer"/>
</form>
</body>
</html>
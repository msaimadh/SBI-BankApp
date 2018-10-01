<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%@include file="header.jsp"%>
	<%-- <c:if test="${sessionScope.customer.customerId != null}"> --%>
		<h3>${sessionScope.customer.customerId}</h3>
		<h3>${sessionScope.customer.customerName}</h3>
		<h3>${sessionScope.customer.email}</h3>
		<h3>${sessionScope.customer.account.balance}</h3>
		<h3>${sessionScope.customer.address}</h3>
	
	<c:if test="${sessionScope.customer.customerId == null}">

</c:if>

</body>
</html>
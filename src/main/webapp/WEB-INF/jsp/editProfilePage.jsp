<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="home.jsp"%>
</head>
<body style="text-align: left">
	<br>
	<h1>Edit Details</h1>
	<form:form action="editProfile.do" method="post" modelAttribute="customer">
		<br>
		<br>
		<form:label path="customerId"> Customer Id: </form:label>
		<form:input type="number" path="customerId" readonly="readonly"/>
		<br>
		<br>
		<form:label path="customerName"> Customer Name: </form:label>
		<form:input type="text" path="customerName" required="required"/>
		<br>
		<br>
		<form:label path="customerPassword">  Customer Password: </form:label>
		<form:input type="password" path="customerPassword" readonly="readonly"/>
		<br>
		<br>
		<form:label path="customerEmail"> Customer Email: </form:label>
		<form:input type="email" path="customerEmail" required="required"/>
		<br>
		<br>
		<form:label path="customerAddress"> Customer Address: </form:label>
		<form:input type="text" path="customerAddress" required="required"/>
		<br>
		<br>
		<form:label path="customerDateOfBirth"> Customer DOB: </form:label>
		<form:input type="date"  path="customerDateOfBirth" required="required"/>
		<br>
		<br>
		<br>
		<input type="submit" value="Edit" />
	</form:form>
</body>
</html>
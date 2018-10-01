<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%-- <%@ include file="home.jsp" %> --%>
</head>
<body>
<br>
	<h1>Login</h1>
	<form:form action="login.do" method="post" modelAttribute="customer">
		<br><br>
		<form:label path="customerEmail">Email Id: </form:label>
		<form:input path="customerEmail" type="text" placeholder="enter your emailId" required="required"/>
		<br> <br> 
		<form:label path="customerPassword">Password: </form:label>
		<form:input path="customerPassword" type="password" placeholder="enter your password" required="required"/>
		<br> <br>
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>
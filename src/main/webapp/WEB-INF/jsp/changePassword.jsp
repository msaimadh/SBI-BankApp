<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="changePassword" method="post">
<label>Old Password</label>
<input type="password" name="oldPassword" />
<br><br>
<label>New Password</label>
<input type="password" name="newPassword" />
<br><br>
<label>Confirm Password</label>
<input type="password" name="confirmPassword" />
<br><br>

<input type="submit" value="submit" />
<br><br>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<link href="css/header.css" rel="stylesheet">
</head bgcolor="pink">
<body>
<div class="container">
  <img src="/images/sbi.jpg" align="left"  width="200" height="100">
  <div class="topright"></div>
</div>
<br>
<h1 align="center"><h1>Welcome to SBI BANK</h1>
<br>
<header>


<c:if test="${not empty sessionScope.customer}">
<section id="ABC">
  <h3><a href="home">Home</a></h3>
  <h3><a href="editProfile">Edit Profile</a></h3>
  <h3><a href="transferAmount">Transfer Money</a></h3>
  <h3><a href="checkBalance.do">Balance Enquiry</a></h3>
  <h3><a href="changePassword">Change Password</a></h3>
  
  
</section>

  <div class="topright"> 
  
   <H2 align="right"> <a href="logout">   logout   </a></H2>
</div>  
</c:if>

<c:if test="${empty sessionScope.customer}">
<section id="ABC">
  <h3><a href="home">Home</a></h3>
  <h3><a href="login">Edit Profile</a></h3>
  <h3><a href="login">Transfer Money</a></h3>
  <h3><a href="login">Balance Enquiry</a></h3>
  <h3><a href="login">Change Password</a></h3>
</section>

  <div class="topright"> 
   <H2 align="right"> <a href="login"> login </a></H2>
</div>  
</c:if>
</header>
</body>
</html>
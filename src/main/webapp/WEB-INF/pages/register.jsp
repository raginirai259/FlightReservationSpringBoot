<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="panel-body">

<form:form action="registerUser" method="post" modelAttribute="command">
  UserId: <form:input type="text" placeholder="Enter userId" path="userId" /><br>
  <form:errors path="userId"/><br>
  Password: <form:input type="password" placeholder="Enter password" path="password" /><br>
  <form:errors path="password"/><br>
  Name: <form:input type="text" placeholder="Enter  Name" path="name" /><br>
  <form:errors path="name"/><br>
  City: <form:input type="text" placeholder="Enter City" path="city" /><br>
  <form:errors path="city"/><br>
  Email: <form:input type="text" placeholder="Enter email" path="email" />  <br>
  <form:errors path="email"/><br>
  Phone Number: <form:input type="text" placeholder="Enter phonenumber" path="phone" /><br>
  <form:errors path="phone"/><br>
  
  <input type="submit" value="Register"/>
  <div>${message}</div><br>
  <c:if test="${successMessage ne null}">
  <div>${successMessage}</div></c:if>
  
  Click <a href="/Homepage" > &nbsp; Here</a> to login
  
</form:form>

</div>
</body>
</html>
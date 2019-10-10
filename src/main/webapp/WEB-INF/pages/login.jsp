<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="authenticateLogin" modelAttribute="command">
<form:input type="text" path="userName" placeholder="UserId"/>
<br>
<form:errors path="userName" />
<form:input  type="password" path="password" placeholder="Password"/>
<br>
<form:errors path="password" />
<button class="login100-form-btn" type="submit">Log in</button>
<div class="text-center">
						<span class="txt1">
							Create an account?
						</span>

						<a href="register" class="txt2 hov1">
							Sign up
						</a>
					</div>
					<div>${message}</div>
					</form:form>
					
					
					
</body>
</html>
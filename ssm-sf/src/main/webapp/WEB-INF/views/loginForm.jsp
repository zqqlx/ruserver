<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>
<h3><a href="loginForm?request_locale=zh_CN">中文</a>|<a href="loginForm?request_locale=en_US">英文</a></h3>
	<form:form modelAttribute="user" action="login" method="post">
		<table>
			<tr>
				<td><lable><spring:message code="loginname"/></lable></td>
				<td><form:input path="loginname"/></td>
			</tr>
			<tr>
				<td><lable><spring:message code="password"/></lable></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" type="submit" value="登录"></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>
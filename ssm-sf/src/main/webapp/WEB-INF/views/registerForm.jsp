<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="register" mehtod="post">
		<table>
			<tr>
				<td>登录名</td>
				<td><input type="text" id="loginname" name="loginname"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" id ="password" name="password"></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
				<td><input id = "submit" type="submit"  value="注册"></td>
			</tr>
		</table>
		</form>
	</div>
</body>

</html>
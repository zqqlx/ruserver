<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<script src="${APP_PATH}/static/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
 
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show Employee</title>
<script type="text/javascript">

	
</script>
</head>
<body>
	<div class=".container">
	<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-8">
				<button type="button" class="btn btn-primary">（首选项）Primary</button>
				<button type="button" class="btn btn-danger">（危险）Danger</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table>
					<tr>
						<td>#</td>
						<td>empname</td>
						<td>gender</td>
						<td>deptname</td>
						<td>deptid</td>
					</tr>
					<tr></tr>
				</table>
			</div>
		</div>
		<div class="row"></div>
		
	</div>
</body>
</html>
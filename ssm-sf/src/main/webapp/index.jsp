<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:forward page="/emps"></jsp:forward>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"request.getServerPort()+contextPath+"/";
%>
<title>用户信息显示</title>
   <!-- 引入JQuery -->
   <script type="text/javascript" src="./static/jquery-easyui-1.5.4.5/jquery.min.js"></script>
   <!-- 引入EasyUI -->
   <script type="text/javascript" src="./static/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
   <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
   <script type="text/javascript" src="./static/jquery-easyui-1.5.4.5/locale/easyui-lang-zh_CN.js"></script>
   <!-- 引入EasyUI的样式文件-->
   <link rel="stylesheet" href="./static/jquery-easyui-1.5.4.5/themes/default/easyui.css" type="text/css"/>
   <!-- 引入EasyUI的图标样式文件-->
   <link rel="stylesheet" href="./static/jquery-easyui-1.5.4.5/themes/icon.css" type="text/css"/>
</head>
<body> 
    
</body>
</html>
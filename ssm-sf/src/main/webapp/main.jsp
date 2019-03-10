<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
	<a class="btn btn-default" href="#" role="button">Link</a>
<button class="btn btn-default" type="submit">Button</button>
<input class="btn btn-default" type="button" value="Input">
<input class="btn btn-success" type="submit" value="Submit">
<script type="text/javascript">
	$(function(){
// 		$("#box").draggable({
// 			//revert:true,
// // 			handle: "#pox",
// 			edge: 10,
// 			proxy: 'clone',
// 			onBeforeDra g :function(e){
// 				alert("acb");
// 			}
// 		});
// 		alert($("#box").draggable('options'));

	$('#box').droppable({
		accept: '#subbox',
		
		onDragEnter: function(e, source){
			$(this).css('background','red');
		},
		onDragLeave:function(e, source){
			$(this).css('background','blue');
		}
		
	});
	
	$("#subbox").draggable({});
	
	$.fn.progressbar.defaults.value=30;
	$('#probar').progressbar({
		width:400,
		height:30,
		value: 0,
		//text: '{value}%',
		onChange: function(newValue, oldValue){
			
		}
	});
// 	setTimeout(function(){
// 		$('#probar').progressbar('setValue', 70)
// 	},1000);
	setInterval(function(){
		$('#probar').progressbar('setValue',$('#probar').progressbar('getValue')+5);
	},200);
	
	$('#panel').panel({
		title:'面板',
		closeable:true,
		width:500,
		height:150,
		iconCls: 'icon-search',
		left:200,
		top:200
	});
	$('#panel').panel('panel').css('position','absolute');
	});
	
	
</script>
<div id = "box"  style="width:100px;height:100px;border:1px solid">
	
</div>

<div id="subbox" style="width:30px;height:30px;border: 1px solid">sub</div>

<div id="rr" class="easyui-resizable" style="width:300px;height:300px;border: 1px solid"></div>
<!-- 进度条 -->
<div id="probar" class="easyui-progressbar" ></div>
<!-- 面板组件 -->
<div id="panel">
	<p>内容区域</p>
</div>
</body>
</html>
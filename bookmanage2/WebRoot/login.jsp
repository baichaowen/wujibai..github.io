<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	 
$(function(){
	
	$("#code").attr("src","random.action");
	$("#code").click(function(){
		//获取当前的时间作为参数，无具体意义 
		var timenow = new Date().getTime();
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
		$(this).attr("src","random.action?d=" + timenow);
		
		
	});
	
	$("input[type='submit']").click(function(){
		
  	var name=$("#name").val();
  	var pwd=$("#password").val();
  	var random=$("#random").val();
 	
  	
  	var msg="";
  	$("#message").css("color","red");
  	if(name==null||name==""){
  	msg="用户名不能为空";
  	$("#message").html(msg);
  	return false;
  	}
  	if(pwd==null||pwd==""){
  	msg="密码不能为空";
  	$("#message").html(msg);
  	return false;
  	}
  	if(random==null||random==""){
  	msg="验证码不能为空";
  	 $("#message").html(msg);
  	return false;
  	}
	});

});
  
  </script>
<style type="text/css">
div {
	height: 500px;
	width: 500px;
	margin: 0 auto;
}

.yh {
	background-color: #f785f0;
}

th {
	font-size: 20px;
}
</style>


</head>
 
<body>
	<div>
		<form action="loginUseraction" method="post">

			<table border="1">
				<thead>
					<tr>
						<th colspan="2">登录图书管理系统</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="yh">用户名:</td>
						<td><input type="text" id="name" name="bookuser.name" /></td>
					</tr>
					<tr>
						<td class="yh">密码:</td>
						<td><input type="password" id="password"
							name="bookuser.password">
						</td>
					</tr>
					<tr>
						<td>
							<label>验证码：</label>
							<input type="text" id="random" name="acond" size="6" />
							
						</td>
						<td><img id="code"></td>
 					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="登录">&nbsp;<input type="reset" value="重置">
						</td>
							
					</tr>
					<tr>
						<td colspan="2" height="30px"><span id="message"></span>
						</td>
					</tr>
				</tbody>
				
			</table>
			
		</form>
	</div>
</body>
</html>

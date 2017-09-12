<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="addbookaction" method="post">
    	<table>
    		<thead>
    			<tr>
    				<td colspan="2"></td>
    			</tr>
    		
    		</thead>
    		<tbody>
    			<tr>
    				<td>书名<font color="#FF0000">(*)</font></td>
    				<td><input type="text" name="book.name"/></td>
    			</tr>
    			<tr>
    				<td>作者<font color="#FF0000">(*)</font></td>
    				<td><input type="text" name="book.author"/></td>
    			</tr>
    			<tr>
    				<td>出版社<font color="#FF0000">(*)</font></td>
    				<td><input type="text" name="book.publish"/></td>
    			</tr>
    			<tr>
    				<td>出版日期<font color="#FF0000">(*)</font></td>
    				<td><input type="text" name="book.publishdate"/>(yyyy-MM-dd)</td>
    			</tr>
    			<tr>
    				<td>页数</td>
    				<td><input type="text" name="book.page"/></td>
    			</tr>
    			<tr>
    				<td>价格</td>
    				<td><input type="text" name="book.price"/></td>
    			</tr>
    			<tr>
    				<td>内容摘要</td>
    				<td><input type="text" name="book.content"/></td>
    			</tr>
    			
    			<tr>
    				<td colspan="2" align="center"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="返回"/></td>
    				
    			</tr>
    		
    		</tbody>
    	
    	
    	</table>
    
    
    </form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <style type="text/css">
  #booklist{
  	height:300px;
  	width:800px;
  	margin: 0 auto;
  
  }
 
  th{
  background-color: #fcfdd8;
  font-size: 34px;
  
  }
  span{
  font-size: 30px;
  }
  
  </style>
  <script type="text/javascript">

  $(function(){
  var pageTr="共"+${pageSupport.totalCount}+"条记录";
  	pageTr+="&nbsp;每页</span><select name='pageSize' onChange='changes(this)'>";
  	var pageSize=${pageSupport.pageSize};
  	if(pageSize==2){
  		pageTr+="<option value='2'selected>2</option>";
  	}else{
  	pageTr+="<option value='2'>2</option>";  	
  	}
  	if(pageSize==4){
  		pageTr+="<option value='4'selected>4</option>";
  	}else{
  	pageTr+="<option value='4'>4</option>";  	
  	}
  	if(pageSize==6){
  		pageTr+="<option value='6'selected>6</option>";
  	}else{
  	pageTr+="<option value='6'>6</option>";  	
  	}
  	pageTr+="</select>条&nbsp;";
  	pageTr+="第"+${pageSupport.currPageNo}+"页/共"+${pageSupport.totalPageCount}+"页&nbsp;";
  	var totalPageCount=${pageSupport.totalPageCount};
  	pageTr+="&nbsp;<a id='first' href='javascript:void(0)'>首页</a>&nbsp;";
  	var a=${pageSupport.currPageNo};
  	if(a>1){
  	pageTr+="&nbsp;<a id='two' href='javascript:void(0)'>上一页</a>&nbsp;";
  	}
  	if(a<totalPageCount){
  	pageTr+="&nbsp;<a id='sr' href='javascript:void(0)'>下一页</a>&nbsp;";
  	}
  	pageTr+="&nbsp;<a id='fo' href='javascript:void(0)'>尾页</a>&nbsp;";
  
  	if(a>1){
  		pageTr+="转到第<input type='text' id='tiao' style='width:30px' value=${pageSupport.currPageNo}>页<input type='button' id='go' value='go'>页";
  	}else{
  	pageTr+="转到第<input type='text' id='tiao' style='width:30px' value='1'>页<input type='button' id='go' value='go'>页";
  	}
  	$("#add").nextAll().remove();
  	$("#add").after(pageTr);
  	
  	
  	
  	/* 增加 */
  	$("#add").click(function(){
  	window.location.href="add.jsp";
  	
  	});
  	/* 首页 */
  	$("#first").click(function(){
  		$.ajax({
  		type:"get",
  		url:"listbookaction?currPageNo="+1,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  		});
  	
  	});
  	/*上一页  */
  	$("#two").click(function(){
  	var pp=${pageSupport.currPageNo-1};
  		$.ajax({
  		type:"get",
  		url:"listbookaction?currPageNo="+pp,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  		});
  	
  	});
  	/* 下一页 */
  	$("#sr").click(function(){
  	var p=${pageSupport.currPageNo+1};
  		$.ajax({
  		type:"get",
  		url:"listbookaction?currPageNo="+p,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  		});
  	
  	});
  	/* 尾页 */
  	$("#fo").click(function(){
  	var fo=${pageSupport.totalPageCount};
  		$.ajax({
  		type:"get",
  		url:"listbookaction?currPageNo="+fo,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  		});
  	
  	});
  	/* 跳转页面 */
  	$("#go").click(function(){
  	var tiao=$("#tiao").val();
  	var page=${pageSupport.totalPageCount};
  	
  	if(tiao==0||tiao==""){
  	alert("请输入要跳转的页数");
  	return false;
  	}else if(tiao>page){
  	alert("请输入正确的页数");
  	return false;
  	}else{
  	$.ajax({
  		type:"get",
  		url:"listbookaction?currPageNo="+tiao,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  	
  	});
  	};
  	
  	});
  
  
  });
  /* 选择第几页 */
  function changes(sel){
  	
  	var pcount=$(sel).val();
  		$.ajax({
  		type:"get",
  		url:"listbookaction?pageSize="+pcount,
  		success:function(list){
  		$("#booklist").html(list)
  		}
  		});
  	};
  </script>
  </head>
  
  <body>
    <div id="booklist">
    	${sessionScope.name},<c:if test="${sessionScope.usertype==1}">图书系统管理员</c:if>
    		<c:if test="${sessionScope.usertype==0}">普通用户,</c:if>欢迎您
    	<table border="1" width="700px" >
    		<thead>
    			<tr>
    			<th colspan="8">图书详细信息列表</th>
    			</tr>  			
    		</thead>
	    			    		
    		<tbody >
    		
    			<tr>
	    			<td>书名</td>
	    			<td>作者</td>
	    			<td>出版社</td>
	    			<td>出版日期</td>
	    			<td>页数</td>
	    			<td>价格</td>
	    			<td>内容摘要</td>
	    			<td>操作</td>
	    		</tr>
    			<c:forEach items="${list}" var="book" varStatus="id">
    			<tr <c:if test="${id.index%2==0}">style="background-color:#f6acfd"</c:if>>
    				<td>${book.name}</td>
	    			<td>${book.author}</td>
	    			<td>${book.publish}</td>
	    			<td>${book.publishdate}</td>
	    			<td>${book.page}</td>
	    			<td>${book.price}</td>
	    			<td>${book.content}</td>
	    			<td><a href="preupdatebookaction?book.id=${book.id}">修改</a>&nbsp;<a href="deletebookaction?book.id=${book.id}">删除</a></td> 			
    			</tr>
    			
    			</c:forEach>
    		</tbody>
    		<tfoot>
    			<tr><td colspan="8">
    			<input type="button" id="add" value="新增图书">    			
    			</td>
    			
    			</tr>
    		
    		</tfoot>
    		
    	</table>
    	
    
    </div>
   
  </body>
</html>

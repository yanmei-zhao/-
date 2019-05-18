<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" type="text/css"/>
	<script language="JavaScript" src="js/login.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="login()">
    <%String error=(String)request.getSession().getAttribute("error");  %>
    <input type="hidden" name="error" id="error" value="<%=error%>">
    
    <script type="text/javascript">
      function login(){
	var error=document.getElementById("error").value;
	 layer.open({
		  title: '网页提示'
		  ,content: '用户名错误'
		 }); 	
	window.location.href="/WEB-INF/page/main.jsp";
}
    </script>
  </body>
</html>

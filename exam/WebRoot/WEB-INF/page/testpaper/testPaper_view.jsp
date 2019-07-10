<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
     <tr >
		<td colspan="2" id="xz">一、选择题</td>
    </tr>
   	<h2 style="text-align:center" >${sessionScope.testpapername} </h2>
 	<!-- 遍历 json-->
  	<c:forEach items="${sessionScope.view}" var="view" begin="0"  varStatus="status" step="1">
  		<p style="text-align:center">${view} </p>
  	</c:forEach>
  </body>
</html>

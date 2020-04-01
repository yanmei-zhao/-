<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ page language="java" import="com.gxuwz.Market.business.entity.*"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%= basePath%>" />
<title>教师功能导航菜单</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    	<a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame"><img src="images/logo1.png" title="系统首页" /></a>  
	</div>

	<ul class="nav">
		<li><a href="<%= basePath%>/front/TopicBank_list.action"
			target="rightFrame"><img src="images/icon01.png" title="题库管理" />
			<h2>题库管理</h2></a></li>
		<li><a href="<%= basePath%>/front/Exam_list.action"
			target="rightFrame"><img src="images/icon02.png" title="考试管理" />
			<h2>考试管理</h2></a></li>
		<li><a href="<%= basePath%>/front/Topic_openBatchAdd.action"
			target="rightFrame"><img src="images/icon05.png" title="导入试题" />
			<h2>导入试题</h2></a></li>
		<li><a href="<%=basePath%>/front/Login_openIndex.action"
			target="rightFrame"><img src="images/icon03.png" title="统计分析" />
			<h2>统计分析</h2></a></li>
	</ul>

	<div class="topright">
		<ul>
			<li><span><img src="images/help.png" title="帮助"
					class="helpimg" /></span><a
				href="<%=basePath%>/front/Login_openHelp.action"
				target="rightFrame">帮助</a></li>
			<li><a href="<%=basePath%>/front/Login_openIndex.action"
				target="rightFrame">关于</a></li>
			<li><a href="<%=basePath%>/front/Login_openIndex.action"
				target="rightFrame">回到首页</a></li>
			<li><a href="<%=basePath%>/front/Login_logout.action"
				target="_parent">退出</a></li>
		</ul>
		<%String userName=(String)request.getSession().getAttribute("userName"); %>
		<div class="user">
			<span>${userName}</span> <!-- <i>消息</i> <b>0</b> -->
		</div>

	</div>

</body>
</html>

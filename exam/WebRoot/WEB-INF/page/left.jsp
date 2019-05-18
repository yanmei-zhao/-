<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <base href="<%= basePath%>"/>
		<title>系统功能菜单</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	});
</script>

	</head>

	<body style="background: #f0f9fd;">
		<div class="lefttop">
			<span></span>功能菜单
		</div>

		<dl class="leftmenu">
	
		<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>课程管理
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Course_openAdd.action" target="rightFrame">新增课程</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Course_list.action" target="rightFrame">课程列表</a><i></i>
					</li>
				</ul>
			</dd>
			
		<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>试卷审核管理
				</div>
				<ul class="menuson">
				
					<li>
						<cite></cite><a href="<%= basePath%>/front/Admin_list.action" target="rightFrame">待审核试卷列表</a><i></i>
					<li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Admin_list3.action" target="rightFrame">审核通过列表</a><i></i>
					<li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Admin_list4.action" target="rightFrame">审核未通过列表</a><i></i>
					<li>
				</ul>
			</dd>
		
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>用户管理
				</div>
				<ul class="menuson">
				    <li>
						<cite></cite><a href="<%= basePath%>/front/Group_list.action" target="rightFrame">管理班级</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Teacher_list.action" target="rightFrame">管理教师</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Student_list.action" target="rightFrame">管理学生</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>权限管理
				</div>
				<ul class="menuson">
				    <li>
						<cite></cite><a href="<%= basePath%>/front/SysRight_openAdd.action" target="rightFrame">新增权限</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/SysRight_list.action" target="rightFrame">权限列表</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>试题管理
				</div>
				<ul class="menuson">
				    <li>
						<cite></cite><a href="<%= basePath%>/front/TopicBank_gettopicBankNameAll.action" target="rightFrame">新增试题</a><i></i>
				    </li>
				    <li>
						<cite></cite><a href="<%= basePath%>/front/Topic_list.action" target="rightFrame">试题列表</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>题库管理
				</div>
				<ul class="menuson">
				    <li>
						<cite></cite><a href="<%= basePath%>/front/TopicBank_openAdd.action" target="rightFrame">新增题库</a><i></i>
					</li>
				    <li>
						<cite></cite><a href="<%= basePath%>/front/TopicBank_list.action" target="rightFrame">题库列表</a><i></i>
					</li>
				</ul>
			</dd>
			
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>考试管理
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_getTestpaperNameAll.action" target="rightFrame">新增考试</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Exam_list.action" target="rightFrame">考试列表</a><i></i>
				   </li>
				   
				</ul>
			</dd>
				<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>试卷管理
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_openAdd.action" target="rightFrame">新增试卷</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Course_getcourseNameAll.action" target="rightFrame">快速创建试卷</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_list.action" target="rightFrame">试卷列表</a><i></i>
				   </li>
				   
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>统计分析
				</div>
				<ul class="menuson">
				   <li>
				       <cite></cite><a href="<%= basePath%>/front/Statistics_openAnalyze.action" target="rightFrame">考试分析</a><i></i>
				   </li>
				</ul>
			</dd>
		</dl>

	</body>
</html>

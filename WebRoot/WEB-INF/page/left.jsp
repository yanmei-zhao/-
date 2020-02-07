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
	<script> 
	$(function() {
		<%int userType = (int)request.getSession().getAttribute("userType"); %>
		 var userType='<%=userType%>';
		 	if ((userType=="2")) {//老师
		 	  document.getElementById("exam").style.display = 'none';
			  document.getElementById("user").style.display = 'none';
		      document.getElementById("right").style.display = 'none';
		      document.getElementById("testPaperView").style.display = 'none';
		      document.getElementById("score").style.display = 'none';
		       document.getElementById("practice").style.display = 'none';
		   }else if(userType=="1"){//学生
	    	 document.getElementById("course").style.display = 'none';
		     document.getElementById("testPaperView").style.display = 'none';
		     document.getElementById("user").style.display = 'none';
		     document.getElementById("right").style.display = 'none';
		     document.getElementById("topic").style.display = 'none';
		     document.getElementById("test").style.display = 'none';
		     document.getElementById("topicBank").style.display = 'none';
		     document.getElementById("testPaper").style.display = 'none';
		     document.getElementById("statics").style.display = 'none';
		      document.getElementById("correct").style.display = 'none';
		   } else if(userType=="3"){//管理员
		   	 document.getElementById("exam").style.display = 'none';
		   	 document.getElementById("score").style.display = 'none';
		   	 document.getElementById("correct").style.display = 'none';
		   	 document.getElementById("practice").style.display = 'none';
		   }
		});
	</script>
	</head>

	<body style="background: #f0f9fd;">
		<div class="lefttop">
			<span></span>功能菜单
		</div>

		<dl class="leftmenu">
		
			<dd id ="practice">
				<div class="title" >
					<span><img src="images/leftico05.png" /> </span>我的练习
				</div>
				<ul class="menuson">
				   <li>
			   			<cite></cite><a href="<%= basePath%>/front/ChoiceTopic_practiseList.action" target="rightFrame">试题列表</a><i></i>
				   </li>
				</ul>
			</dd>
			
			<dd id ="exam">
				<div class="title" >
					<span><img src="images/leftico05.png" /> </span>我的考试
				</div>
				<ul class="menuson">
				   <li>
			   			<cite></cite><a href="<%= basePath%>/front/Exam_list.action" target="rightFrame">考试列表</a><i></i>
				   </li>
				</ul>
			</dd>
			
			<dd id ="score">
				<div class="title" >
					<span><img src="images/leftico05.png" /> </span>我的成绩
				</div>
				<ul class="menuson">
				   <li>
			   			<cite></cite><a href="<%= basePath%>/front/StudentExamScore_list.action" target="rightFrame">成绩列表</a><i></i>
				   </li>
				</ul>
			</dd>
		
			<dd id ="course">
				<div class="title" >
					<span><img src="images/leftico06.png" /> </span>课程管理
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
			
			<dd id ="topicBank">
				<div class="title">
					<span><img src="images/leftico11.png" /> </span>题库管理
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
			
		
			<dd id ="testPaperView">
				<div class="title">
					<span><img src="images/leftico09.png" /> </span>试卷审核管理
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
		
	
			<dd id ="topic">
				<div class="title">
					<span><img src="images/leftico07.png" /> </span>试题管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="<%= basePath%>/front/Topic_openBatchAdd.action" target="rightFrame">批量导入试题</a><i></i>
					</li>
				    <li>
						<cite></cite><a href="<%= basePath%>/front/ChoiceTopic_list.action" target="rightFrame">单选题列表</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/FillTopic_list.action" target="rightFrame">填空题列表</a><i></i>
					</li>
				    <li>
						<cite></cite><a href="<%= basePath%>/front/Topic_list.action" target="rightFrame">简答题列表</a><i></i>
					</li>
					
				</ul>
			</dd>
			
			
			<dd id ="testPaper">
				<div class="title">
					<span><img src="images/leftico08.png" /> </span>试卷管理
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_openAdd.action" target="rightFrame">新增试卷信息</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_getcourseNameAll.action" target="rightFrame">快速创建试卷</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_list.action" target="rightFrame">试卷列表</a><i></i>
				   </li>
				   
				</ul>
			</dd>
			
			<dd id ="test">
				<div class="title">
					<span><img src="images/leftico05.png" /> </span>考试管理
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Testpaper_getTestpaperNameAll.action" target="rightFrame">发布考试</a><i></i>
				   </li>
				   <li>
						<cite></cite><a href="<%= basePath%>/front/Exam_list.action" target="rightFrame">考试列表</a><i></i>
				   </li>
				   
				</ul>
			</dd>
			
			<dd id ="correct">
				<div class="title">
					<span><img src="images/leftico05.png" /> </span>待批改试卷
				</div>
				<ul class="menuson">
				   <li>
						<cite></cite><a href="<%= basePath%>/front/StudentExamScore_listCorrectAll.action" target="rightFrame">待批改试卷列表</a><i></i>
				   </li>
				</ul>
			</dd>
			
			<dd id ="statics">
				<div class="title">
					<span><img src="images/leftico12.png" /> </span>统计分析
				</div>
				<ul class="menuson">
				   <li>
				       <cite></cite><a href="<%= basePath%>/front/StudentExamScore_listAll.action" target="rightFrame">成绩统计</a><i></i>
				   </li>
				   <li>
				       <cite></cite><a href="<%= basePath%>/front/Statistics_openAnalyze.action" target="rightFrame">考试分析</a><i></i>
				   </li>
				</ul>
			</dd>
			
				<dd id ="user">
				<div class="title">
					<span><img src="images/leftico13.png" /> </span>用户管理
				</div>
				<ul class="menuson">
				    <li>
						<cite></cite><a href="<%= basePath%>/front/Group_list.action" target="rightFrame">班级列表</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Teacher_list.action" target="rightFrame">教师列表</a><i></i>
					</li>
					<li>
						<cite></cite><a href="<%= basePath%>/front/Student_list.action" target="rightFrame">学生列表</a><i></i>
					</li>
				</ul>
			</dd>
			
			<dd id ="right">
				<div class="title">
					<span><img src="images/leftico10.png" /> </span>权限管理
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
		</dl>

	</body>
</html>

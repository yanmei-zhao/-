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
					<span><img src="images/leftico04.png" /> </span>我的考试
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="<%= basePath%>/front/Student_list.action" target="rightFrame">开始考试</a><i></i>
					</li>
				</ul>
			</dd>
		</dl>

	</body>
</html>


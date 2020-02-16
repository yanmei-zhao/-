<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>待审核试卷列表</title>
	<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/js/all.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		/*
		 *_contextPath:上下文路径
		 *_modulePath: 模块路径
		 */
		var  _contextPath="<%=path%>";
		var  _modulePath=_contextPath+"/sys/";
		$(document).ready(function(){
		  $(".clicks").click(function(){
		   _open(_modulePath+"textures_open.action?view=add");
		  });
		});
	</script>
	<!--  -->
	<style type="text/css">
		.tablelinkdelete {
			color: #056dae;
		}
		.find {
			height: 31px;
			margin-top: -5px;
			margin-left: -10px;
		}
		.find1 {
			height: 31px;
			margin-right: -14px;
			margin-top: -5px;
		}
	</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">试卷审核管理</a></li>
			<li><a href="#">待审核试卷列表</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div id="tab2" class="tabson">
				<form action="<%=basePath%>/front/Admin_list.action" method="post"
					target="rightFrame">
				</form>
				<table class="tablelist">
					<thead>
						<tr>
						 	<th width="8%"><input id="all" type="checkbox" value="" onclick="selectAll()"/>全选</th>
						    <th width="10%">考试id</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th width="8%">考试状态</th>
							<th width="8%">考试时长</th>
							<th >试卷名称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="pageResult.data">
						<tr>
							<td><input name="checkbox" id="checkbox" type="checkbox" value='<s:property value="examId"/>'/></td>
							<td>${examId}</td>
							<td>${examStart}</td>
							<td>${examEnd}</td>
							<td>${examState}</td>
							<td>${examDuration}</td>
							<td>${examName}</td>
					        <td>
					        	<a href="<%= basePath%>/front/Exam_openViewTestPaper.action?examId=${examId}"  class="tablelink">预览试卷</a>&nbsp;&nbsp;
				                <a href="<%=basePath%>/front/Admin_openExam.action?examId=${examId}" class="tablelink"> 查看</a>&nbsp;&nbsp;
					     		<a href="<%=basePath%>/front/Admin_update.action?examId=${examId}" class="tablelink"> 通过</a>&nbsp;&nbsp;
					        	<a href="<%=basePath%>/front/Admin_update1.action?examId=${examId}" class="tablelink"> 不通过</a>&nbsp;&nbsp;
					        </td>
    				  </tr> 
       				 </s:iterator>
				</tbody>
			</table>
		</div>
	</div>

		<!-- 分页菜单组件--------------------------开始 -->
		<%
			//查询的url地址，统一写
			String listActionURL =  basePath+"/front/Admin_list.action";
		%>

		<script type="text/javascript">
			//分页组件
			function change()
			  {
			   var url = "<%= basePath%>/front/Admin_list.action";  
			 	var textfield=document.getElementById("textfield").value;
			 	var totalPage=document.getElementById("totalPage").value;
			 	var pageNum = 0;
			 	if(textfield < totalPage ){
			 		pageNum = textfield; 
			 		window.location.href="<%=listActionURL%>?page="+pageNum;
			 	}else{
			 		pageNum = totalPage; 
			 		alert("当前只有"+totalPage+"页");
			 	}
			  	
			  }
		</script>
		<script type="text/javascript">
			var url = "<%=basePath%>
			/biz/Zy_list.action; //获取表单url
			//首页
			function first() {

				window.location.href = url + "?page=1";
			}
			//上一页
			function previous() {
				window.location.href = url
						+ "?page=${pageResult.previousPageNumber}";
			}
			//下一页
			function next() {
				window.location.href = url
						+ "?page=${pageResult.nextPageNumber}";
			}
			//尾页
			function last() {
				window.location.href = url + "?page=${pageResult.totalPage}";
			}
		</script>
		<div class="pagin">
			<div class="message">
				共<i class="blue">${pageResult.total}</i>条记录 <i class="blue">${pageResult.totalPage}</i>页，
				当前显示第&nbsp;<i class="blue">${pageResult.page}</i>页
			</div>
			<ul class="paginList">
				<c:choose>
					<c:when test="${pageResult.isFirst==true}">
						<li class="paginItem current"><a href="javascript:;">首页</a></li>
					</c:when>
					<c:otherwise>
						<li class="paginItem"><a href="javascript:first()"
							target="rightFrame">首页&nbsp;</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pageResult.isFirst==true}">
						<li class="paginItem current"><a href="javascript:;">上一页</a></li>
					</c:when>
					<c:otherwise>
						<li class="paginItem"><a href="javascript:previous()"
							target="rightFrame">上一页&nbsp;</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pageResult.hasNext==true}">
						<li class="paginItem"><a href="javascript:next()"
							target="rightFrame">下一页&nbsp;</a></li>
					</c:when>
					<c:otherwise>
						<li class="paginItem current"><a href="javascript:;">下一页</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pageResult.isLast==true}">
						<li class="paginItem current"><a href="javascript:;">尾页</a></li>
					</c:when>
					<c:otherwise>
						<li class="paginItem"><a href="javascript:last()"
							target="rightFrame">尾页&nbsp;</a></li>
					</c:otherwise>
				</c:choose>
				<li class="paginItem-page">跳转到：&nbsp; <input name="textfield"
					type="text" size="4" class="page-input" id="textfield"
					onchange="change()" />&nbsp;页
				</li>
			</ul>
		</div>
		<!-- 分页菜单组件--------------------------结束 -->
		<script type="text/javascript">
			$("#usual1 ul").idTabs();
		</script>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
	</div>

 </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考试审核管理</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">考试审核管理</a></li>
    <li><a href="#">待审核考试列表</a></li>
    </ul>
    </div>
    
    <div class="formtitle"><span>待审核考试列表</span></div>
    <form action="<%= basePath%>/front/Admin_openExam.action" method="post" id="commonform">
	    <ul class="forminfo">
	    <s:iterator value="#session.exam">
		    <li><label></label><input name="admin.examId" id="examId" type="hidden" class="dfinput" value="<s:property value="examId"/>" /></li>
		    <li><label>开始时间</label><input name="admin.examStart" id="examStart" type="text" class="dfinput" value="<s:property value="examStart"/>" /></li>
		    <li><label>结束时间</label><input name="admin.examEnd" id="examEnd" type="text" class="dfinput" value="<s:property value="examEnd"/>" /></li>
		    <li><label>考试时长</label><input name="admin.examDuration" id="examDuration" type="text"  class="dfinput" value="<s:property value="examDuration"/>" /></li>
		    <li><label>试卷名称</label><input name="admin.examName" id="examName" type="text" class="dfinput" value="<s:property value="examName"/>" /></li>
		    <li><label>参加人数</label><input name="admin.totalPeople" id="totalPeople" type="text" class="dfinput"  value="<s:property value="totalPeople"/>"/></li>
		 	<li>
		 		<a href="<%=basePath%>/front/Admin_update.action?examId=${examId}"> 通过</a>&nbsp;&nbsp;
		      	<a href="<%=basePath%>/front/Admin_update1.action?examId=${examId}"> 不通过</a>&nbsp;&nbsp;
		    </li>
	    </s:iterator>
	    </ul>																						
    </form>
    
    </div>


</body>

</html>

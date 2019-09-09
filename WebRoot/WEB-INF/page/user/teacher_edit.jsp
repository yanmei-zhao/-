<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改学生信息</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>

<script type="text/javascript">
</script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">教师基本信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>教师基本信息</span></div>
    <form action="<%= basePath%>/front/Teacher_update.action" method="post" id="commonform">
    <ul class="forminfo">
    <input name=teacher.teacherId id="teacherId" type="hidden" value="${teacher.teacherId}" />
    <li><label>教师编号</label><label style="width:50%">${teacher.teacherId}</label></li>
    <li><label>姓名</label><input name="teacher.teacherName" id="teacherName" type="text"  class="dfinput" value="${teacher.teacherName}" /></li>
    <input name="teacher.teacherPassword" id="teacherPassword" type="hidden"  class="dfinput" value="${teacher.teacherPassword }"/></li>
    <li><label>班级Id</label><input name="teacher.classId" id="classId" type="text"  class="dfinput" value="${teacher.classId}" /></li>
    <li><label>课程Id</label><input name="teacher.courseId" id="courseId" type="text"  class="dfinput" value="${teacher.courseId}" /></li>
      <li><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
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
  $(function() {
   var className="${student.className}";
   $("select[name='className']").find("option[value='"+className+"']").attr("selected",true);
    var grade="${student.grade}";
   $("select[name='grade']").find("option[value='"+grade+"']").attr("selected",true);
   });
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
   <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">基本信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>学生基本信息</span></div>
    <form action="<%= basePath%>/front/Student_update.action" method="post" id="commonform" autocomplete="off">
	    <ul class="forminfo">
	    <input name="student.studentId" type="hidden" value="${student.studentId}"/>
	    <input name="student.studentNumber" type="hidden" value="${student.studentNumber}"/>
	    <li><label>学生学号</label><label style="width:50%">${student.studentNumber}</label></li>
	    <li><label>学生姓名</label><input name="student.studentName" id="studentName" type="text"  class="dfinput" value="${student.studentName}" /></li>
	    <input name="student.studentPassword" id="studentPassword" type="hidden"  class="dfinput" value="${student.studentPassword }"/></li>
	    <li><label>所属班级</label>
	            <select name="className" id="className" onchange="selectValue(this)"  class="dfinput">
	                 <c:forEach items="${session.classNameList}" var="classNameList">
	                      <option value="${classNameList}">${classNameList}</option>
	                 </c:forEach>
	            </select>
	     </li>
	      <li><label>年级</label>
	           <select name="grade" id="grade" onchange="selectValue(this)"  class="dfinput" required="required">
	                <option value="2015级">2015级</option>
	                <option value="2016级">2016级</option>
	                <option value="2017级">2017级</option>
	                <option value="2018级">2018级</option>
	         </select>
	     </li>
	      <li><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
    </div>


</body>

</html>
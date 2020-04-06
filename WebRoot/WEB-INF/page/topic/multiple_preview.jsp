<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预览试题</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script> 
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" type="text/css"/>
<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>

</head>

<body >

    <div class="formbody">
    
	    <ul class="forminfo">
		    <input name="id" type="hidden" value="${id}"/>
		     <li><label>试题类型</label>
		           <input name="type" id="type" onchange="selectValue(this)" class="dfinput" value="${multipleTopic.type}" readonly="readonly">
		     </li>
		     <li><label>所属题库</label>
		           <input name="topicBankName" id="topicBankName" onchange="selectValue(this)" class="dfinput" value="${multipleTopic.topicBankName }" readonly="readonly">
		     </li>
		     <li><label>试题难度</label>
		           <input name="difficulty" id="difficulty" onchange="selectValue(this)" class="dfinput" value="${multipleTopic.difficulty }" readonly="readonly">
		     </li>
		     <li><label>试题题干</label>
			    <textarea name="description" id="description" rows="3" cols="20" style="width: 700px; height: 100px;" readonly="readonly">${multipleTopic.description}</textarea>
		     </li>
	    
	    <div id="single">
		    <li><label>选项A</label><input name="optionA" id="optionA" type="text" class="dfinput" value="${multipleTopic.optionA }" readonly="readonly"/></li>
		    <li><label>选项B</label><input name="optionB" id="optionB" type="text" class="dfinput" value="${multipleTopic.optionB }" readonly="readonly"/></li>
		    <li><label>选项C</label><input name="optionC" id="optionC" type="text" class="dfinput" value="${multipleTopic.optionC }" readonly="readonly"/></li>
		    <li><label>选项D</label><input name="optionD" id="optionD" type="text" class="dfinput" value="${multipleTopic.optionD }" readonly="readonly"/></li>
		    <li><label>选项E</label><input name="optionE" id="optionE" type="text" class="dfinput" value="${multipleTopic.optionE }" readonly="readonly"/></li>
		    <li><label>试题答案</label>
		      <input name="topicAnswer0" id="topicAnswer0" onchange="selectValue(this)" class="dfinput" value="${multipleTopic.answer }" readonly="readonly">
		    </li>
	    </div>
	    
		    <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" value="${multipleTopic.knowledge}" readonly="readonly"/></li>
		    <li><label>创建人</label><label style="width:50%">${multipleTopic.creator}</label></li>
	    </ul>
    </div>
</body>

</html>

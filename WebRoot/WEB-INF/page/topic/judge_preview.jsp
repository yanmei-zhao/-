<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
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
  
  <body>
   	<div class="formbody">
    
	    <form action="<%= basePath%>/front/JudgeTopic_update.action" method="post" id="commonform">
	     
		    <ul class="forminfo">
			    <input name="judgeTopic.id" type="hidden" value="${judgeTopic.id}"/>
			    <li><label>试题类型</label>
			           <input name="type" id="type" onchange="selectValue(this)" class="dfinput" value="${judgeTopic.type}" readonly="readonly">
			     </li>
			     <li><label>所属题库</label>
			           <input name="topicBankName" id="topicBankName" onchange="selectValue(this)" class="dfinput" value="${judgeTopic.topicBankName }" readonly="readonly">
			     </li>
			     <li><label>试题难度</label>
			           <input name="difficulty" id="difficulty" onchange="selectValue(this)" class="dfinput" value="${judgeTopic.difficulty}" readonly="readonly">
			     </li>
			     <li><label>试题题干</label>
			    	<textarea name="description" id="description" rows="3" cols="20" style="width: 800px; height: 200px;"> ${judgeTopic.description} </textarea>
			    </li>
			  
			     <div id="fill">
				    <li><label>答案设置</label>
				     <input name="answer" type="text"  class="dfinput" value="${judgeTopic.answer}"/>
				    </li>
			    </div>
			    
			    <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" value="${judgeTopic.knowledge}"/></li>
			    <input name="creator" type="hidden" value="${judgeTopic.creator}"/>
			    <li><label>创建人</label><label style="width:50%">${judgeTopic.creator}</label></li>
			   
			    <li><label>&nbsp;</label><input name="add_btn" type="submit" onclick="b()" class="btn" value="确认保存"/></li>
		    </ul>
	    </form>
    </div>
   
  </body>
</html>

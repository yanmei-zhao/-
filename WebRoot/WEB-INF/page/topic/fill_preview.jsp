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

 <script type="text/javascript">
 $(function() {
	 	//设置按题目类型更改页面
	   var str2="${fillTopic.type}";
	     document.getElementById("single").style.display = 'none';
	    document.getElementById("mul").style.display = 'none';
	    document.getElementById("simple").style.display = 'none';
	    document.getElementById("judge").style.display = 'none';
	    document.getElementById("fill").style.display = 'none';
	    if ((str2=="单选题")) {
	    document.getElementById("single").style.display = 'block';
	   }else if(str2=="多选题"){
	    document.getElementById("mul").style.display = 'block';
	   } else if(str2=="简答题"){
	    document.getElementById("simple").style.display = 'block';
	   }else if(str2=="判断题"){
	    document.getElementById("judge").style.display = 'block';
	   }else if(str2=="填空题"){
	    document.getElementById("fill").style.display = 'block';
	   }
  })
</script>

</head>
<body >

    <div class="formbody">
    
    <ul class="forminfo">
	    <input name="id" type="hidden" value="${id}"/>
	     <li><label>试题类型</label>
	           <input name="type" id="type" onchange="selectValue(this)" class="dfinput" value="${fillTopic.type}" readonly="readonly">
	     </li>
	     <li><label>所属题库</label>
	           <input name="topicBankName" id="topicBankName" onchange="selectValue(this)" class="dfinput" value="${fillTopic.topicBankName }" readonly="readonly">
	     </li>
	     <li><label>试题难度</label>
	           <input name="difficulty" id="difficulty" onchange="selectValue(this)" class="dfinput" value="${fillTopic.difficulty}" readonly="readonly">
	     </li>
	     <li><label>试题题干</label>
		    <textarea name="description" id="description" rows="3" cols="20" style="width: 700px; height: 100px;" readonly="readonly"> ${fillTopic.description}</textarea>
	     </li>
    
    <div id="single" style="display:none">
	    <li><label>选项A</label><input name="optionA" id="optionA" type="text" class="dfinput" value="${optionA }" readonly="readonly"/></li>
	    <li><label>选项B</label><input name="optionB" id="optionB" type="text" class="dfinput" value="${optionB }" readonly="readonly"/></li>
	    <li><label>选项C</label><input name="optionC" id="optionC" type="text" class="dfinput" value="${optionC }" readonly="readonly"/></li>
	    <li><label>选项D</label><input name="optionD" id="optionD" type="text" class="dfinput" value="${optionD }" readonly="readonly"/></li>
	    <li><label>试题答案</label>
	      <input name="topicAnswer0" id="topicAnswer0" onchange="selectValue(this)" class="dfinput" value="${fillTopic.answer}" readonly="readonly">
	    </li>
    </div>
    
   <div id="mul" style="display:none">
	     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	     <input type="button" id="bt1" value="增加选项" onClick="add();"> 
	     <input type="button" id="bt2" value="删除选项" onClick="delete1();"> 
	     <p>
	     <table id="optionlist0"> 
		     <li><label>选项1</label><input name="option1" id="option1" type="text" class="dfinput" value="${optionA }" readonly="readonly"/></li>
		     <li><label>选项2</label><input name="option2" id="option2" type="text" class="dfinput" value="${optionB }" readonly="readonly"/></li>
		     <li><label>选项3</label><input name="option3" id="option3" type="text" class="dfinput" value="${optionC }" readonly="readonly"/></li>
		     <li><label>选项4</label><input name="option4" id="option4" type="text" class="dfinput" value="${optionD }" readonly="readonly"/></li>
		     <li><label>试题答案</label>
		       <input name="topicAnswer1" id="topicAnswer1" onchange="selectValue(this)" class="dfinput" value="${topicAnswer1}" readonly="readonly">
		     </li>
	     </table> 
    </div>
    
    <div id="simple" style="display:none">
	    <li><label>答案设置</label>
	    <textarea name="answer0" id="answer0" rows="3" cols="20" style="width: 800px; height: 100px; " readonly="readonly">
     		 ${topic.answer}
   		</textarea>
   </li></div>
    
    <div id="judge" style="display:none">
	    <li><label>答案设置</label>
		    <input type="radio" name="topicAnswer" value="正确" <c:if test='${topicAnswer== "正确" }'>checked</c:if>>正确
		    <br>
		    <input type="radio" name="topicAnswer" value="错误" <c:if test='${topicAnswer== "错误" }'>checked</c:if>>错误
	    </li>
    </div>
    
     <div id="fill" style="display:none">
	    <li><label>答案设置</label>
	     <input type="text" name="fillTopic.answer" class="dfinput" value="${fillTopic.answer}" > 
	    </li>
     </div>
    
    <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" value="${fillTopic.knowledge}" readonly="readonly"/></li>
    <input name="creator" type="hidden" value="${fillTopic.creator}"/>
    <li><label>创建人</label><label style="width:50%">${fillTopic.creator}</label></li>
   
    </ul>
    
    </div>
</body>

</html>

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

 <script type="text/javascript">
 $(function() {
	  var topicTypes="${topic.topicTypes}";
	  $("select[name='topicTypes']").find("option[value='"+topicTypes+"']").attr("selected",true);
	  var topicDegree="${topic.topicDegree}";
	  $("select[name='topicDegree']").find("option[value='"+topicDegree+"']").attr("selected",true);
	  var topicBankName="${topic.topicBankName}";
	  $("select[name='topicBankName']").find("option[value='"+topicBankName+"']").attr("selected",true);
 //设置按题目类型更改页面
   var str2="${topic.topicTypes}";
     document.getElementById("single").style.display = 'none';
    document.getElementById("mul").style.display = 'none';
    document.getElementById("simple").style.display = 'none';
    document.getElementById("judge").style.display = 'none';
    document.getElementById("fill").style.display = 'none';
    if ((str2=="单选题")) {
    document.getElementById("single").style.display = 'block';
   }else if(str2=="多选题"){
    document.getElementById("mul").style.display = 'block';
   } else if(str2=="问答题"){
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
    <input name="topic.topicId" type="hidden" value="${topic.topicId}"/>
    <li><label>试题编号</label><label style="width:50%">${topic.topicId}</label></li>
     <li><label>试题类型</label>
           <input name="topicTypes" id="topicTypes" onchange="selectValue(this)" class="dfinput" value="${topic.topicTypes }" readonly="readonly">
     </li>
     <li><label>所属题库</label>
           <input name="topicBankName" id="topicBankName" onchange="selectValue(this)" class="dfinput" value="${topic.topicBankName }" readonly="readonly">
     </li>
     <li><label>试题难度</label>
           <input name="topicDegree" id="topicDegree" onchange="selectValue(this)" class="dfinput" value="${topic.topicDegree }" readonly="readonly">
     </li>
     <li><label>试题题干</label>
    <textarea name="topic.question" id="question" rows="3" cols="20" style="width: 700px; height: 100px;" readonly="readonly">
    ${topic.question}
    </textarea>
    </li>
    
    <div id="single" style="display:none">
      <li><label>选项A</label><input name="optionA" id="optionA" type="text" class="dfinput" value="${topic.optionA }" readonly="readonly"/></li>
      <li><label>选项B</label><input name="optionB" id="optionB" type="text" class="dfinput" value="${topic.optionB }" readonly="readonly"/></li>
      <li><label>选项C</label><input name="optionC" id="optionC" type="text" class="dfinput" value="${topic.optionC }" readonly="readonly"/></li>
      <li><label>选项D</label><input name="optionD" id="optionD" type="text" class="dfinput" value="${topic.optionD }" readonly="readonly"/></li>
    <li><label>试题答案</label>
        <input name="topicAnswer0" id="topicAnswer0" onchange="selectValue(this)" class="dfinput" value="${topic.topicAnswer0 }" readonly="readonly">
    </li>
    </div>
    
   <div id="mul" style="display:none">
     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
     <input type="button" id="bt1" value="增加选项" onClick="add();"> 
     <input type="button" id="bt2" value="删除选项" onClick="delete1();"> 
     <p>
     <table id="optionlist0"> 
      <li><label>选项1</label><input name="option1" id="option1" type="text" class="dfinput" value="${topic.option1 }" readonly="readonly"/></li>
      <li><label>选项2</label><input name="option2" id="option2" type="text" class="dfinput" value="${topic.option2 }" readonly="readonly"/></li>
      <li><label>选项3</label><input name="option3" id="option3" type="text" class="dfinput" value="${topic.option3 }" readonly="readonly"/></li>
      <li><label>选项4</label><input name="option4" id="option4" type="text" class="dfinput" value="${topic.option4 }" readonly="readonly"/></li>
     <li><label>试题答案</label>
        <input name="topicAnswer1" id="topicAnswer1" onchange="selectValue(this)" class="dfinput" value="${topic.topicAnswer1 }" readonly="readonly">
    </li>
     </table> 
    </div>
    
    <div id="simple" style="display:none">
    <li><label>答案设置</label>
    <textarea name="topicAnswer2" id="topicAnswer2" rows="3" cols="20" style="width: 800px; height: 100px; " readonly="readonly">
      ${topic.topicAnswer2 }
    </textarea>
   </li></div>
    
    <div id="judge" style="display:none">
    <li><label>答案设置</label>
    <input type="radio" name="topicAnswer" value="正确" <c:if test='${topic.topicAnswer== "正确" }'>checked</c:if>>正确
    <br>
    <input type="radio" name="topicAnswer" value="错误" <c:if test='${topic.topicAnswer== "错误" }'>checked</c:if>>错误
    </li>
    </div>
    
     <div id="fill" style="display:none">
    <li><label>答案设置</label>
     <input type="text" name="topicAnswer3" class="dfinput" value="${topic.topicAnswer3}" > 
     
    </li>
    </div>
    
    <li><label>知识点</label><input name="topic.pointName" type="text"  class="dfinput" value="${topic.pointName}" readonly="readonly"/></li>
    <li><label>课程名称</label><input name="topic.courseName" type="text"  class="dfinput" value="${topic.courseName}" readonly="readonly"/></li>
    <input name="topic.teacherName" type="hidden" value="${topic.teacherName}"/>
    <li><label>创建人</label><label style="width:50%">${topic.teacherName}</label></li>
   
    </ul>
    
    </div>
</body>

</html>

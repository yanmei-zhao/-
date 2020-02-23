<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.gxuwz.Market.business.entity.Group" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户管理-用户新增</title>
	<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
	<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
	<script type="text/javascript">
       $(function(){
		
		//如果是新增成功，会返回1，如果是1，则提示保存成功
		if("1" == "${actionState}"){
			alert('保存成功！');
		}
		
           $("#commonform").validate({
               errorClass: "errorInfo", //默认为错误的样式类为：error
               focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
               onkeyup: false,   
               submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
				checkFrom();
                   form.submit();   //提交表单   
               },   
               rules:{
                  "studentId":{
                       required:true,
                   },
                   "studentName":{
                       required:true,
                   },
                   "classId":{
                       required:true,
                   },
               },
               messages:{
                   "studentName":{
                       required:"必填",
                   },
                   "studentId":{
                       required: "必填",
                     digits:"请输入整数",  
                   },
                    "classId":{
                       required:"必填",
                   },
                 }
           });    
       });
    </script>
</head>

<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
	    <li><a href="#">用户管理</a></li>
	    <li><a href="#">新增学生</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    <div class="formtitle"><span>新增学生</span></div>
    <form action="<%= basePath%>/front/Student_add.action" method="post" id="commonform" autocomplete="off">
	    <ul class="forminfo">
	     <li><label>学生名称</label><input name="studentName" id="studentName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
	     <li><label>学生学号</label><input name="studentNumber" id="studentNumber" type="text"  class="dfinput"/><i><font color="#FF0000">*必填</font>请输入整数</i></span></li>
	     <li><label>所属班级</label>
	     <%List<String> classNameList=(List<String>)request.getSession().getAttribute("classNameList"); %>
	        <select name="className" id="className" onchange="selectValue(this)"  class="dfinput">  
	        <option >请选择...</option>
	            <c:forEach items="${session.classNameList}" var="classNameList">
	                <option>${classNameList}</option>
	            </c:forEach>
	       </select>
	     </li>
	      <li><label>年级</label>
	           <select name="grade" id="#grade" onchange="selectValue(this)"  class="dfinput" required="required">
	                <option value="null">请选择...</option>
	                <option>2015级</option>
	                <option>2016级</option>
	                <option>2017级</option>
	                <option>2018级</option>
	         </select><i><font color="#FF0000">*必填</font></i>
	     </li>
	     <li><input name="userType" id="userType" type="hidden" value=1 class="dfinput"/></li>
	     <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>

</body>

</html>

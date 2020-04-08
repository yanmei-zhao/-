<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改教师信息</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>

<script type="text/javascript">
</script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
</script>
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
                    "teacher.teacherPassword":{
                        required:true,
                        minlength: 6,
                    },
                },
                messages:{
                    "teacher.teacherPassword":{
                        required: "必填",
                        minlength: "至少需要填入6位数",
                    }
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
	    <li><a href="#">个人信息</a></li>
	    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>教师基本信息</span></div>
    <form action="<%= basePath%>/front/Teacher_update1.action" method="post" id="commonform" autocomplete="off">
	    <ul class="forminfo">
		    <input name=teacher.teacherId id="teacherId" type="hidden" value="${teacher.teacherId}" />
		    <li><label>姓名</label><input name="teacher.teacherName" id="teacherName" type="text"  class="dfinput" value="${teacher.teacherName}" /></li>
		    <li><label>原密码</label><input name="teacher.teacherPassword1" id="teacherPassword" type="password"  class="dfinput" value="${teacher.teacherPassword }"/></li>
		    <li><label>新密码</label><input name="teacher.teacherPassword" type="password" class="dfinput"/><i><font color="#FF0000">*必填</font>不能少于6位数</i></li>
		    <li><input name="teacher.userType" type="hidden" class="dfinput" value="${teacher.userType}"/></li>
		    <li><input name="teacher.classId" id="classId" type="hidden"  class="dfinput" value="${teacher.classId}" /></li>
		    <li><input name="teacher.courseId" id="courseId" type="hidden"  class="dfinput" value="${teacher.courseId}" /></li>
		    <li><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>


</body>

</html>
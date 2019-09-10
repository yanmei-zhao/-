<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改角色权限信息</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script> 
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
                        digits:true,
                    },
                    "studentName":{
                        required:true,
                       
                    },
                    "classId":{
                        required:true,
                     }
          
                
        
             },
                messages:{
                    "studentId":{
                        required:"必填",
                        
                    },
                    "studentName":{
                        required:"必填",
                       
                    },
     
                    "classId":{
                        required: "必填",
                        
                        
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
    <li><a href="#">首页</a></li>
    <li><a href="#">学生管理</a></li>
    <li><a href="#">修改学生信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改学生信息</span></div>
    <form action="<%= basePath%>/front/student_update.action" method="post" id="commonform">
     
    <ul class="forminfo">
    <input name="student.studentId" type="hidden" value="${student.studentId}"/>
    <li><label>试题编号</label><label style="width:50%">${student.studentId}</label></li>
    <li><label>试题名称</label><input name="student.studentName" type="text"  class="dfinput" value="${student.studentName}"/><i><font color="#FF0000">*必填</font></i></li>
    <li><label>知识点</label><input name="student.classId" type="text"  class="dfinput" value="${student.classId}"/><i><font color="#FF0000">*必填</font></i></li>
     
    <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>

</body>

</html>

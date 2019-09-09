<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> 课程-新增</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script>
var  _contextPath="<%=path%>";
var  _modulePath=_contextPath+"/sys/";

$(document).ready(function(e) {
    $(".btn").click(function(){
		_sbmForm(_modulePath+"textures_add.action?view=list","");
		});
});

</script>

<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
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
                    	 digits:true,
                    	 required:true,
                       
                    },
                    "studentName":{
                        required:true,
                        
                    },
                    "classId":{
                        required:true,
                        digits:true,
                        
                    }
                },
                messages:{
                    "studentId":{
                        required:"必填",
                        digits:"请输入整数",
                    },
                    "studentName":{
                        required:"必填",
                       
                    },
                    "classId":{
                        required: "必填",
                        digits:"请输入整数",
                       
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
    <li><a href="#">首页</a></li>
    <li><a href="#">添加学生</a></li>
 
    </ul>
    </div>
    
    <div class="formbody">	
    
    <div class="formtitle"><span>课程信息</span></div>
    <form action="<%= basePath%>/front/StudentManage_add.action" method="post" id="commonform">
    <ul class="forminfo">
    <li><label>学号</label><input name="studentId" id="studentId" type="text"  class="dfinput"/><i><font color="#FF0000">*必填</font></i><span id="gradeInfo"></span></li>
    <li><label>学生名称</label><input name="studentName" id="studentName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
    <li><label>班级编号</label><input name="classId" id="classId" type="text"  class="dfinput"/><i><font color="#FF0000">*必填</font></i></li>
    <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考试分析</title>
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
                    "topicName":{
                        required:true,
                        
                    },
                    "pointName":{
                        required:true,
                        
                        
                    },
                    "topicDegree":{
                        required:true,
                        
                    },
                    "topicTypes":{
                        required:true,
                       
                       
                    },
                    "topicScore":{
                        required:true,
                        digits:true,
                       
                    },
                    "topicAnswer":{
                        required:true,
                        
                    },
                    "courseName":{
                        required:true,
                        
                    },
                    "teacherName":{
                        required:true,
                        
                         
                    },
                  
                },
                messages:{
                    "topicName":{
                        required:"必填",
                        
                    },
                    "pointName":{
                        required: "必填",
                       
                    },
                    "topicDegree":{
                        required:"必填",
                        
                    },
                    "topicTypes":{
                        required:"必填",
                       
                    },
                   
                    "topicScore":{
                        required: "必填",
                        digits:"请输入整数",
                       
                    },
                    "topicAnswer":{
                        required: "必填",
                       
                        
                    },
                    "courseName":{
                        required: "必填",
                       
                    },
                
                    "teacherName":{
                        required: "必填",
                      
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
    <li><a href="#">统计分析</a></li>
    <li><a href="#" style="cursor:default">考试分析</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>考试分析</span></div>
    <form action="<%= basePath%>/front/Topic_add.action" method="post" id="commonform">
    <ul class="forminfo">
     <li><label>选择试卷</label>
          <input name="testPaper" type="text"  class="dfinput" />  
     </li>
     
    
    <ul class="forminfo">
    <li>
    <label>&nbsp;</label><input name="" type="submit" class="btn" value="开始统计"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </li>
    
    </ul>
    </form>
    
    </div>

</body>

</html>

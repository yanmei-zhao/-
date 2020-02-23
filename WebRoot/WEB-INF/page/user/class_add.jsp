<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理-班级新增</title>
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
                    "className":{
                        required:true,
                    },
                     "grade":{
                        required:true,
                    },
                     "institute":{
                       required:true,
                    },
                     "studentNumber":{
                        required: "必填",
                          digits:true,
                    },
                },
                messages:{
                    "className":{
                        required: "必填",
                    },
                    "grade":{
                        required:"必填",
                    },
                     "institute":{
                        required:"必填",
                    },
                    "studentNumber":{
                        required: "必填",
                       digits:"请输入整数",  
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
    <li><a href="#">新增班级</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <div class="formtitle"><span>新增班级</span></div>
    <form action="<%= basePath%>/front/Group_add.action" method="post" id="commonform" autocomplete="off">
	    <ul class="forminfo">
	    <li><label>班级名称</label><input name="className" id="className" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
	     <li><label>年级</label>
	           <select name="grade" id="#grade" onchange="selectValue(this)"  class="dfinput" required="required">
	                <option >请选择...</option>
	                <option>2015级</option>
	                <option>2016级</option>
	                <option>2017级</option>
	                <option>2018级</option>
	         </select><i><font color="#FF0000">*必填</font></i>
	     </li>
	     <li><label>学院</label>
	          <select name="institute" id="#institute" onchange="selectValue(this)"  class="dfinput">
	                <option >请选择...</option>
	                <option>大数据与软件工程学院</option>
	                <option>电子与信息工程学院</option>
	                <option>文学与传媒学院</option>
	                <option>教师教育学院</option>
	                <option>外国语学院</option>
	                <option>宝石与艺术学院</option>
	                <option>商学院</option>
	                <option>马克思主义学院</option>
	                <option>法学与公共管理学院</option>
	                <option>机械与材料工程学院&化学与资源再利用学院</option>
	          </select><i><font color="#FF0000">*必填</font></i>
	     </li>
	     <input name="studentNumber" type="hidden" value="0"/>
	    <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>

</body>

</html>

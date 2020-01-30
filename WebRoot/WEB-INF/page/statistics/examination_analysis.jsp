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
                    "testpaperName":{
                        required:true,
                    },
                },
                messages:{
                    "testpaperName":{
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
		    <li><a href="#">统计分析</a></li>
		    <li><a href="#" style="cursor:default">考试分析</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>考试分析</span></div>
	    <form action="<%= basePath%>/front/Statistics_.action" method="post" id="commonform">
		    <ul class="forminfo">
			      <li><label>选择试卷</label>
			           <select name="examName" id="examName" onchange="selectValue(this)"  class="dfinput">
			               <option >请选择...</option>
			            <c:forEach items="${session.examNameList}" var="examNameList">
			                <option>${examNameList}</option>
			            </c:forEach>
			          </select><i><font color="#FF0000">*必填</font></i>
		     	 </li>
		    </ul>
		    <ul class="forminfo">
			    <li>
			    <label>&nbsp;</label><input name="" type="submit" class="btn" value="开始统计"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    </li>
		    </ul>
	    </form>
    
    </div>

</body>

</html>

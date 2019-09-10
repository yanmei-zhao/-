<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑题库基本信息</title>
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
                    "topicBank.topicBankId":{
                        required:true,
                    },
                   
                },
                messages:{
                    "topicBank.topicBankName":{
                        required:"必填",
                    },
                    
                    
                  }
            });    
        });
        </script>
  <script type="text/javascript">
  $(function() {
    var grade="${topicBank.topicBankType}";
   $("select[name='topicBankType']").find("option[value='"+topicBankType+"']").attr("selected",true);
    });
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
    <li><a href="#">题库管理</a></li>
    <li><a href="#">基本信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>题库基本信息</span></div>
    <form action="<%= basePath%>/front/TopicBank_update.action" method="post" id="commonform">
       <%String userName=(String)request.getSession().getAttribute("userName"); %>
    <ul class="forminfo">
    <input name="topicBank.topicBankId" type="hidden" value="${topicBank.topicBankId}"/>
    <li><label>课程编号</label><label style="width:50%">${topicBank.topicBankId}</label></li>
    <li><label>课程名称</label><input name="topicBank.topicBankName" type="text"  class="dfinput" value="${topicBank.topicBankName}"/></li>
    <li><label>题库类型</label>
           <select name="topicBankType" id="topicBankType" onchange="selectValue(this)"  class="dfinput" required="required">
                <option>单选题</option>
                <option>多选题</option>
                <option>判断题</option>
                <option>填空题</option>
                <option>判断题</option>
         </select><i><font color="#FF0000">*必填</font></i>
     </li>
     <input name="topicNum" type="hidden" value="${topicBank.topicNum}"/>
     <input name="topicBank.creator" type="hidden" value="${topicBank.creator}"/>
     <input name="topicBank.finalModifier" type="hidden" value="${userName}"/>
    <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>

</body>

</html>

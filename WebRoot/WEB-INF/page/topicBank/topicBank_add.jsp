<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程管理-新增</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= path%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
var  _contextPath="<%=path%>";
var  _modulePath=_contextPath+"/sys/";

$(document).ready(function(e) {
    $(".btn").click(function(){
		_sbmForm(_modulePath+"textures_add.action?view=list","");
		});
});
</script>
<script type="text/javascript">
	$(function(){
		var url = "<%=basePath%>/front/SysJson_checkTopicBankId.action";
		$("#topicBankId").blur(function(){//给角色编号添加失去焦点事件
			var id = $("input[name='topicBankId']").val();//获取角色编号值 
		$.post(url,{"checkId":id},function(data){//发送请求验证角色编号 
				if(data == "no"){//如果返回 no,提示已存在 
					$("#gradeInfo").html("<font color=\"red\">您输入的编号存在！请重新输入！</font>"); 
				}else{//否则隐藏 
					$("#gradeInfo").hide();alert(123);
				}
			},"json");
		});
	});
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
                    "topicBankName":{
                        required:true,
                        maxlength: 20,
                    },
                },
                messages:{
                    "topicBankName":{
                        required: "必填",
                        maxlength: "至多只能填入20位数",
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
		    <li><a href="#">题库管理</a></li>
		    <li><a href="#">新增题库</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
      <%String userName=(String)request.getSession().getAttribute("userName"); %>
    <div class="formtitle"><span>新增题库</span></div>
	    <form action="<%= basePath%>/front/TopicBank_add.action" method="post" id="commonform" autocomplete="off">
		    <ul class="forminfo">
			    <li><label>题库名称</label><input name="topicBankName" id="topicBankName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
			     <li><label>题库类型</label>
			           <select name="topicBankType" id="topicBankType" onchange="selectValue(this)"  class="dfinput" required="required">
			                <option >请选择...</option>
			                <option>单选题</option>
			                <option>多选题</option>
			                <option>判断题</option>
			                <option>填空题</option>
			                <option>判断题</option>
			         </select><i><font color="#FF0000">*必填</font></i>
			     </li>
			      <input name="topicNum" type="hidden" value="0"/>
			     <input name="topicBank.creator" type="hidden" value="${userName}"/>
			     <input name="topicBank.finalModifier" type="hidden" value="${userName}"/>
			 </ul>    
		      <ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input name="" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			       <label>&nbsp;</label><a href="<%= basePath%>/front/topicBank_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			      </li>
		     </ul>
	    </form>
    </div>

</body>

</html>

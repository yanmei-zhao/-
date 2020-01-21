<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试卷管理-配置试卷</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" type="text/css"/>
<script type="text/javascript" src="<%= path%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
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
		var url = "<%=basePath%>/front/SysJson_checkTestpaperId.action";
		$("#checkTestpaperId").blur(function(){//给角色编号添加失去焦点事件
			var id = $("input[name='checkTestpaperId']").val();//获取角色编号值 
		$.post(url,{"checkId":id},function(data){//发送请求验证角色编号 
				if(data == "no"){//如果返回 no,提示已存在 
					$("#gradeInfo").html("<font color=\"red\">您输入的编号存在！请重新输入！</font>"); 
				}else{//否则隐藏 
					$("#gradeInfo").hide();
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
                    "testpaperId":{
                        required:true,
                        digits:true,
                    },
                    "testpaperName":{
                        required:true,
                    },
                },
                messages:{
                    "testpaperId":{
                        required:"必填",
                        digits:"请输入整数",  
                    },
                    "testpaperName":{
                        required:"必填",
                    },
            }    
        });
    });
        </script>
        
        <script type="text/javascript">
		//预览选择题列表页面（弹窗显示）
		  function preview(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加选择题',
		      area: ['1000px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openChoiceTopicList.action?testpaperId='+id,
		    });
		  }
		  //预览选择题列表页面（弹窗显示）
		  function preview1(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加选择题',
		      area: ['1000px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openFillTopicList.action?testpaperId='+id,
		    });
		  }
		  //预览选择题列表页面（弹窗显示）
		  function preview2(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加选择题',
		      area: ['1000px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openTopicList.action?testpaperId='+id,
		    });
		  }
	  </script>
        <script type="text/javascript">//动态实现二级联动
            function firstSel() {//如果第一个下拉列表的值改变则调用此方法
			var courseName = $("#courseName").val();//得到第一个下拉列表的值
				//通过ajax传入后台，把orderTypeName数据传到后端
				window.location.href="<%= basePath%>/front/TopicBank_gettopicBankName.action?courseName"+courseName;
				var url = "<%=basePath%>/front/TopicBank_gettopicBankName.action?courseName"+courseName;
			$.post("<%=basePath%>/front/TopicBank_gettopicBankName.action",{courseName:courseName});
	}
        </script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">试卷管理</a></li>
		    <li><a href="#">配置试卷</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
	    <div class="formtitle"><span>配置试卷</span></div>
	    	<form action="<%=basePath%>/front/Testpaper_add.action" method="post" id="commonform">
			    <ul class="forminfo"> 
				     <li><label>试卷名称:</label><label style="width:50%">${testpaper.testpaperName}</label></li>
				    <input name="testpaper.testpaperName" type="hidden"  class="dfinput" value="${testpaper.testpaperName}"/></li>   
	    	   </ul>
	    	   <ul class="forminfo">
			      <li>
			      		<a href="javascript:;" onclick="preview('${testpaper.testpaperId}')" class="tablelink">添加选择题</a>&nbsp;&nbsp;
			      		<a href="javascript:;" onclick="preview1('${testpaper.testpaperId}')" class="tablelink">添加填空题</a>&nbsp;&nbsp;
			      		<a href="javascript:;" onclick="preview2('${testpaper.testpaperId}')" class="tablelink">添加简答题</a>&nbsp;&nbsp;
			      </li>
		      </ul>
		      <ul class="forminfo">
			      <li>
				        <a href="<%= basePath%>/front/Testpaper_openChoiceTopicList.action?testpaperId=${testpaperId}"><input style="margin-top:12px" name="" type="button" class="btn" value="添加选择题"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="<%= basePath%>/front/Testpaper_openFillTopicList.action?testpaperId=${testpaperId}"><input name="" type="button" class="btn" value="添加填空题"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="<%= basePath%>/front/Testpaper_openTopicList.action?testpaperId=${testpaperId}"><input name="" type="button" class="btn" value="添加简答题"/></a>
			      </li>
		      </ul>
		 	  <ul class="forminfo">
			      <li>
			        <label>&nbsp;</label><input style="margin-top:12px" name="add_btn" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <label>&nbsp;</label><a href="<%= basePath%>/front/Testpaper_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			      </li>
		     </ul>
   		 </form>
 	 </div>
    
</body>

</html>

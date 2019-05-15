<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程管理-新增</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" type="text/css"/>
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
        
 <!-- <script type="text/javascript">//动态实现二级联动
	 function firstSel() {//如果第一个下拉列表的值改变则调用此方法
	   var courseName=$("#courseName").val();	//获取select选中的一级菜单id
	   alert(courseName);	
	  	var topicBankName=window.document.getElementById("topicBankName");//获取select2选择框元素 2017.08.13 miki		  
	$.ajax({  
    	type: "post",  
   	 dataType: "json",  
    	url: "<%=basePath%>/front/TopicBank_gettopicBankName.action",  
    	data: {courseName:courseName  },  //将courseName封装到data中
	success: function (msg) { 		//自定义function回传函数，msg对应action中的json对象menus
		
   	 	if (msg.length>0) {  		//遍历msg中的数据，将其打印到select的option标签中	
       	 var str = "";       	    
        	for (var key in msg) {        		        		   		
        		 str += "<option value="+ msg[key].id+" ${curMenu.id==menu.id?'selected':'' }>" +msg[key].name+ "</option>";   
                          }  
                 topicBankName.innerHTML = str;              
                }  
            },  
            error: function () {  
                alert("查询失败")  
            }  
        });    
  };  
    </script> --> 
        <script type="text/javascript">//动态实现二级联动
            function firstSel() {//如果第一个下拉列表的值改变则调用此方法
		var courseName = $("#courseName").val();//得到第一个下拉列表的值
		alert(courseName);
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
    <li><a href="#">快速创建试卷</a></li>
    </ul>
    </div>
  
    <div class="formbody">
    
    <div class="formtitle"><span>快速创建试卷</span></div>
    <form action="<%=basePath%>/front/Testpaper_add.action" method="post" id="commonform">
    <ul class="forminfo"> 
    <li><label>试卷名称</label><input name="testpaperName" id="testpaperName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
    <li><label>卷面总分</label><input name="totalScore" id="totalScore" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
    <li><label>及格分数</label><input name="passScore" id="passScore" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
     <%String userName=(String)request.getSession().getAttribute("userName"); %>
           <input name="creator" type="hidden" value="${userName}"/>
     
     <div style="padding-left: 85px;margin-top:12px">
        <input type="button" id="bt1" value="增加选项" class="btn layui-btn layui-btn-sm" onClick="add();"> 
        <input type="button" id="bt2" value="删除选项" class="btn layui-btn layui-btn-sm" onClick="delete1();">    
    </div>
     <li><label>章节设置</label></li> 
     
   <div id="chapter">
       <div>
             <input name="" id="" type="text" placeholder="章节名称" class="dfinput" style="width: 150px; ">
             <input name="" id="" type="text" placeholder="章节描述" class="dfinput" style="width: 300px; ">
       </div>
      <div style="padding-left: 85px;margin-top:12px">
         <select name="topicTypes" id="topicTypes" onchange="test(this.value)" class="dfinput" style="width: 110px; ">
                <option value="">请选择题型</option>
                <option value="单选题">单选题</option>
                <option value="多选题">多选题</option>
                <option value="判断题">判断题</option>
                <option value="填空题">填空题</option>
                <option value="问答题">问答题</option>
          </select>
        <%List<String> courseNameList=(List<String>)request.getSession().getAttribute("courseNameList"); %>
          <select name="courseName" id="courseName" onchange="firstSel()" class="dfinput" style="width: 110px; ">
                <option value="">请选择课程</option>
                <c:forEach items="${session.courseNameList}" var="courseNameList">
                  <option>${courseNameList}</option>
              </c:forEach>
           </select>
           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput" style="width: 135px; ">
                  <option value="0">请选择题库</option>
                  
           </select>
           
            <select name="topicDegree" id="topicDegree" onchange="selectValue(this)"  class="dfinput" style="width: 100px; ">
                <option>非常容易</option>
                <option>比较容易</option>
                <option selected="selected">常规</option>
                <option>比较难</option>
                <option>非常难</option>
            </select>
            <input name="topicNum" type="text" class="dfinput" placeholder="试题数量"  style="width: 70px; "/>
            <input name="topicScore" type="text" class="dfinput" placeholder="每题分值"  style="width: 70px; "/>
        </div>
        <table id="optionlist0"> 
        </table>
    </div>
    
   <ul class="forminfo">
      <li>
        <label>&nbsp;</label><input style="margin-top:12px" name="add_btn" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label>&nbsp;</label><a href="<%= basePath%>/front/Testpaper_list.action"><input name="" type="button" class="btn" value="取消"/></a>
      </li>
    </ul>
    </form>
    
 </div>
    
<script language="javascript"> //章节设置
function add(){ 
var len = optionlist0.rows.length; //得到table的行数 
var obj = optionlist0.insertRow(len);//在最后一行插入
/**插入第一列**/ 
obj.insertCell(0).innerHTML=""; 

} 
function delete1(){ 
var len = optionlist0.rows.length; 
if(len <= 1) { 
alert("至少要有多一个选项"); 
} 
else { 
optionlist0.deleteRow(len-1);//删除最后一项 
} 
} 
function getOptionCount(){ 
return optionlist0.rows.length; 
} 
</script> 
</body>

</html>

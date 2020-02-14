<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试卷管理-快速创建试卷</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>
<script>
var  _contextPath="<%=path%>";
var  _modulePath=_contextPath+"/sys/";
$(document).ready(function(e) {
    $(".btn").click(function(){
		_sbmForm(_modulePath+"textures_add.action?view=list","");
		});
});
</script>

<script language="javascript">
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
                    "testpaperName":{
                        required:true,
                    },
                },
                messages:{
                    "testpaperName":{
                        required: "必填",
                    }
                  }
            });    
        });
        </script>
        
        <script type="text/javascript">//动态实现二级联动
            function firstSel() {//如果第一个下拉列表的值改变则调用此方法
	            var type = $("#topicTypes").val();//得到第一个下拉列表的值
	            alert(type);
	            var choiceTopicNameList1 ="${session.ChoiceTopicBankNameList}";
	            var arry = new Array();
	             <c:forEach items="${session.ChoiceTopicBankNameList}" var="item" varStatus="status">
		            	arry.push("${item}");
		            </c:forEach>
		            for(var i=0;i<arry.length;i++){
		            	var  option = document.createElement("option");
		            	$(option).val(arry[i]);
		            	$(option).text(arry[i]);
		            	$("#topicBankName").append(option);
		            }
	             if((type=="单选题")||(type.equals("单选题"))){
	             alert(a);
	             	
	             }else if(type=="多选题"){
	             	alert(4);
	             }
			}
			
			/*2、书写查询按钮函数*/
		   	document.getElementById("single").style.display = 'none';
		    document.getElementById("simple").style.display = 'none';
		    document.getElementById("fill").style.display = 'none';
		    if ((str2=="单选题")) {
		    	document.getElementById("single").style.display = 'block';
		   }else if(str2=="填空题"){
		    	document.getElementById("fill").style.display = 'block';
		   } else if(str2=="简答题"){
		    	document.getElementById("simple").style.display = 'block';
		   }
        </script>
   <script type="text/javascript">
	   var str2 = 0;
	   /*1、定义复选框函数*/
	   function test(id) {
	  		 alert(1);
		    str2 = id;
		    var s = document.getElementById("topicBankName").parentElement.parentElement.id;
		    var type = $("#topicTypes").val();//得到第一个下拉列表的值
		    alert("s=="+s);
		    var ChoiceTopicBankNameList ="${session.ChoiceTopicBankNameList}";
		    var FillTopicBankNameList ="${session.FillTopicBankNameList}";
	        var arry = new Array();
	        alert("type=="+type);
			alert("str2=="+str2);
		    if (type=="单选题") {
		         alert(1);
	             <c:forEach items="${session.ChoiceTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var  option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName").append(option);
	            }
		   }else if(type=="填空题"){
		    	alert(2);
	             <c:forEach items="${session.FillTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var  option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	s.$("#topicBankName").append(option);
	            }
		   } else if(type=="简答题"){
		    	alert(3);
	             <c:forEach items="${session.TopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var  option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	s.$("#topicBankName").append(option);
	            }
		   }
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
	  		<ul class="forminfo">
		    	<form action="<%=basePath%>/front/Testpaper_CreateTestRandom.action" method="post" id="commonform">
				     
					    <li><label>试卷名称</label><input name="testpaperName" id="testpaperName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
					    <li><label>卷面总分</label><input name="totalScore" id="totalScore" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
					    <li><label>及格分数</label><input name="passScore" id="passScore" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
					    <%String userName=(String)request.getSession().getAttribute("userName"); %>
		           		 <input name="creator" type="hidden" value="${userName}"/>
	     			
				    <div style="padding-left: 85px;margin-top:12px">
				    	<button type="button" class="btn layui-btn layui-btn-sm" onClick="addBtn();" style="width: 110px;">添加题目</button>
				    	<button type="button" class="btn layui-btn layui-btn-sm" onClick="delBtn();" style="width: 110px;">删除题目</button>
				    </div>
				    
				    <div id="topic">
					    <div class="form-group" id="details" style="margin-top:12px">
					    	<li><label>试题设置</label>
					       	  <select name="topicTypes" id="topicTypes" onchange="test(this.id)" class="dfinput" style="width: 110px; ">
					                <option value="">请选择题型</option>
					                <option value="单选题">单选题</option>
					                <option value="多选题">多选题</option>
					                <option value="判断题">判断题</option>
					                <option value="填空题">填空题</option>
					                <option value="简答题">简答题</option>
					          </select>
					          	<select name="topicBankName" id="topicBankName" onchange="selectValue(this.value)"  class="dfinput" style="width: 145px; ">
					                  <option>请选择所属题库</option>
					            </select>
					           <select name="topicDegree" id="topicDegree" onchange="selectValue(this)"  class="dfinput" style="width: 100px; ">
					                <option>非常容易</option>
					                <option>比较容易</option>
					                <option selected="selected">常规</option>
					                <option>比较难</option>
					                <option>非常难</option>
					            </select>
					            <input name="choiceTopicNum" type="text" class="dfinput" placeholder="试题数量"  style="width: 90px; "/>
					            <input name="choicePerScore" type="text" class="dfinput" placeholder="每题分值"  style="width: 90px; "/>
				            </li> 
					    </div>
				    </div>
					    <ul class="forminfo">
						      <li>
							        <label>&nbsp;</label><input style="margin-top:12px" name="add_btn" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							        <label>&nbsp;</label><a href="<%= basePath%>/front/Testpaper_list.action"><input name="" type="button" class="btn" value="取消"/></a>
						      </li>
					    </ul>
	   		    </form>
	   		</ul>
      </div>
    
    <script type="text/javascript">
    	var detail_div = 1;
    	function addBtn(){
    		var e = document.getElementById("details");
    		var div = document.createElement("div");
    		div.className = "form-group";
    		div.id = "details"+detail_div;
    		div.innerHTML = e.innerHTML;
    		document.getElementById("topic").appendChild(div);
    		detail_div++;
    	}
    	function delBtn(){
	    	var id = "details"+(detail_div-1).toString();
	    	var e = document.getElementById(id);
	    	document.getElementById("topic").removeChild(e);
	    	detail_div--;
    	}
    </script>
    
	<script language="javascript"> //章节设置
		function getOptionCount(){ 
			return optionlist.rows.length; 
		} 
		function choiceButton(){ 
		  $(".choice").toggle();
		}
		function fillButton(){ 
		  $(".fill").toggle();
		}
		function topicButton(){ 
		  $(".topic").toggle();
		}
	</script> 
</body>

</html>

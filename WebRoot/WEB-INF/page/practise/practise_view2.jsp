<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>试题练习首页面</title>
    
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>

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
                    },
                    "difficulty":{
                        required:true,
                    },
                },
                messages:{
                    "topicBankName":{
                        required:"必填",
                    },
                    "difficulty":{
                        required:"必填",
                    },
                 }
            });    
        });
      </script>
	<script type="text/javascript">
	   var str2 = 0;
	   /*1、定义复选框函数*/
	   function test(can) {
		    str2 = can;
		   /*2、书写查询按钮函数*/
		    document.getElementById("single").style.display = 'none';
		    document.getElementById("simple").style.display = 'none';
		    document.getElementById("fill").style.display = 'none';
		    document.getElementById("judge").style.display = 'none';
		     document.getElementById("multiple").style.display = 'none';
		    if ((str2=="单选题")) {
		    document.getElementById("single").style.display = 'block';
		   }else if(str2=="填空题"){
		    document.getElementById("fill").style.display = 'block';
		   } else if(str2=="简答题"){
		    document.getElementById("simple").style.display = 'block';
		   }else if(str2=="判断题"){
		    document.getElementById("judge").style.display = 'block';
		   }else if(str2=="多选题"){
		    document.getElementById("multiple").style.display = 'block';
		   }
		}
	</script>

</head>

<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex1.action" target="rightFrame">首页</a></li>
		    <li><a href="#">我的练习</a></li>
		    <li><a href="#" style="cursor:default">练习试题</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>习题练习</span></div>
      
	    <ul class="forminfo">
		     <li><label>选择类型</label>
		           <select name="type" id="type" onchange="test(this.value)" class="dfinput1">
		                <option ></option>
		                <option value="单选题">单选题</option>
		                <option value="多选题">多选题</option>
		                <option value="判断题">判断题</option>
		                <option value="填空题">填空题</option>
		                <option value="简答题">简答题</option>
		         </select><i><font color="#FF0000">*必填</font></i>
		     </li>
	     
	     <div id="single" style="display:none">
	     <form action="<%= basePath%>/front/ChoiceTopic_practiseList.action" method="post" name="commonform" id="commonform">
		    <li><label>选择题库</label>
		           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
		               <option >请选择...</option>
		            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
		                <option>${ChoiceTopicBankNameList}</option>
		            </c:forEach>
		         </select><i><font color="#FF0000">*必填</font></i>
		    </li>
		    <li><label>选择难度</label>
		         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
		              <option>非常容易</option>
		              <option>比较容易</option>
		              <option selected="selected">常规</option>
		              <option>比较难</option>
		              <option>非常难</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		    </li>
	       <li><label>练习方式</label>
		         <select name="way" id="way" onchange="selectValue(this)"  class="dfinput1">
		              <option selected="selected">顺序练习</option>
		              <option>随机练习</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		    </li>
	   		<ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input type="submit" class="btn"  value="开始练习"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     </li>
			</ul>
  		  </form>
	    </div>
	    
	   <div id="fill" style="display:none">
	    <form action="<%= basePath%>/front/FillTopic_practiseList.action" method="post" name="commonform" id="commonform">
	    	 <li><label>选择题库</label>
	           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
	               <option >请选择...</option>
		            <c:forEach items="${session.FillTopicBankNameList}" var="FillTopicBankNameList">
		                <option>${FillTopicBankNameList}</option>
		            </c:forEach>
	           </select><i><font color="#FF0000">*必填</font></i>
	         </li>
		     <li><label>选择难度</label>
		         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
		              <option>非常容易</option>
		              <option>比较容易</option>
		              <option selected="selected">常规</option>
		              <option>比较难</option>
		              <option>非常难</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		     </li>
	      	<li><label>练习方式</label>
		         <select name="way" id="way" onchange="selectValue(this)"  class="dfinput1">
		              <option selected="selected">顺序练习</option>
		              <option>随机练习</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		    </li>
	   		<ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input type="submit" class="btn"  value="开始练习"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      </li>
			</ul>
	      	</form>
	     </div>
	    
	    <div id="simple" style="display:none">
	    	<form action="<%= basePath%>/front/Topic_practiseList.action" method="post" name="commonform" id="commonform">
		    	<li><label>选择题库</label>
		           <select name="topicBankName" id="topic.topicBankName" onchange="selectValue(this)"  class="dfinput1">
		               <option >请选择...</option>
			            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
			                <option>${TopicBankNameList}</option>
			            </c:forEach>
		          </select><i><font color="#FF0000">*必填</font></i>
		        </li>
		     
			     <li><label>选择难度</label>
			         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
			              <option>非常容易</option>
			              <option>比较容易</option>
			              <option selected="selected">常规</option>
			              <option>比较难</option>
			              <option>非常难</option>
			        </select><i><font color="#FF0000">*必填</font></i>
			     </li>
	      		<li><label>练习方式</label>
			         <select name="way" id="way" onchange="selectValue(this)"  class="dfinput1">
			              <option selected="selected">顺序练习</option>
			              <option>随机练习</option>
			        </select><i><font color="#FF0000">*必填</font></i>
		    	</li>
		   		<ul class="forminfo">
				     <li>
				       <label>&nbsp;</label><input type="submit" class="btn"  value="开始练习"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				     </li>
				</ul>
	      	</form>
	    </div>
	    
	    <div id="judge" style="display:none">
	    	<form action="<%= basePath%>/front/JudgeTopic_practiseList.action" method="post" name="commonform" id="commonform">
		    	<li><label>选择题库</label>
		           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
		               <option >请选择...</option>
			            <c:forEach items="${session.JudgeTopicBankNameList}" var="JudgeTopicBankNameList">
			                <option>${JudgeTopicBankNameList}</option>
			            </c:forEach>
		          </select><i><font color="#FF0000">*必填</font></i>
		        </li>
		     
			     <li><label>选择难度</label>
			         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
			              <option>非常容易</option>
			              <option>比较容易</option>
			              <option selected="selected">常规</option>
			              <option>比较难</option>
			              <option>非常难</option>
			        </select><i><font color="#FF0000">*必填</font></i>
			     </li>
	      		<li><label>练习方式</label>
			         <select name="way" id="way" onchange="selectValue(this)"  class="dfinput1">
			              <option selected="selected">顺序练习</option>
			              <option>随机练习</option>
			        </select><i><font color="#FF0000">*必填</font></i>
			    </li>
		   		<ul class="forminfo">
				     <li>
				       <label>&nbsp;</label><input type="submit" class="btn"  value="开始练习"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				     </li>
				</ul>
	      	</form>
	    </div>
	    
	     <div id="multiple" style="display:none">
	    	<form action="<%= basePath%>/front/MultipleTopic_practiseList.action" method="post" name="commonform" id="commonform">
		    	<li><label>选择题库</label>
		           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
		               <option >请选择...</option>
			            <c:forEach items="${session.MultiplesTopicBankNameList}" var="MultiplesTopicBankNameList">
			                <option>${MultiplesTopicBankNameList}</option>
			            </c:forEach>
		          </select><i><font color="#FF0000">*必填</font></i>
		        </li>
		     
			     <li><label>选择难度</label>
			         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
			              <option>非常容易</option>
			              <option>比较容易</option>
			              <option selected="selected">常规</option>
			              <option>比较难</option>
			              <option>非常难</option>
			        </select><i><font color="#FF0000">*必填</font></i>
			     </li>
	      		<li><label>练习方式</label>
			         <select name="way" id="way" onchange="selectValue(this)"  class="dfinput1">
			              <option selected="selected">顺序练习</option>
			              <option>随机练习</option>
			        </select><i><font color="#FF0000">*必填</font></i>
			    </li>
		   		<ul class="forminfo">
				     <li>
				       <label>&nbsp;</label><input type="submit" class="btn"  value="开始练习"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				     </li>
				</ul>
	      	</form>
	    </div>
	    
  </div>
  
  </body>
</html>

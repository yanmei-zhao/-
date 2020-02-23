<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单选题编辑</title>
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
                    "description":{
                        required:true,
                    },
                    "knowledge":{
                        required:true,
                    },
                    "difficulty":{
                    	required:true
                    },
                    "type":{
                        required:true
		            },
		            "answer":{
		                required:true,
		            },
		            "courseName":{
		                required:true,
		             },
                messages:{
                    "description":{
                        required:"必填",
                    },
                    "knowledge":{
                        required: "必填",
                    },
                    "difficulty":{
                        required: "必填",
                    },
                    "type":{
                        required: "必填",
                    },
                    "answer":{
                        required: "必填",
                    },
                    "creator":{
                        required: "必填",
                    },
                  }
                 }
            });    
        });
   </script>
   <script type="text/javascript">
 $(function() {
	  var type="${choiceTopic.type}";
	  $("select[name='type']").find("option[value='"+type+"']").attr("selected",true);
	  var difficulty="${choiceTopic.difficulty}";
	  $("select[name='difficulty']").find("option[value='"+difficulty+"']").attr("selected",true);
	  var topicBankName="${choiceTopic.topicBankName}";
	  $("select[name='topicBankName']").find("option[value='"+topicBankName+"']").attr("selected",true);
   })
</script>
</head>
  
  <body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">试题管理</a></li>
		    <li><a href="#">修改试题</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    	<div class="formtitle"><span>修改试题</span></div>
   			 <form action="<%= basePath%>/front/ChoiceTopic_update.action" method="post" id="commonform" autocomplete="off">
				 <ul class="forminfo">
			     <input name="choiceTopic.id" type="hidden" value="${choiceTopic.id}"/>
			     <li><label>试题类型</label>
		            <select name="type" id="type" onchange="selectValue(this)" class="dfinput" disabled="disabled">
		                <option value="单选题" >单选题</option>
		                <option value="多选题" >多选题</option>
		                <option value="判断题" >判断题</option>
		                <option value="填空题" >填空题</option>
		                <option value="简答题" >简答题</option>
			         </select>
			     </li>
			      <li><label>所属题库</label>
			           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
			            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
			                <option value="${ChoiceTopicBankNameList}">${ChoiceTopicBankNameList}</option>
			            </c:forEach>
			         </select>
			     </li>
			      <li><label>试题难度</label>
			           <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput">
			                <option value="非常容易">非常容易</option>
			                <option value="比较容易" >比较容易</option>
			                <option value="常规">常规</option>
			                <option value="比较难">比较难</option>
			                <option value="非常难">非常难</option>
			         </select>
			     </li>
			     <li><label>试题题干</label>
				    <textarea name="description" id="description" rows="3" cols="20" style="width: 800px; height: 200px;">${choiceTopic.description}</textarea>
			    </li>
		    
		      <div id="single" >
			      <li><label>选项A</label><input type="radio" name="choiceTopic.answer" onclick="change()" value="A" <c:if test='${choiceTopic.answer== "A" }'>checked</c:if>><input name="choiceTopic.optionA" id="optionA" type="text" class="dfinput" value="${choiceTopic.optionA }"/></li>
			      <li><label>选项B</label><input type="radio" name="choiceTopic.answer" onclick="change()" value="B" <c:if test='${choiceTopic.answer== "B" }'>checked</c:if>><input name="choiceTopic.optionB" id="optionB" type="text" class="dfinput" value="${choiceTopic.optionB }"/></li>
			      <li><label>选项C</label><input type="radio" name="choiceTopic.answer" onclick="change()" value="C" <c:if test='${choiceTopic.answer== "C" }'>checked</c:if>><input name="choiceTopic.optionC" id="optionC" type="text" class="dfinput" value="${choiceTopic.optionC }"/></li>
			      <li><label>选项D</label><input type="radio" name="choiceTopic.answer" onclick="change()" value="D" <c:if test='${choiceTopic.answer== "D" }'>checked</c:if>><input name="choiceTopic.optionD" id="optionD" type="text" class="dfinput" value="${choiceTopic.optionD }"/></li>
	  		  </div>
  		  
	  		    <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" value="${choiceTopic.knowledge}"/></li>
			    	<input name="creator" type="hidden" value="${choiceTopic.creator}"/>
			    <li><label>创建人</label><label style="width:50%">${choiceTopic.creator}</label></li>
	  
	   			<li><label>&nbsp;</label><input name="add_btn" type="submit" onclick="b()" class="btn" value="确认保存"/></li>
    		</ul>
   		 </form>
    </div>
	 <script type="text/javascript">
	    function b(){//提交之前去掉select的disabled属性
		    $("#type").attr("disabled","disabled");
		    $("#type").removeAttr("disabled");
	    }
	 </script>
	 
 </body>
 </html>

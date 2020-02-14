<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理-新增试题</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" type="text/css"/>
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
                    "description":{
                        required:true,
                    },
                    "knowledge":{
                        required:true,
                    },
                    "difficulty":{
                        required:true,
                    },
                    "type":{
                        required:true,
                    },
                    "answer":{
                        required:true,
                    },
                    "creator":{
                        required:true,
                    },
                },
                messages:{
                    "description":{
                        required:"必填",
                    },
                    "knowledge":{
                        required: "必填",
                    },
                    "difficulty":{
                        required:"必填",
                    },
                    "type":{
                        required:"必填",
                    },
                    "answer":{
                        required: "必填",
                    },
                    "creator":{
                        required: "必填",
                    }
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
		    if ((str2=="单选题")) {
		    	document.getElementById("single").style.display = 'block';
		   }else if(str2=="填空题"){
		    	document.getElementById("fill").style.display = 'block';
		   } else if(str2=="简答题"){
		    	document.getElementById("simple").style.display = 'block';
		   }
		}
	</script>

</head>

<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">试题管理</a></li>
		    <li><a href="#" style="cursor:default">新增试题</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>新增试题</span></div>
      
	    <ul class="forminfo">
		     <li><label>试题类型</label>
		           <select name="type" id="type" onchange="test(this.value)" class="dfinput">
		                <option >请选择...</option>
		                <option value="单选题">单选题</option>
		                <option value="多选题">多选题</option>
		                <option value="判断题">判断题</option>
		                <option value="填空题">填空题</option>
		                <option value="简答题">简答题</option>
		         </select><i><font color="#FF0000">*必填</font></i>
		     </li>
	     
	     <div id="single" style="display:none">
	     <form action="<%= basePath%>/front/ChoiceTopic_add.action" method="post" name="commonform" id="commonform">
		    <li><label>所属题库</label>
		           <select name="choiceTopic.topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
		               <option >请选择...</option>
		            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
		                <option>${ChoiceTopicBankNameList}</option>
		            </c:forEach>
		         </select><i><font color="#FF0000">*必填</font></i>
		    </li>
		    <li><label>试题难度</label>
		         <select name="choiceTopic.difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput">
		              <option>非常容易</option>
		              <option>比较容易</option>
		              <option selected="selected">常规</option>
		              <option>比较难</option>
		              <option>非常难</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		    </li>
		    <li><label>试题题干</label>
		    	<textarea name="choiceTopic.description" id="description" required lay-verify="required" placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 200px; "></textarea>
		    </li>
	       <li><label>选项设置</label></li>
	      <div style="padding-left: 85px;margin-top:12px">
	       	<label>选项A</label><input type="radio" name="choiceTopic.answer" value="A"><input name="choiceTopic.optionA" id="optionA" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i>
	       </div>
	       <div style="padding-left: 85px;margin-top:12px">
	        <label>选项B</label><input type="radio" name="choiceTopic.answer" value="B"><input name="choiceTopic.optionB" id="optionB" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
	        </div>
	       <div style="padding-left: 85px;margin-top:12px">
	        <label>选项C</label><input type="radio" name="choiceTopic.answer" value="C"><input name="choiceTopic.optionC" id="optionC" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
	        </div>
	       <div style="padding-left: 85px;margin-top:12px">
	        <label>选项D</label><input type="radio" name="choiceTopic.answer" value="D"><input name="choiceTopic.optionD" id="optionD" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
	      </div>
	      <div style="margin-top:12px">
		    <li><label>知识点</label><input name="choiceTopic.knowledge" type="text"  class="dfinput" /></li>
	      	<input name="choiceTopic.creator" id="creator" type="hidden" value="${userName}"/>
  		  </div>
	   		<ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input type="submit" class="btn"  value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			       <label>&nbsp;</label><a href="<%= basePath%>/front/ChoiceTopic_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			      </li>
			</ul>
  		  </form>
	    </div>
	    
	   <div id="fill" style="display:none">
	    <form action="<%= basePath%>/front/FillTopic_add.action" method="post" name="commonform" id="commonform">
	    	 <li><label>所属题库</label>
	           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
	               <option >请选择...</option>
		            <c:forEach items="${session.FillTopicBankNameList}" var="FillTopicBankNameList">
		                <option>${FillTopicBankNameList}</option>
		            </c:forEach>
	           </select><i><font color="#FF0000">*必填</font></i>
	         </li>
		     <li><label>试题难度</label>
		         <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput">
		              <option>非常容易</option>
		              <option>比较容易</option>
		              <option selected="selected">常规</option>
		              <option>比较难</option>
		              <option>非常难</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		     </li>
		    <li><label>试题题干</label>
		    	<textarea name="description" id="description" required lay-verify="required" placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 200px; "></textarea>
		    </li>
		    <li><label>答案设置</label>
		     <input name="answer" id="answer" type="text" class="dfinput" />
		    </li>
		     <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" /></li>
	      	<input name="creator" id="creator" type="hidden" value="${userName}"/>
	      	
	   		<ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input type="submit" class="btn"  value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			       <label>&nbsp;</label><a href="<%= basePath%>/front/FillTopic_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			      </li>
			</ul>
	      	</form>
	     </div>
	    
	    <div id="simple" style="display:none">
	    <form action="<%= basePath%>/front/Topic_add.action" method="post" name="commonform" id="commonform">
	    	<li><label>所属题库</label>
	           <select name="topic.topicBankName" id="topic.topicBankName" onchange="selectValue(this)"  class="dfinput">
	               <option >请选择...</option>
		            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
		                <option>${TopicBankNameList}</option>
		            </c:forEach>
	          </select><i><font color="#FF0000">*必填</font></i>
	        </li>
	     
		     <li><label>试题难度</label>
		         <select name="topic.difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput">
		              <option>非常容易</option>
		              <option>比较容易</option>
		              <option selected="selected">常规</option>
		              <option>比较难</option>
		              <option>非常难</option>
		        </select><i><font color="#FF0000">*必填</font></i>
		     </li>
		     
		    <li><label>试题题干</label>
		    	<textarea name="topic.description" id="description" required lay-verify="required" placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 200px; "></textarea>
		    </li>
	    
		    <li><label>答案设置</label>
		     	<textarea name="topic.answer" id="topic.answer"  placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 100px; "></textarea>
		    </li>
		     <li><label>知识点</label><input name="topic.knowledge" type="text"  class="dfinput" /></li>
	      	<input name="topic.creator" id="creator" type="hidden" value="${userName}"/>
	      	
	   		<ul class="forminfo">
			     <li>
			       <label>&nbsp;</label><input type="submit" class="btn"  value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			       <label>&nbsp;</label><a href="<%= basePath%>/front/Topic_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			      </li>
			</ul>
	      	</form>
	    </div>
	    
  </div>
  
  <script language="javascript"> //填空题
		function addrows(){ 
			var len = optionlist.rows.length; //得到table的行数 
			var obj = optionlist.insertRow(len);//在最后一行插入 
			/**插入第一列**/ 
			obj.insertCell(0).innerHTML="<li>填空"+ (len+1)+"：<input type=text name=answer"+(len+1)+" size=20 class=dfinput ></li>"; 
			 alert($("input:text").length);
		} 
		function deleterow(){ 
			var len = optionlist.rows.length; 
			if(len <= 1) { 
				alert("至少要有一个填空"); 
			}else { 
				optionlist.deleteRow(len-1);//删除最后一项 
			} 
		} 
		function getOptionCount(){ 
			return optionlist.rows.length; 
		} 
	</script> 
</body>

</html>

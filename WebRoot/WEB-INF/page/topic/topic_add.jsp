<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理-新增</title>
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
                    "topicName":{
                        required:true,
                        
                    },
                    "pointName":{
                        required:true,
                        
                        
                    },
                    "topicDegree":{
                        required:true,
                        
                    },
                    "topicTypes":{
                        required:true,
                       
                       
                    },
                    "topicScore":{
                        required:true,
                        digits:true,
                       
                    },
                    "topicAnswer":{
                        required:true,
                        
                    },
                    "courseName":{
                        required:true,
                        
                    },
                    "teacherName":{
                        required:true,
                    },
                },
                messages:{
                    "topicName":{
                        required:"必填",
                        
                    },
                    "pointName":{
                        required: "必填",
                       
                    },
                    "topicDegree":{
                        required:"必填",
                        
                    },
                    "topicTypes":{
                        required:"必填",
                       
                    },
                   
                    "topicScore":{
                        required: "必填",
                        digits:"请输入整数",
                       
                    },
                    "topicAnswer":{
                        required: "必填",
                    },
                    "courseName":{
                        required: "必填",
                    },
                    "teacherName":{
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
		    document.getElementById("a").style.display = 'none';
		    document.getElementById("a1").style.display = 'none';
		    document.getElementById("b").style.display = 'none';
		    document.getElementById("c").style.display = 'none';
		    document.getElementById("d").style.display = 'none';
		    if ((str2=="单选题")) {
		    document.getElementById("a").style.display = 'block';
		   }else if(str2=="多选题"){
		    document.getElementById("a1").style.display = 'block';
		   } else if(str2=="问答题"){
		    document.getElementById("b").style.display = 'block';
		   }else if(str2=="判断题"){
		    document.getElementById("c").style.display = 'block';
		   }else if(str2=="填空题"){
		    document.getElementById("d").style.display = 'block';
		   }
		}
	</script>

	<script language="javascript"> //填空题
		function addrows(){ 
		var len = optionlist.rows.length; //得到table的行数 
		var obj = optionlist.insertRow(len);//在最后一行插入 
		/**插入第一列**/ 
		obj.insertCell(0).innerHTML="<li>填空"+ (len+1)+"：<input type=text name=topicAnswer"+(len+1)+" size=20 class=dfinput ></li>"; 
		 alert($("input:text").length);
		} 
		function deleterow(){ 
		var len = optionlist.rows.length; 
		if(len <= 1) { 
		alert("至少要有一个填空"); 
		} 
		else { 
		optionlist.deleteRow(len-1);//删除最后一项 
		} 
		} 
		function getOptionCount(){ 
		return optionlist.rows.length; 
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
    <form action="<%= basePath%>/front/Topic_add.action" method="post" id="commonform">
    <ul class="forminfo">
     <li><label>试题类型</label>
           <select name="topicTypes" id="topicTypes" onchange="test(this.value)" class="dfinput">
                <option >请选择...</option>
                <option value="单选题">单选题</option>
                <option value="多选题">多选题</option>
                <option value="判断题">判断题</option>
                <option value="填空题">填空题</option>
                <option value="问答题">问答题</option>
         </select><i><font color="#FF0000">*必填</font></i>
     </li>
     
      <li><label>所属题库</label>
           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
               <option >请选择...</option>
            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
                <option>${TopicBankNameList}</option>
            </c:forEach>
         </select><i><font color="#FF0000">*必填</font></i>
     </li>
     
     <li><label>试题难度</label>
         <select name="topicDegree" id="topicDegree" onchange="selectValue(this)"  class="dfinput">
              <option>非常容易</option>
              <option>比较容易</option>
              <option selected="selected">常规</option>
              <option>比较难</option>
              <option>非常难</option>
        </select><i><font color="#FF0000">*必填</font></i>
     </li>
     
    <li><label>试题题干</label>
    	<textarea name="topicName" id="topicName" required lay-verify="required" placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 200px; "></textarea>
    </li>
    
    <div id="a" style="display:none">
      <li><label>答案设置</label></li>
      <div style="padding-left: 85px;margin-top:12px">
       	<label>选项A</label><input type="radio" name="topicAnswer0" value="A"><input name="optionA" id="optionA" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i>
       </div>
       <div style="padding-left: 85px;margin-top:12px">
        <label>选项B</label><input type="radio" name="topicAnswer0" value="B"><input name="optionB" id="optionB" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
        </div>
       <div style="padding-left: 85px;margin-top:12px">
        <label>选项C</label><input type="radio" name="topicAnswer0" value="C"><input name="optionC" id="optionC" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
        </div>
       <div style="padding-left: 85px;margin-top:12px">
        <label>选项D</label><input type="radio" name="topicAnswer0" value="D"><input name="optionD" id="optionD" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
      </div>
    </div>
    
    <div id="a1" style="display:none">
	     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	     <input type="button" id="bt1" value="增加选项" class="btn layui-btn layui-btn-sm" onClick="add();"> 
	     <input type="button" id="bt2" value="删除选项" class="btn layui-btn layui-btn-sm" onClick="delete1();"> 
	     <div style="margin-top:12px">
		     <table id="optionlist0"> 
			      <li><label>选项1</label><input type="checkbox" name="topicAnswer1" value="A"><input name="option1" id="option1" type="text" class="dfinput" /></li>
			      <li><label>选项2</label><input type="checkbox" name="topicAnswer1" value="B"><input name="option2" id="option2" type="text" class="dfinput" /></li>
			      <li><label>选项3</label><input type="checkbox" name="topicAnswer1" value="C"><input name="option3" id="option3" type="text" class="dfinput" /></li>
			      <li><label>选项4</label><input type="checkbox" name="topicAnswer1" value="D"><input name="option4" id="option4" type="text" class="dfinput" /></li>
		     </table> 
	     </div>
    </div>
    
    <div id="b" style="display:none">
	    <li><label>答案设置</label>
	     	<textarea name="topicAnswer2" id="topicAnswer2"  placeholder="请输入" class="layui-textarea" rows="3" cols="20" style="width: 800px; height: 100px; "></textarea>
	    </li>
    </div>
    
    <div id="c" style="display:none">
	    <li><label>答案设置</label>
	    <input type="radio" name="topicAnswer" value="正确" >正确
	    <br>
	    <input type="radio" name="topicAnswer" value="错误">错误
	    </li>
    </div>
    
    <div id="d" style="display:none">
	    <li><label>答案设置</label>
	    <!-- <input type="button" id="bt1" value="增加填空" class="btn layui-btn layui-btn-sm" onClick="addrows();"> 
	     <input type="button" id="bt2" value="删除填空" class="btn layui-btn layui-btn-sm"onClick="deleterow();">  --> 
	     <input name="topicAnswer3" type="text"  class="dfinput" />
	   </li>
   </div>
   
   <div style="margin-top:12px">
	    <li><label>知识点</label><input name="pointName" type="text"  class="dfinput" /></li>
	    <li><label>课程名称</label><input name="courseName" id="courseName" type="textarea" class="dfinput" /><i><font color="#FF0000">*必填</font></i></li>
     	<%String userName=(String)request.getSession().getAttribute("userName"); %>
      	<input name="teacherName" type="hidden" value="${userName}"/>
   </div>
   <ul class="forminfo">
     <li>
       <label>&nbsp;</label><input name="" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <label>&nbsp;</label><a href="<%= basePath%>/front/Topic_list.action"><input name="" type="button" class="btn" value="取消"/></a>
      </li>
   </ul>
   </form>
    
  </div>
	<script language="javascript"> //多选题
		function add(){ 
		var len = optionlist0.rows.length; //得到table的行数 
		var obj = optionlist0.insertRow(len);//在最后一行插入
		/**插入第一列**/ 
		obj.insertCell(0).innerHTML="<li><label>选项"+ (len+5)+"</label><input type=checkbox name=topicAnswer value="+(len+5)+"><input type=text name=option"+(len+5)+" size=28 class=dfinput></li>"; 
		
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

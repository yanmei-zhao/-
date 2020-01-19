<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题编辑</title>
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
                    "topicId":{
                        required:true,
                        digits:true,
                    },
                    "topicName":{
                        required:true,
                       
                    },
                    "pointName":{
                        required:true,
                      
                    },
                    "topicDegree":{
                    	required:true
                    },
                    "topicTypes":{
                        required:true
                    
              },
                "topicScore":{
                    required:true,
                    digits:true,
                    
                }
            },
            "topicAnswer":{
                required:true,
              
            },
            "courseName":{
                required:true,
              
            },
            "courseName":{
                required:true,
                
        
             },
                messages:{
                    "topicId":{
                        required:"必填",
                        
                    },
                    "topicName":{
                        required:"必填",
                       
                    },
                    "pointName":{
                        required: "必填",
                       
                 
                    },
                    "topicDegree":{
                        required: "必填",
                  
                    },
                    "topicTypes":{
                        required: "必填",
                    
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
                    },
                  
                  }
            });    
        });
        </script>
        
 <script type="text/javascript">
 $(function() {
	  var topicTypes="${topic.topicTypes}";
	  $("select[name='topicTypes']").find("option[value='"+topicTypes+"']").attr("selected",true);
	  var topicDegree="${topic.topicDegree}";
	  $("select[name='topicDegree']").find("option[value='"+topicDegree+"']").attr("selected",true);
	  var topicBankName="${topic.topicBankName}";
	  $("select[name='topicBankName']").find("option[value='"+topicBankName+"']").attr("selected",true);
 //设置按题目类型更改页面
   var str2="${topic.topicTypes}";
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

    var boxObj = $("input:checkbox[name='topicAnswer']");  //获取所有的复选框
    var expresslist = '${topic.topicAnswer}'; //用el表达式获取在控制层存放的复选框的值为字符串类型
    var express = expresslist.split(", "); //去掉它们之间的分割符“，” 
    for(i=0;i<boxObj.length;i++){
       for(j=0;j<express.length;j++){ 
           if(boxObj[i].value==express[j])  //如果值与修改前的值相等
           {
               boxObj[i].checked= true;
               break;
           }
       }
    }          
    
   })
</script>
	 <script language="javascript"> 
	function addrows(){ 
	var len = optionlist.rows.length; //得到table的行数 
	var obj = optionlist.insertRow(len);//在最后一行插入 
	/**插入第一列**/ 
	obj.insertCell(0).innerHTML="<li>填空"+ (len+1)+"：<input type=text name=topicAnswer"+(len+1)+" size=20 class=dfinput ></li>"; 
	
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
<body >

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
    <form action="<%= basePath%>/front/Topic_update.action" method="post" id="commonform">
     
    <ul class="forminfo">
    <input name="topic.topicId" type="hidden" value="${topic.topicId}"/>
    <li><label>试题编号</label><label style="width:50%">${topic.topicId}</label></li>
     <li><label>试题类型</label>
           <select name="topicTypes" id="topicTypes" onchange="selectValue(this)" class="dfinput" disabled="disabled">
                <option value="单选题" >单选题</option>
                <option value="多选题" >多选题</option>
                <option value="判断题" >判断题</option>
                <option value="填空题" >填空题</option>
                <option value="问答题" >问答题</option>
         </select>
     </li>
      <li><label>所属题库</label>
           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
            <c:forEach items="${session.topicBankNameList}" var="topicBankNameList">
                <option value="${topicBankNameList}">${topicBankNameList}</option>
            </c:forEach>
         </select>
     </li>
      <li><label>试题难度</label>
           <select name="topicDegree" id="topicDegree" onchange="selectValue(this)"  class="dfinput">
                <option value="非常容易">非常容易</option>
                <option value="比较容易" >比较容易</option>
                <option value="常规">常规</option>
                <option value="比较难">比较难</option>
                <option value="非常难">非常难</option>
         </select>
     </li>
     <li><label>试题题干</label>
    <textarea name="topic.topicName" id="topicName" rows="3" cols="20" style="width: 800px; height: 200px;">
    ${topic.topicName}
    </textarea>
    </li>
    
    <div id="a" style="display:none">
      <li><label>选项A</label><input type="radio" name="topicAnswer0" onclick="change()" value="A" <c:if test='${topic.topicAnswer0== "A" }'>checked</c:if>><input name="optionA" id="optionA" type="text" class="dfinput" value="${topic.optionA }"/></li>
      <li><label>选项B</label><input type="radio" name="topicAnswer0" onclick="change()" value="B" <c:if test='${topic.topicAnswer0== "B" }'>checked</c:if>><input name="optionB" id="optionB" type="text" class="dfinput" value="${topic.optionB }"/></li>
      <li><label>选项C</label><input type="radio" name="topicAnswer0" onclick="change()" value="C" <c:if test='${topic.topicAnswer0== "C" }'>checked</c:if>><input name="optionC" id="optionC" type="text" class="dfinput" value="${topic.optionC }"/></li>
      <li><label>选项D</label><input type="radio" name="topicAnswer0" onclick="change()" value="D" <c:if test='${topic.topicAnswer0== "D" }'>checked</c:if>><input name="optionD" id="optionD" type="text" class="dfinput" value="${topic.optionD }"/></li>
    </div>
    
   <div id="a1" style="display:none">
     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
     <input type="button" id="bt1" value="增加选项" onClick="add();"> 
     <input type="button" id="bt2" value="删除选项" onClick="delete1();"> 
     <p>
     <table id="optionlist0"> 
      <li><label>选项1</label><input type="checkbox" name="topicAnswer1" value="A" ><input name="option1" id="option1" type="text" class="dfinput" value="${topic.option1 }"/></li>
      <li><label>选项2</label><input type="checkbox" name="topicAnswer1" value="B" ><input name="option2" id="option2" type="text" class="dfinput" value="${topic.option2 }"/></li>
      <li><label>选项3</label><input type="checkbox" name="topicAnswer1" value="C" ><input name="option3" id="option3" type="text" class="dfinput" value="${topic.option3 }"/></li>
      <li><label>选项4</label><input type="checkbox" name="topicAnswer1" value="D" ><input name="option4" id="option4" type="text" class="dfinput" value="${topic.option4 }"/></li>
     </table> 
    </div>
    
    <div id="b" style="display:none">
    <li><label>答案设置</label>
    <textarea name="topicAnswer2" id="topicAnswer2" rows="3" cols="20" style="width: 800px; height: 100px; ">
      ${topic.topicAnswer2}
    </textarea>
   </li></div>
    
    <div id="c" style="display:none">
    <li><label>答案设置</label>
    <input type="radio" name="topicAnswer" value="正确" <c:if test='${topic.topicAnswer== "正确" }'>checked</c:if>>正确
    <br>
    <input type="radio" name="topicAnswer" value="错误" <c:if test='${topic.topicAnswer== "错误" }'>checked</c:if>>错误
    </li>
    </div>
    
     <div id="d" style="display:none">
    <li><label>答案设置</label>
     <input name="topicAnswer3" type="text"  class="dfinput" value="${topic.topicAnswer3}"/>
    </li>
    </div>
    
    <li><label>知识点</label><input name="topic.pointName" type="text"  class="dfinput" value="${topic.pointName}"/></li>
    <li><label>课程名称</label><input name="topic.courseName" type="text"  class="dfinput" value="${topic.courseName}"/></li>
    <input name="topic.teacherName" type="hidden" value="${topic.teacherName}"/>
    <li><label>创建人</label><label style="width:50%">${topic.teacherName}</label></li>
   
    <li><label>&nbsp;</label><input name="add_btn" type="submit" onclick="b()" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>

<script type="text/javascript">
    function b(){//提交之前去掉select的disabled属性
    $("#topicTypes").attr("disabled","disabled");
    $("#topicTypes").removeAttr("disabled");
    }
 </script>
 <script language="javascript"> 
function add(){ //多选题
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
function change(){
	 $('input:radio[name="topicAnswer"]').removeAttr('checked');
    $("input[name='topicAnswer']:checked").val();
}
</script> 
</body>

</html>

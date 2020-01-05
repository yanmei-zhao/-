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
                  },
            });    
        });
        </script>
        
 <script type="text/javascript">
 $(function() {
	  var type="${fillTopic.type}";
	  $("select[name='type']").find("option[value='"+type+"']").attr("selected",true);
	  var difficulty="${fillTopic.difficulty}";
	  $("select[name='difficulty']").find("option[value='"+difficulty+"']").attr("selected",true);
	  var topicBankName="${fillTopic.topicBankName}";
	  $("select[name='topicBankName']").find("option[value='"+topicBankName+"']").attr("selected",true);

    var boxObj = $("input:checkbox[name='answer']");  //获取所有的复选框
    var expresslist = '${answer}'; //用el表达式获取在控制层存放的复选框的值为字符串类型
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
    <form action="<%= basePath%>/front/FillTopic_update.action" method="post" id="commonform">
     
    <ul class="forminfo">
    <input name="id" type="hidden" value="${id}"/>
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
            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
                <option value="${TopicBankNameList}">${TopicBankNameList}</option>
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
    <textarea name="description" id="description" rows="3" cols="20" style="width: 800px; height: 200px;">
   		 ${fillTopic.description}
    </textarea>
    </li>
  
     <div id="fill">
	    <li><label>答案设置</label>
	     <input name="answer" type="text"  class="dfinput" value="${fillTopic.answer}"/>
	    </li>
    </div>
    
    <li><label>知识点</label><input name="knowledge" type="text"  class="dfinput" value="${fillTopic.knowledge}"/></li>
    <input name="creator" type="hidden" value="${fillTopic.creator}"/>
    <li><label>创建人</label><label style="width:50%">${fillTopic.creator}</label></li>
   
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
	 <script language="javascript"> 
		function add(){ //多选题
			var len = optionlist0.rows.length; //得到table的行数 
			var obj = optionlist0.insertRow(len);//在最后一行插入 
			/**插入第一列**/ 
			obj.insertCell(0).innerHTML="<li><label>选项"+ (len+5)+"</label><input type=checkbox name=answer value="+(len+5)+"><input type=text name=option"+(len+5)+" size=28 class=dfinput></li>"; 
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
			 $('input:radio[name="answer"]').removeAttr('checked');
		    $("input[name='answer']:checked").val();
		}
	</script> 
</body>

</html>

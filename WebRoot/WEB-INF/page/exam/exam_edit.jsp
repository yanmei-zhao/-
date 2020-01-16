<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改角色权限信息</title>
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
                    "examId":{
                        required:true,
                        digits:true,
                    },
                    "examName":{
                        required:true,
                    },
                    "examStart":{
                        required:true,
                    },
                    "examState":{
                        required:true,
                    },
                    "examEnd":{
                        required:true,
                    },
                    "examDuration":{
                        required:true,
                        digits:true,
                    },
                    "totalPeople":{
                        required:true,
                        digits:true,
                    },
                    "className":{
                        required:true,
                        digits:true,
                    },
                    "teacherName":{
                        required:true,
                    },
                },
                messages:{
                    "examName":{
                        required:"必填",
                    },
                    "examStart":{
                        required: "必填",
                    },
                    "examState":{
                        required:"必填",
                    },
                    "examEnd":{
                        required:"必填",
                    },
                    "examDuration":{
                        required: "必填",
                    },
                    "totalPeople":{
                        required:"必填",
                    },
                    "className":{
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
     var examName="${exam.examName}";
	  $("select[name='examName']").find("option[value='"+examName+"']").attr("selected",true);
	  var examState="${exam.examState}";
	  $("select[name='examState']").find("option[value='"+examState+"']").attr("selected",true);
	  var className="${exam.className}";
	  $("select[name='className']").find("option[value='"+className+"']").attr("selected",true);
 });
 </script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">考试管理</a></li>
		    <li><a href="#">修改考试信息</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改考试信息</span></div>
	    <form action="<%= basePath%>/front/Exam_update.action" method="post" id="commonform">    
		    <ul class="forminfo">
			    <input name="exam.examId" type="hidden" value="${exam.examId}"/>
			    <!--<li><label>试卷名称</label><label style="width:50%">${exam.examId}</label></li>  -->
			     <li><label>试卷名称</label>
			           <select name="examName" id="examName" onchange="selectValue(this)"  class="dfinput">
				            <c:forEach items="${session.examNameList}" var="examNameList">
				                <option value="${examNameList}">${examNameList}</option>
				            </c:forEach>
			         </select>
			     </li>
			     
			    <li><label>开始时间</label><input name="exam.examStart" type="text"  class="dfinput" value="${exam.examStart}"/><i><font color="#FF0000">*必填</font></i></li>
			  
			    <li><label>状态</label>
			           <select name="examState" id="examState" onchange="selectValue(this)"  class="dfinput">
			                <option value="未发布">未发布</option>
			                <option value="待审核" >待审核</option>
			                <option value="已发布">已发布</option>
			         </select><i><font color="#FF0000">*必填</font></i>
			     </li>
			     
			    <li><label>结束时间</label><input name="exam.examEnd" type="text"  class="dfinput" value="${exam.examEnd}"/><i><font color="#FF0000">*必填</font></i></li>
			    <li><label>时长</label><input name="exam.examDuration" type="text"  class="dfinput" value="${exam.examDuration}"/><i><font color="#FF0000">*必填</font></i></li>
			    <li><label>总人数</label><input name="exam.totalPeople" type="text"  class="dfinput" value="${exam.totalPeople}"/><i><font color="#FF0000">*必填</font></i></li>
			    <li><label>目标班级</label>
			        <select name="exam.className" id="exam.className" onchange="selectValue(this)"  class="dfinput">  
			            <c:forEach items="${session.classNameList}" var="classNameList">
			                <option>${classNameList}</option>
			            </c:forEach>
			        </select>
		        </li>
			    <input name="exam.teacherName" type="hidden" value="${exam.teacherName}"/>
			    <li><label>创建人</label><label style="width:50%">${exam.teacherName}</label></li>
			    
			    <li><label>&nbsp;</label><input name="add_btn" type="submit" onclick="b()" class="btn" value="确认保存"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <label>&nbsp;</label><a href="<%= basePath%>/front/Exam_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			    </li>
			    
		    </ul>
	    </form>
    </div>
</body>

</html>

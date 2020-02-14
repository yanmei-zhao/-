<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考试管理-新增考试</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layDate-v5.0.9/laydate/laydate.js" charset=utf-8"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
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
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#examEnd' //指定元素
	    ,type:'datetime'
	  });
	  laydate.render({
	  	elem: '#examStart' //指定元素
	    ,type:'datetime'
	  });
	</script>
<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    	<li><a href="#">首页</a></li>
		    <li><a href="#" style="cursor:default">考试管理</a></li>
		    <li><a href="#" style="cursor:default">考试信息添加</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>考试信息添加</span></div>
	    <form action="<%= basePath%>/front/Exam_add.action" method="post" id="commonform">
		    <ul class="forminfo">
			     <li><label>选择试卷</label>
			           <select name="examName" id="examName" onchange="selectValue(this)"  class="dfinput">
			               <option >请选择...</option>
			            <c:forEach items="${session.examNameList}" var="examNameList">
			                <option>${examNameList}</option>
			            </c:forEach>
			         </select><i><font color="#FF0000">*必填</font></i>
			     </li>
			    <li><label>开始时间</label><input name="examStart" id="examStart" type="text" class="dfinput" lay-verify="required" /></li>
			    <li><label>结束时间</label><input name="examEnd" id="examEnd" type="text" class="dfinput"  lay-verify="required" /></li> 
			    <li><label>状态</label>
			           <select name="examState" id="examState" onchange="selectValue(this)"  class="dfinput">
			                <option >未发布</option>
			                <option selected="selected">待审核</option>
			                <option>已发布</option>
			         </select><i><font color="#FF0000">*必填</font></i>
			     </li> 
			    <li><label>考试时长</label><input name="examDuration" id="examDuration" type="text" class="dfinput"  required lay-verify="required" />&nbsp;&nbsp;分钟</li>
			    <li><label>总人数</label><input name="totalPeople" id="totalPeople" type="text" class="dfinput" /></li>
			    <li>
			    	<label>目标班级</label><input type="button" value="选择班级" onclick="tm_showBranches()" style="margin-top:5px;"/>
			    	<input type="button" value="清空" onclick="tm_clearBracnhes()" style="margin-top:5px;"/>
			    	<div id="div_link_branch"></div>
			    </li>
			<!--    <li><label>目标班级</label>
			        <select name="className" id="className" onchange="selectValue(this)"  class="dfinput">  
			        <option >请选择...</option>
			            <c:forEach items="${session.classNameList}" var="classNameList">
			                <option>${classNameList}</option>
			            </c:forEach>
			        </select>
			     </li>   --> 
			    
			     <%String userName=(String)request.getSession().getAttribute("userName"); %>
			      <input name="teacherName" type="hidden" value="${userName}"/>
		    </ul>
		    
		    <ul class="forminfo">
			    <li>
				    <label>&nbsp;</label><input name="" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <label>&nbsp;</label><a href="<%= basePath%>/front/Exam_list.action"><input name="" type="button" class="btn" value="取消"/></a>
			    </li>
		    </ul>
	    </form>
    </div>
    
    <script type="text/javascript">

		$(document).ready(function() {
			//jQuery('#form_paper_add').validationEngine();
		});

		//===============考生选择器===============
		function tm_showUsers(){
			layer.open({
			  type: 2,
			  title: '选择用户',
			  shadeClose: true,
			  maxmin:true,
			  shade: 0.8,
			  area: ['80%', '80%'],
			  content: 'http://demo.tomexam.com/system/user/list-query.thtml'
			}); 
		}
		
		//清空所有考生
		function tm_clearUsers(){
			if(window.confirm('确定要清空吗？')){
				$("#div_link_user").empty();
			}
		}

		//删除一个考生
		function tm_removeUser(obj){
			$(obj).parent().remove();
		}

		//批量导入设置考生
		function tm_importUsers(){
			layer.open({
			  type: 2,
			  title: '批量设置',
			  shadeClose: true,
			  maxmin:true,
			  shade: 0.8,
			  area: ['600px', '450px'],
			  content: 'http://demo.tomexam.com/system/paper/import-user-settings.thtml'
			}); 
		}


		//===============班级选择器===============
		function tm_showBranches(){
    		layer.open({
		      type: 2,
		      title: '选择班级',
		      maxmin:true,
		      area: ['900px', '550px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Group_list.action',
		    });
    	}
	
		//清空所有班级
		function tm_clearBracnhes(){
			if(window.confirm('确定要清空吗？')){
				$("#div_link_branch").empty();
			}
		}

		//删除一个班级
		function tm_removeBranch(obj){
			$(obj).parent().remove();
		}


		function tm_submit(){
			var formcheck = $("#form_paper_add").validationEngine('validate');
			if(formcheck){
				try{
					var t_p_starttime = $("input[name='p_starttime']").val();
					var t_p_endtime = $("input[name='p_endtime']").val();

					var v_starttime = baseutil.parseDate(t_p_starttime);
					var v_endtime = baseutil.parseDate(t_p_endtime);

					if(v_starttime > v_endtime){
						layer.alert("开始时间不能晚于结束时间。");
						return;
					}

					var v_milliseconds = v_endtime.getTime() - v_starttime.getTime();
					var v_max_minutes = parseInt(v_milliseconds / (1000 * 60));
					var v_duration = parseInt($("input[name='p_duration']").val());

					if(v_duration > v_max_minutes){
						layer.alert("设定的考试时长（"+v_duration+"分钟）超出了试卷考试时间的范围，请修改后再提交。");
						return;
					}
				}catch(e){
				
				}

				$("#form_paper_add").submit();
			}
		}

    </script>
</body>

</html>

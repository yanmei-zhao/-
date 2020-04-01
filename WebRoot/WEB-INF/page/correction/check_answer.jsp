<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.gxuwz.Market.business.entity.*" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批改试卷页</title>
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-admin-theme.css">
<link href="<%=path %>/css/self.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path %>/css/process.css">
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<script type="text/javascript">
	/*
	 *_contextPath:上下文路径
	 *_modulePath: 模块路径
	 */
	var  _contextPath="<%=path%>";
	var  _modulePath=_contextPath+"/sys/";
	$(document).ready(function(){
	  $(".clicks").click(function(){
	   _open(_modulePath+"textures_open.action?view=add");
	  });
	});
</script>
<script type="text/javascript">
	window.onload = function(){
		setInterval(function (){
				var remainTime=document.getElementById("remainTime").getElementsByTagName("span");
				var examStart='${session.exam.examStart}';//获取后台存的值
				var examEnd='${session.exam.examEnd}';
				var now = new Date();//当前时间
				var time2 = Date.parse(examEnd);//转换成时间戳
				var now1 = Date.parse(now);//转换成时间戳
				var num =time2- now1;////最后时间-当前时间
				if(num>0){
					var minute=parseInt(num/(60*1000));//转换成秒
					 num=num%(60*1000);
				     var seconde=parseInt(num/1000);
				     remainTime[0].innerHTML=minute;
					 remainTime[1].innerHTML=seconde;
				}else{
					   document.getElementById("form").submit();
				}
			}, 100)
		}
</script>
<script type="text/javascript">
	//交卷提示
	$(document).ready(function(){
		var id;
		$(".tablelinkdelete").click(function(){
			id = $(this).attr("id");
		  	$(".tip").fadeIn(200);
		});
	  	$(".tiptop a").click(function(){
	  		$(".tip").fadeOut(200);
		});
		$(".sure").click(function(){
			$(".tip").fadeOut(100);
			document.getElementById("form").submit();
		});
	  	$(".cancel").click(function(){
	  		$(".tip").fadeOut(100);
		});	
	});
</script>
  </head>
  	
  <body class="bootstrap-admin-with-small-navbar">
  		<form id="form" class="form-horizontal" action="<%= basePath%>/front/StudentExamScore_update.action" method="post">
		<!-- content -->
            <div class="col-md-10">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">试卷信息</div>
                            </div>
                            <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                               <!--  <form class="form-horizontal" action="#" method="post">   -->
                                    <div class="col-lg-12 form-group" style="margin-left:100px">
                                        <label class="col-lg-6 control-label" for="query_ano"><h2>${session.exam.examName}<h2></label>
                                    </div>
                                    <div class="col-lg-12 form-group" style="margin-left:50px">
                                        <label class="col-lg-6 control-label" for="query_ano"><i>(卷面总分:${session.testpaper.totalScore}分)</i></label>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                      <c:set var="index" value="1"/><!--统计题目 -->
                            <!---在此插入信息-->
                            <s:if test="result.data!=null">
                            	<!--选择题 -->
	                            <s:iterator value="result.data" id="id">    
	                              <div class="col-md-12">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[2]"/>?(单选题)【每题<s:property value="#id[10]"/>分】</div>
	                         			      	 	 <input name="choiceTopicId" type="hidden" value='<s:property value="#id[3]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													   A. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    B. <s:property value="#id[5]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    C. <s:property value="#id[6]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    D. <s:property value="#id[7]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                           			 	 <input type="hidden" name="studentId" value="<s:property value="#id[8]"/>"/>
	                           			 	  <input type="hidden" name="examId" value="<s:property value="#id[9]"/>"/>
	                           			 	<div class="bootstrap-admin-panel-content">
	                            				<div style="margin-right:15px;float:left">学生答案：<s:property value="#id[0]"/></div>
	                            				<div style="color:#FF0033">正确答案：<s:property value="#id[1]"/></div>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>
                         
                         	 <s:if test="result4.data!=null">
                            	<!--多选题 -->
	                            <s:iterator value="result4.data" id="id">    
	                              <div class="col-md-12">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[2]"/>?(多选题)【每题<s:property value="#id[10]"/>分】</div>
	                         			      	 	 <input name="multipleTopicId" type="hidden" value='<s:property value="#id[6]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													   A. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    B. <s:property value="#id[5]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    C. <s:property value="#id[6]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    D. <s:property value="#id[7]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                       		 			<input type="hidden" name="studentId" value="<s:property value="#id[8]"/>"/>
	                           			 	<input type="hidden" name="examId" value="<s:property value="#id[9]"/>"/>
	                           			 	<div class="bootstrap-admin-panel-content">
	                            				<div style="margin-right:15px;float:left">学生答案：<s:property value="#id[0]"/></div>
	                            				<div style="color:#FF0033">正确答案：<s:property value="#id[1]"/></div>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>
                         
                          <s:if test="result3.data!=null">
                            	<!-- 判断题 -->
                              <s:iterator value="result3.data" var="id">    
                              <div class="col-md-12">
                        		  <div class="panel panel-default">
                       			    	<div class="panel-heading">
                        			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[2]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[4]"/>分】</div>
                        			      	 <c:set var="index" value="${index+1}"/><!--统计题目 -->
                       				  	</div>
                            			<div class="bootstrap-admin-panel-content">
		                                	<div style="margin-right:20px;float:left">学生答案：<s:property value="#id[0]"/></div>
                            				<div style="color:#FF0033">正确答案：<s:property value="#id[1]"/></div>
                           			 	</div>
                       		 		</div>
                 			   </div>
                          	 </s:iterator>
                         </s:if>
                            
                             <s:if test="result1.data!=null">
                            	<!--填空题 -->
	                            <s:iterator value="result1.data" id="id">    
	                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index}.<s:property value="#id[2]"/>?(填空题)【每题<s:property value="#id[4]"/>分】</div>
                         			      	 	<input name="fillTopicId" type="hidden" value='<s:property value="#id[3]"/>'/>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
	                            				<div style="margin-right:20px;float:left">学生答案：<s:property value="#id[0]"/></div>
	                            				<div style="color:#FF0033">正确答案：<s:property value="#id[1]"/></div>
	                           			 	</div>
                       		 		   </div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>   
                            
                         <s:if test="result2.data!=null">
                           	<!--简答题 -->
                            <s:iterator value="result2.data" id="id">    
                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[2]"/>?(简答题)【每题<s:property value="#id[4]"/>分】</div>
                         			      	 	 <input name="topicId" type="hidden" value='<s:property value="#id[3]"/>'/>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
                            				<div class="bootstrap-admin-panel-content">
	                            				<p>学生答案：<s:property value="#id[0]"/></p>
	                            				<p style="color:#FF0033">正确答案：<s:property value="#id[1]"/></p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;得分：<input type="text" name="score_<s:property value="#id[3]"/>"> 
	                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                       </s:if>   
                </div>
            </div>  
            <div id="score">
	            <div>
					<input type="button" id="putAnswer" style="margin-bottom:10px" class="tablelinkdelete btn btn-primary" onclick="" value="提交成绩"/>
				</div>
			</div>  
    </form>
                
  	<!-- 分页菜单组件--------------------------结束 -->
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
	<!-- 交卷操作提示框------>
	<script type="text/javascript">
		//交卷提示
		$(document).ready(function(){
			var id;
			$(".tablelinkdelete").click(function(){
				id = $(this).attr("id");
				if(window.confirm("是否确定提交成绩，是请点击确定，否则点击取消")){
					document.getElementById("form").submit();
				} 
			});
		});
	</script>
  </body>
</html>

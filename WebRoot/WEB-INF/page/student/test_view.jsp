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
<title>试卷页</title>
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-admin-theme.css">
<link href="<%=path %>/css/self.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
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
  		<form id="form" class="form-horizontal" action="<%= basePath%>/front/ExamQuestionAnswer_putAnswer.action" method="post">
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
                                    <div class="col-lg-12 form-group">
                                        <label class="col-lg-6 control-label" for="query_ano"><h2>${session.testpaper.testpaperName}<h2></label>
                                    </div>
                                    <div class="col-lg-12 form-group">
                                        <label class="col-lg-6 control-label" for="query_ano"><i>(卷面总分:${session.testpaper.totalScore}分)</i></label>
                                    </div>
                                      <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">课程:</label>
                                         <input type="hidden" id="test_subjectId" value="<s:property value="#request.subject.subjectId"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i><s:property value="#request.subject.course.courseName"/></i></label>
                                    </div>
                                    
                                     <input type="hidden" name="exam.examName" id="exam.examName" value="<s:property value="exam.examName"/>">
                                     <input type="hidden" name="exam.examId" id="exam.examId" value="<s:property value="exam.examId"/>">
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考试时间:</label>
                                        	<input type="hidden" name="testpaper.totalScore" id="testpaper.totalScore00000" value="<s:property value="exam.examDuration"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${session.exam.examDuration}分钟</i></label>
                                    </div>
                                    
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考生姓名:</label>
                                        <input type="hidden" name="studentId" id="studentId" value="<s:property value="#session.studentId"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${userName}</i> </label>
                                    </div>
                                    
                                    <div class="col-lg-3  form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  剩余时间:</label>
                                          <label class="col-lg-6 control-label" for="query_bno1" id="remainTime"><span></span>分<span></span>秒</label>
                                    </div>
                               <!--   </form>  -->
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                      <c:set var="index" value="1"/><!--统计题目 -->
                            <!---在此插入信息-->
                            <s:if test="result1.data!=null">
                            	<!--选择题 -->
	                            <s:iterator value="result1.data" id="id">    
	                              <div class="col-md-12">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
	                         			      	 	 <input name="choiceTopicId" type="hidden" value='<s:property value="#id[6]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>" id="answer" value="A"/>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>" id="answer" value="B"/>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>"  id="answer" value="C"/>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>"  id="answer" value="D"/>D. <s:property value="#id[5]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>
                         
                       <!--  <s:if test="result.data!=null">
                            	<!-- 判断题 -->
                              <!--<s:iterator value="#request.subject.judges" var="judge">    
                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#judge.question"/>?(判断题)</div>
                         			      	 <input name="topicId" type="hidden" value='<s:property value="#id[2]"/>'/>
                         			      	 <c:set var="index" value="${index+1}"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
		                                	<ul>
		                                	 <div class="radio">
												  <label>
												    <input type="radio" name='judge_<s:property value="#judge.judgeId"/>' id='optionsY_<s:property value="#judge.judgeId"/>' value='<s:property value="#judge.judgeId"/>_2_Y'>对
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name='judge_<s:property value="#judge.judgeId"/>' id='optionsN_<s:property value="#judge.judgeId"/>' value='<s:property value="#judge.judgeId"/>_2_N'>错
												  </label>
												</div>
		                               		 </ul>
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                            </s:if> --> 
                            
                             <s:if test="result2.data!=null">
                            	<!--填空题 -->
	                            <s:iterator value="result2.data" id="id">    
	                              <div class="col-md-12">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index}.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
	                         			      	 	<input name="fillTopicId" type="hidden" value='<s:property value="#id[2]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
	                            				<input name="answer_<s:property value="#id[2]"/>" type="text" placeholder="请在此输入答案">
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>   
                         <s:if test="result.data!=null">
                           	<!--简答题 -->
                            <s:iterator value="result.data" id="id">    
                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
                         			      	 	 <input name="topicId" type="hidden" value='<s:property value="#id[2]"/>'/>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
                            				<textarea name="answer_<s:property value="#id[2]"/>" rows="3" cols="100" placeholder="请在此输入答案"></textarea>
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                       </s:if>   
       		    	 	<div class="col-md-12" align="center">
   		    	 			<input type="button" id="putAnswer" class="tablelinkdelete btn btn-primary" onclick="" value="确认提交"/>
      			        </div>
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
	  <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        <div class="tipinfo">
        	<span><img src="<%= basePath%>images/ticon.png" /></span>
	        <div class="tipright">
		        <p>是否确认交卷 ？</p>
		        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
	        </div>
        </div>
        <div class="tipbtn">
	        <input name="" type="button"  class="sure" value="确定" />&nbsp;
	        <input name="" type="button"  class="cancel" value="取消" />
        </div>
     </div>
  </body>
</html>

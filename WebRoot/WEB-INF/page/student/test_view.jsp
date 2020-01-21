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
					//alert("考试结束");
				}
			}, 100)
		}
</script>

  </head>
  	
  <body class="bootstrap-admin-with-small-navbar">
		<!-- content -->
            <div class="col-md-10">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">试卷信息</div>
                            </div>
                            <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                <form class="form-horizontal" action="#" method="post">
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
                                    
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考试时间:</label>
                                        	<input type="hidden" name="testpaper.totalScore" id="testpaper.totalScore00000" value="<s:property value="exam.examDuration"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${session.exam.examDuration}分钟</i></label>
                                    </div>
                                    
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考生姓名:</label>
                                        <input type="hidden" id="test_studentId" value="<s:property value="#session.userName"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${userName}</i> </label>
                                    </div>
                                    
                                    <div class="col-lg-3  form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  剩余时间:</label>
                                          <label class="col-lg-6 control-label" for="query_bno1" id="remainTime"><span></span>分<span></span>秒</label>
                                    </div>
                                </form>
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
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	 <div class="radio">
													  <label>
													    <input type="radio" name='choice_<s:property value="A"/>' id='optionsA_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_A'>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='choice_<s:property value="B"/>' id='optionsB_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_B'>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='choice_<s:property value="C"/>' id='optionsC_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_C'>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='choice_<s:property value="D"/>' id='optionsD_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_D'>D. <s:property value="#id[5]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>
                            <s:if test="result9.data!=null">
                            	<!--选择题 -->
                            <s:iterator value="result9.data" id="id">    
                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
		                                	<ul>
		                                	 <div class="radio">
												  <label>
												    <input type="radio" name='choice_<s:property value="#choice.choiceId"/>' id='optionsA_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_A'>A. <s:property value="#choice.optionA"/>
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name='choice_<s:property value="#choice.choiceId"/>' id='optionsB_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_B'>B. <s:property value="#choice.optionB"/>
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name='choice_<s:property value="#choice.choiceId"/>' id='optionsC_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_C'>C. <s:property value="#choice.optionC"/>
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name='choice_<s:property value="#choice.choiceId"/>' id='optionsD_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_D'>D. <s:property value="#choice.optionD"/>
												  </label>
												</div>
		                               		 </ul>
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                         </s:if> 
                         <s:if test="result.data!=null">
                            	<!-- 判断题 -->
                              <s:iterator value="#request.subject.judges" var="judge">    
                              <div class="col-md-12">
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#judge.question"/>?(判断题)</div>
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
                            </s:if>
                             <s:if test="result2.data!=null">
                            	<!--填空题 -->
	                            <s:iterator value="result2.data" id="id">    
	                              <div class="col-md-12">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
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
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                       </s:if>   
       		    	 	<div class="col-md-12" align="center">
                               <button type="button" class="btn btn-primary" onclick="assignment()">提交试卷</button>          
      			        </div>
                </div>
            </div>   
    
                
  	<!-- 分页菜单组件--------------------------结束 -->
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
  </body>
</html>

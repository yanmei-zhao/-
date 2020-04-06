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
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/set_time_out.js"></script>
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
    	getTime();
    };
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
                                    <div class="col-lg-12 form-group" style="margin-left:100px">
                                        <label class="col-lg-6 control-label" for="query_ano"><h2>${session.testpaper.testpaperName}<h2></label>
                                    </div>
                                    <div class="col-lg-12 form-group" style="margin-left:45px">
                                        <label class="col-lg-6 control-label" for="query_ano"><i>(卷面总分:${session.testpaper.totalScore}分)</i></label>
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
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[8]"/>分】</div>
                         			      	   <input name="topicId" value="#id[3]" type="hidden"/>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	   <div class="radio">
													  <label>
													    <input type="radio" name='answer_<s:property value="#id[3]"/>' id='optionsA_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_A'>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='answer_<s:property value="#id[3]"/>' id='optionsB_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_B'>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='answer_<s:property value="#id[3]"/>' id='optionsC_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_C'>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name='answer_<s:property value="#id[3]"/>' id='optionsD_<s:property value="#choice.choiceId"/>' value='<s:property value="#choice.choiceId"/>_1_D'>D. <s:property value="#id[5]"/>
													  </label>
													</div>
			                               		 </ul>
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
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[8]"/>分】</div>
	                         			      	 	 <input name="multipleTopicId" type="hidden" value='<s:property value="#id[6]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>" id="answer" value="A"/>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>" id="answer" value="B"/>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>"  id="answer" value="C"/>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>"  id="answer" value="D"/>D. <s:property value="#id[5]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>"  id="answer" value="E"/>E. <s:property value="#id[9]"/>
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
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[4]"/>分】</div>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
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
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[4]"/>分】</div>
                         			      	 <c:set var="index" value="${index+1}"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
		                                	<ul>
		                                	 <div class="radio">
												  <label>
												    <input type="radio" name='judge_<s:property value="#id[2]"/>' value="正确">正确
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name='judge_<s:property value="#id[2]"/>'  value="错误">错误
												  </label>
												</div>
		                               		 </ul>
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
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【每题<s:property value="#id[4]"/>分】</div>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                            </s:if>   
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

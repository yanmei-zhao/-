<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>试题练习首页面</title>
    
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />

<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>
  </head>
  
  <body>
  	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">试题练习</a></li>
	    </ul>
    </div>
    
    <div class="mainindex">
	    <div class="t_container2">
	    
	    	<div class="t_topic">
	    		<div class="t_list">
	    			<b>单选题练习</b>
	    		</div>
	    		<form action="<%= basePath%>/front/ChoiceTopic_practiseList.action" method="post" target="rightFrame">
		    		<div class="t_topicBank">
		    			<ul>
		    				<li>
				    			<label>选择题库</label>
					           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
					               <option ></option>
						            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
						                <option>${ChoiceTopicBankNameList}</option>
						            </c:forEach>
					           </select>
				           </li>
				           <li>
					           <label>选择难度</label>
				    			 <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
						              <option>非常容易</option>
						              <option>比较容易</option>
						              <option selected="selected">常规</option>
						              <option>比较难</option>
						              <option>非常难</option>
						        </select>
					        </li>
				        </ul>
		    		</div>
		    		<div style="float:left;margin:0 20px 0px 140px;padding-bottom:20px;">
		    			<input value="开始练习" class="scbtn" type="submit" style="text-align:center;"/>
		    		</div>
	    		</form>
	    	</div>
	    	
	    	<div class="t_topic">
	    		<div class="t_list">
	    			<b>填空题练习</b>
	    		</div>
	    		<form action="<%= basePath%>/front/FillTopic_practiseList.action" method="post" target="rightFrame">
		    		<div class="t_topicBank">
		    		<ul>
		    				<li>
				    			<label>选择题库</label>
				    			<select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput1">
					               <option > </option>
						            <c:forEach items="${session.FillTopicBankNameList}" var="FillTopicBankNameList">
						                <option>${FillTopicBankNameList}</option>
						            </c:forEach>
					           </select>
				           </li>
				           <li>
					           <label>选择难度</label>
				    			 <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
						              <option>非常容易</option>
						              <option>比较容易</option>
						              <option selected="selected">常规</option>
						              <option>比较难</option>
						              <option>非常难</option>
						        </select>
					        </li>
				        </ul>
		    		</div>
		    		<div style="float:left;margin:0 20px 0px 140px;padding-bottom:20px;">
			    			<input value="开始练习" class="scbtn" type="submit" style="text-align:center;"/>
		    		</div>
	    		</form>
	    	</div>
	    	
	    	<div class="t_topic">
	    		<div class="t_list">
	    			<b>简答题练习</b>
	    		</div>
	    		<form action="<%= basePath%>/front/Topic_practiseList.action" method="post" target="rightFrame">
		    		<div class="t_topicBank">
		    			<ul>
		    				<li>
				    			<label>选择题库</label>
				    			<select name="topicBankName" id="topic.topicBankName" onchange="selectValue(this)"  class="dfinput1">
					               <option ></option>
						            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
						                <option>${TopicBankNameList}</option>
						            </c:forEach>
					           </select>
				           </li>
				           <li>
					           <label>选择难度</label>
				    			 <select name="difficulty" id="difficulty" onchange="selectValue(this)"  class="dfinput1">
						              <option>非常容易</option>
						              <option>比较容易</option>
						              <option selected="selected">常规</option>
						              <option>比较难</option>
						              <option>非常难</option>
						        </select>
					        </li>
				        </ul>
		    		</div>
		    		<div style="float:left;margin:15px 20px 0px 140px;padding-bottom:20px;">
			    			<input value="开始练习" class="scbtn" type="submit" style="text-align:center;"/>
		    		</div>
	    		</form>
	    	</div>
	    
	    </div>
    </div>
    
  </body>
</html>

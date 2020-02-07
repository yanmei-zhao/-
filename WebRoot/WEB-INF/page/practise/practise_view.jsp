<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'practise_view.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	   	<div id="main">
			<table class="mytable">
				<tr style="background-color:#f9fbe7">
					<td style="width:220px;">
						<button class="orange darken-4 waves-effect waves-teal btn-flat" type="button" name="action">
							<span class="yellow-text text-lighten-4">第<s:property value="question.id"/>题
				       		<i class="material-icons left">question_answer</i></span>
				   		</button>
					</td>
					<td style="text-align:left;">
						<s:property escapeHtml="false" value="@cn.lynu.lyq.java_exam.actions.ExamDetailShowAction2@showContentWithImage(question.content)"/>
					</td>
				</tr>
				<tr style="background-color:#f9fbe7">
					<td colspan="2">
						<table style="text-align:left;">
							<tr><td class="blue-text text-darken-4"  style="width:200px;">A. </td><td><s:property value="question.choiceA"/></td></tr>
							<tr><td class="blue-text text-darken-4"  style="width:200px;">B. </td><td><s:property value="question.choiceB"/></td></tr>
							<tr><td class="blue-text text-darken-4"  style="width:200px;">C. </td><td><s:property value="question.choiceC"/></td></tr>
							<tr><td class="blue-text text-darken-4"  style="width:200px;">D. </td><td><s:property value="question.choiceD"/></td></tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2"  class="red-text text-darken-2" style="height:20px;">
						<span class="blue-text  text-darken-2">答案：</span><s:property value="question.answer"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align:right;">
						<button class="teal darken-4 waves-effect waves-teal btn-flat" type="button" name="action" onclick="window.history.go(-1);">
							<span class="yellow-text text-lighten-1">返回
				       		<i class="material-icons right">arrow_back</i></span>
				   		</button>
					</td>
				</tr>
			</table>
			
		</div>


  </body>
</html>

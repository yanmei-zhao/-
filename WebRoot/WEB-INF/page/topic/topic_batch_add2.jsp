<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理-批量导入试题</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>

<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>

<script type="text/javascript" src="<%=path%>/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/layui.js"></script>
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
<!-- 用于Excel表格导入数据 -->
	<script type="text/javascript">
		$(function(){
			$("#import").upload({
				action:'<%=basePath%>/front/ChoiceTopic_importXls.action',
				name:'myFile',
				params:{topicBankName:$('#topicBankName option:selected').text()},
				onComplete: function(data) {
				 if(data == '1'){
	            		//上传成功
	            		alert("数据导入成功！");
	            		location.href=location.href;
	            	}else{
	            		//失败
	            		alert("数据导入失败！");           		
	            	}
	            }
			});
		 });
	</script>
	<%-- <script type="text/javascript">
		$(function(){
			$("#import1").upload({
				action:'<%=basePath%>/front/FillTopic_importXls.action',
				name:'myFile',
				params:{topicBankName1:$("#topicBankName1").find("option:selected").text()},
				 onComplete: function(data) {
				 if(data == '1'){
	            		//上传成功
	            		alert("数据导入成功！");
	            		location.href=location.href;
	            	}else{
	            		//失败
	            		alert("数据导入失败！");           		
	            	}
	            }
			});
		});
	</script>	    
	<script type="text/javascript">
		$(function(){
			$("#import2").upload({
				action:'<%=basePath%>/front/Topic_importXls.action',
				name:'myFile',
				params:{topicBankName:$("#topicBankName2").find("option:selected").text()},
				 onComplete: function(data) {
				 if(data == '1'){
	            		//上传成功
	            		alert("数据导入成功！");
	            		location.href=location.href;
	            	}else{
	            		//失败
	            		alert("数据导入失败！");           		
	            	}
	            }
			});
			$("#import3").upload({
				action:'<%=basePath%>/front/MultipleTopic_importXls.action',
				name:'myFile',
				params:{topicBankName:$("#topicBankName3").find("option:selected").text()},
				 onComplete: function(data) {
				 if(data == '1'){
	            		//上传成功
	            		alert("数据导入成功！");
	            		location.href=location.href;
	            	}else{
	            		//失败
	            		alert("数据导入失败！");           		
	            	}
	            }
			});
			$("#import4").upload({
				action:'<%=basePath%>/front/JudgeTopic_importXls.action',
				name:'myFile',
				params:{topicBankName:$("#topicBankName4").find("option:selected").text()},
				 onComplete: function(data) {
				 if(data == '1'){
	            		//上传成功
	            		alert("数据导入成功！");
	            		location.href=location.href;
	            	}else{
	            		//失败
	            		alert("数据导入失败！");           		
	            	}
	            }
			});
		 });
	</script>	     --%>
  </head>
  
  <body>
  	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
	    <li><a href="#">试题管理</a></li>
	    <li><a href="#">批量导入试题</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
	    <div class="formtitle"><span>批量导入试题</span></div>
        
        <div class="t_container">
        	<div class="t_box">
	        	<div class="t_t">导入单选题</div>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/ChoiceTopic_exportTemplateXls.action"></>下载单选题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
	        	<table width="100%"  border="0" class="t_table">
	        		<tbody>
	        			<tr>
	        				<th>所属题库</th>
	        				<td>
	        					<select name="topicBankName" id="topicBankName"  class="dfinput">
					               <option value="null">请选择...</option>
					            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
					                <option value="${ChoiceTopicBankNameList}">${ChoiceTopicBankNameList}</option>
					            </c:forEach>
					           </select><i><font color="#FF0000">*必填</font></i>
	        				</td>
	        			</tr>
	        			<tr>
	        				<th>数据文件</th>
	        				<td>
	        					<div style="float:left;text-align:center;vertical-align: middle;">
	        						<div style="float:left"><input id="import"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div>
	        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。</div>
	        					</div>
	        				</td>
	        			</tr>
	        		</tbody>
	        	</table>
        	</div>
        	
        <%-- 	<div class="t_box">
	        	<div class="t_t">导入填空题</div>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/FillTopic_exportTemplateXls.action"></>下载填空题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
	        	<form id="form" action="<%=basePath%>/front/Topic_importXls.action" enctype="multipart/form-data">
		        	<table width="100%"  border="0" class="t_table">
		        		<tbody>
		        			<tr>
		        				<th>所属题库</th>
		        				<td>
		        					<select name="topicBankName1" id="topicBankName1"  class="dfinput">
						               <option >请选择...</option>
						            <c:forEach items="${session.FillTopicBankNameList}" var="FillTopicBankNameList">
						                <option>${FillTopicBankNameList}</option>
						            </c:forEach>
						           </select><i><font color="#FF0000">*必填</font></i>
		        				</td>
		        			</tr>
		        			<tr>
		        				<th>数据文件</th>
		        				<td>
		        					<div style="float:left;text-align:center;vertical-align: middle;">
		        						<div style="float:left"><input id="import1"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div>
		        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。
	        						</div>
	        					</div>
		        				</td>
		        			</tr>
		        		</tbody>
		        	</table>
	        	</form>
        	</div>
        	
        	<div class="t_box">
	        	<div class="t_t">导入多选题</div>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/MultipleTopic_exportTemplateXls.action"></>下载多选题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
	        	<form id="form" action="<%=basePath%>/front/MultipleTopic_importXls.action" enctype="multipart/form-data">
		        	<table width="100%"  border="0" class="t_table">
		        		<tbody>
		        			<tr>
		        				<th>所属题库</th>
		        				<td>
		        					<select name="topicBankName3" id="topicBankName3"  class="dfinput">
						               <option >请选择...</option>
						            <c:forEach items="${session.MultiplesTopicBankNameList}" var="MultiplesTopicBankNameList">
						                <option>${MultiplesTopicBankNameList}</option>
						            </c:forEach>
						           </select><i><font color="#FF0000">*必填</font></i>
		        				</td>
		        			</tr>
		        			<tr>
		        				<th>数据文件</th>
		        				<td>
		        					<div style="float:left;text-align:center;vertical-align: middle;">
		        						<div style="float:left"><input id="import3"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div>
		        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。
	        						</div>
	        					</div>
		        				</td>
		        			</tr>
		        		</tbody>
		        	</table>
	        	</form>
        	</div>
        	
        	<div class="t_box">
	        	<div class="t_t">导入判断题</div>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/JudgeTopic_exportTemplateXls.action"></>下载判断题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
	        	<form id="form" action="<%=basePath%>/front/JudgeTopic_importXls.action" enctype="multipart/form-data">
		        	<table width="100%"  border="0" class="t_table">
		        		<tbody>
		        			<tr>
		        				<th>所属题库</th>
		        				<td>
		        					<select name="topicBankName4" id="topicBankName4"  class="dfinput">
						               <option >请选择...</option>
						            <c:forEach items="${session.JudgeTopicBankNameList}" var="JudgeTopicBankNameList">
						                <option>${JudgeTopicBankNameList}</option>
						            </c:forEach>
						           </select><i><font color="#FF0000">*必填</font></i>
		        				</td>
		        			</tr>
		        			<tr>
		        				<th>数据文件</th>
		        				<td>
		        					<div style="float:left;text-align:center;vertical-align: middle;">
		        						<div style="float:left"><input id="import4"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div>
		        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。
	        						</div>
	        					</div>
		        				</td>
		        			</tr>
		        		</tbody>
		        	</table>
	        	</form>
        	</div>
        	
     		<div class="t_box">
	        	<div class="t_t">导入简答题</div>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/Topic_exportTemplateXls.action"></>下载简答题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
	        	<form id="form" action="<%=basePath%>/front/Topic_importXls.action" enctype="multipart/form-data">
		        	<table width="100%"  border="0" class="t_table">
		        		<tbody>
		        			<tr>
		        				<th>所属题库</th>
		        				<td>
		        					<select name="topicBankName2" id="topicBankName2"  class="dfinput">
						               <option >请选择...</option>
						            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
						                <option>${TopicBankNameList}</option>
						            </c:forEach>
						           </select><i><font color="#FF0000">*必填</font></i>
		        				</td>
		        			</tr>
		        			<tr>
		        				<th>数据文件</th>
		        				<td>
		        					<div style="float:left;text-align:center;vertical-align: middle;">
		        						<div style="float:left"><input id="import2"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div>
		        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。
	        						</div>
		        				</td>
		        			</tr>
		        		</tbody>
	        	  </table>
        	  </form>
        </div> --%>
     </div>
 </div>       
        
	    
  </body>
</html>

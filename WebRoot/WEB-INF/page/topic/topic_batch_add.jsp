<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理-批量导入试题</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.ocupload-1.1.2.js"></script>
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
				/* params: {'topicBankName':document.getElementById("topicBankName").value},  */
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
		function u(){
			alert("t=="+document.getElementById("topicBankName").value);
		}
	</script>
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
	        	<div class="t_t">导入试题</div>
	        	
	        	<table width="100%"  border="0" class="t_table">
	        		<tbody>
	        			<tr>
	        				<th>试题类型</th>
	        				<td>
        						<select name="type" id="type" onchange="test(this.value)" class="dfinput">
					                <option >请选择...</option>
					                <option value="单选题">单选题</option>
					                <option value="多选题">多选题</option>
					                <option value="判断题">判断题</option>
					                <option value="填空题">填空题</option>
					                <option value="简答题">简答题</option>
					           </select><i><font color="#FF0000">*必填</font></i>
	        				</td>
	        			</tr>
	        			<tr>
	        				<th>数据文件</th>
	        				<td>
	        					<div style="float:left;text-align:center;vertical-align: middle;">
	        						<div style="float:left"><input id="import" type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></div> 
	        						<div style="color:#999;float:left;margin-top:5px;margin-left:10px;">选择文件后即可自动上传数据。</div> 
	        					</div>
	        				</td>
	        			</tr>
	        		</tbody>
	        	</table>
	        	<div class="t_help"><u><a href="<%= basePath%>/front/ChoiceTopic_exportTemplateXls.action"></>下载单选题模板</a></u>，请先下载模板，并按模板指定格式填写，填写完成后，上传文件即可完成导入。</div>
        	</div>
        	
     </div>
 </div>       
        
	    
  </body>
</html>

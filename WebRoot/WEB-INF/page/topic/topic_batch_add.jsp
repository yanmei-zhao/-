<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理-导入</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
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
				action:'<%=basePath%>/front/Topic_importXls.action',
				name:'myFile',
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
	<!-- 用于Excel表格导出数据 -->
	<script type="text/javascript">
		function doExport(){
		window.location.href = "<%= basePath%>/front/Topic_exportXls.action";
		}
		function doTemplateExport(){
		window.location.href = "<%= basePath%>/front/Topic_exportTemplateXls.action";
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
	    <div class="formtitle"><span>用excel导入</span></div>
	     <ul class="forminfo">
	      <!--  <li><label>模板下载</label><input id="Export" type="button" class="scbtn" value="下载模板" onclick="doTemplateExport()"/></li>
		     
		     <div id="fileupload" style="display: none;">
	                <form id="reportFileAll" action="<%= basePath%>/front/Topic_downloadFileAll.action" style="display:none;">
	                    <input id="id" type="hidden" name="id" value="${Order.id}"/>
	                </form>
	         </div>
	         
        </ul>-->
	    <form action="#" method="post" id="commonform">
		    <ul class="forminfo">
			     <li><label>所属题库</label>
		           <select name="topicBankName" id="topicBankName" onchange="selectValue(this)"  class="dfinput">
		               <option >请选择...</option>
		            <c:forEach items="${session.TopicBankNameList}" var="TopicBankNameList">
		                <option>${TopicBankNameList}</option>
		            </c:forEach>
		           </select><i><font color="#FF0000">*必填</font></i>
		   		 </li>
			     <li><label>选择数据</label><input id="import"  type="button" class="btn layui-btn layui-btn-sm" value="选择文件"/></li>
			     <li>
				       <label>&nbsp;</label><input type="submit" class="btn"  value="确认提交"/>
		         </li>
           </ul>
	    </form>
    </div>
  </body>
</html>

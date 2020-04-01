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
<title>帮助页面</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path %>/css/process.css">
<link rel="stylesheet" href="<%=path %>/css/self.css">
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
  </head>
  	
  <body >
	   <div class="place" style="height:40px;background:url(../images/righttop.gif) repeat-x">
	    	<span>位置：</span>
		    <ul class="placeul">
			    <li><a href="<%=basePath%>/front/Login_openIndex.action">首页</a></li>
			    <li><a href="#">帮助</a></li>
		    </ul>
	    </div>
	    
         <div class="col-md-01" style="float:left">
         	<div class="use">线上考核系统使用手册</div>
         	<div class="xline1"></div>
         	
         	
  		</div>
	    	
                
  </body>
</html>

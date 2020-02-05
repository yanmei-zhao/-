<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <script type="text/javascript" src="<%=path%>/js/layui-v2.4.5/layui/layui.all.js"></script>
	<script type="text/javascript" src="<%=path%>/js/layui-v2.4.5/layui/layui.js"></script>
<link href="<%=path %>/js/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" type="text/css" />


<script >
	alert(23);
		layui.use('upload', function(){
	  		var $ = layui.jquery
	  		,var upload = layui.upload;
	  		
	  		 upload.render({
			    elem: '#test8'
			    ,url: '<%=basePath%>/front/Topic_importXls.action' //改成您自己的上传接口
			    ,auto: false
			    //,multiple: true
			    ,bindAction: '#test9'
			    ,done: function(res){
			      layer.msg('上传成功');
			      console.log(res)
			    }
			  });
		});
</script>
  </head>
  
  <body>
    		<div class="layui-upload">
			  <button type="button" class="layui-btn layui-btn-normal" id="test8" >选择文件</button>
			  <button type="button" class="layui-btn" id="test9">开始上传</button>
			</div>
  </body>
</html>

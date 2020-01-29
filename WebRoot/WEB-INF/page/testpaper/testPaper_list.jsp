<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.gxuwz.Market.business.entity.*" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试卷列表</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/icon.css" />
	
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
	//删除
	$(document).ready(function(){
		var testpaperId;
		$(".tablelinkdelete").click(function(){
			testpaperId = $(this).attr("testpaperId");
		  	$(".tip").fadeIn(200);
		 });
	  	$(".tiptop a").click(function(){
	  	$(".tip").fadeOut(200);
	});
		
	$(".sure").click(function(){
		$(".tip").fadeOut(100);
		window.location.href="<%= basePath%>/front/Testpaper_delete.action?testpaperId="+testpaperId;
	});
	  	$(".cancel").click(function(){
	  		$(".tip").fadeOut(100);
		});

	});
</script>
<script type="text/javascript">
	//预览试卷页面（弹窗显示）
	  function preview(id){
	  	layer.open({
	       type: 2,
	      title: '试卷预览',
	      area: ['1200px', '600px'],
	      shadeClose: true, //点击遮罩关闭
	      content: '<%= basePath%>/front/Testpaper_openViewPaper.action?testpaperId='+id,
	    });
	  }
</script>
<style type="text/css">
	.tablelinkdelete{color:#056dae;}
</style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
	    <li><a href="#">试卷管理</a></li>
	    <li><a href="<%= basePath%>/front/Testpaper_list.action">试卷列表</a></li>
	    </ul>
    </div>
	<div class="formbody">
	    <div id="usual1" class="usual">
	      <div id="tab2" class="tabson">
	     	<form action="<%= basePath%>/front/Testpaper_list.action" method="post"  target="rightFrame">
		    	<ul class="seachform">
		    	    <li><label>综合查询</label><input class="scinput" name="testpaper.testpaperName"  placeholder="请输入试卷名称"/></li>
		            <li><input name="" type="submit" class="scbtn" value="查询"/></li>
		            <li class="clickk"><span><img src="<%=path%>/images/t01.png" /></span><a href="<%= basePath%>/front/Testpaper_openAdd.action">添加</a></li>
		        </ul>
	        </form> 
		    <table class="tablelist">
		    	<thead>
			    	<tr>
				        <th width="5%"><input name="" type="checkbox" value="" checked="checked"/></th>
				        <th>试卷编号</th>
				        <th>试卷名称</th>
				        <th>试卷总分</th>
				        <th>及格分数</th>
				        <th>创建人</th>
				        <p:permissions menu="deleteTestpaper,editTestpaper">
				        <th width="20%">操作</th>
				        </p:permissions>
			        </tr>
		        </thead>
		        <tbody>
			        <s:iterator value="pageResult.data" id="id">
			        <tr>
				        <td><input name="" type="checkbox" value="" /></td>
				        <td>${testpaperId}</td>
				        <td>${testpaperName}</td>
				        <td>${totalScore}</td>
				        <td>${passScore}</td>
				        <td>${creator}</td>
				        <td>&nbsp;
				      		  <a href="javascript:;" onclick="preview('${testpaperId}')" class="tablelink">预览</a>&nbsp;&nbsp;
				        		<a href="<%= basePath%>/front/Testpaper_openViewPaper.action?testpaperId=${testpaperId}" class="tablelink">预览</a>&nbsp;&nbsp;
				                <a href="<%= basePath%>/front/Testpaper_openAddTopic.action?testpaperId=${testpaperId}" class="tablelink">配置</a>&nbsp;&nbsp;
				                <a href="<%= basePath%>/front/Testpaper_openEdit.action?testpaperId=${testpaperId}" class="tablelink">编辑</a>&nbsp;&nbsp;
				      			<a href="javascript:;" class="tablelinkdelete" testpaperId="${testpaperId}">删除</a>&nbsp;&nbsp;
				        </td>
			        </tr> 
		        </s:iterator>
		        </tbody>
		    </table>
	  </div>  
	</div>
    <!-- 分页菜单组件--------------------------开始 -->
	<%
	//查询的url地址，统一写
	String listActionURL = basePath+"/front/Testpaper_list.action";
	%>
 
    <script type="text/javascript">
		//分页组件
		function change()
		  {
		    var url = "<%= basePath%>/front/Testpaper_list.action";                 //获取表单url
		 	var textfield=document.getElementById("textfield").value;
		 	var totalPage='${pageResult.totalPage}';
		 	var pageNum = 0;
		 	if(totalPage*1 >= textfield*1){
		 		pageNum = textfield; 
		 		window.location.href="<%=listActionURL%>?page="+pageNum;
		 	}else{
		 		pageNum = totalPage; 
		 		alert("当前只有"+totalPage+"页");
		 	}
		  	
		  }
	</script>
	<script type="text/javascript">
		var url = "<%= basePath%>/front/Testpaper_list.action";                 //获取表单url
		//首页
		function first(){
			
		   window.location.href  = url+"?page=1";
		}
		//上一页
		function previous(){
		    window.location.href  = url+"?page=${pageResult.previousPageNumber}";
		}
		//下一页
		function next(){
		    window.location.href  = url+"?page=${pageResult.nextPageNumber}";
		}
		//尾页
		function last(){
		  window.location.href  = url+"?page=${pageResult.totalPage}";
		}
	</script>
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageResult.total}</i>条记录 	<i class="blue">${pageResult.totalPage}</i>页， 	当前显示第&nbsp;<i class="blue">${pageResult.page}</i>页</div>
        <ul class="paginList">
           <c:choose>
			   <c:when test="${pageResult.isFirst==true}"><li class="paginItem current"><a href="javascript:;">首页</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:first()" target="rightFrame">首页&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
           <c:choose>
		      <c:when test="${pageResult.isFirst==true}"><li class="paginItem current"><a href="javascript:;">上一页</a></li></c:when>
		      <c:otherwise>
			      <li class="paginItem"><a href="javascript:previous()" target="rightFrame">上一页&nbsp;</a></li>
		      </c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult.hasNext==true}">
				   <li class="paginItem"><a href="javascript:next()" target="rightFrame">下一页&nbsp;</a></li>
			   </c:when>
		       <c:otherwise><li class="paginItem current"><a href="javascript:;">下一页</a></li></c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult.isLast==true}"><li class="paginItem current"><a href="javascript:;">尾页</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:last()" target="rightFrame">尾页&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
        <li class="paginItem-page">
           跳转到：&nbsp;
           <input name="textfield" type="text" size="4" class="page-input" id="textfield" onchange="change()"/>&nbsp;页
        </li>
        </ul>
    </div>
	<!-- 分页菜单组件--------------------------结束 -->
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
 </div>
	  <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
	        <div class="tipinfo">
	        <span><img src="<%= basePath%>images/ticon.png" /></span>
	        <div class="tipright">
	        <p>是否确认删除信息 ？</p>
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

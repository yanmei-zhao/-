<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合同</title>

<link href="<%=path %>/css/style5.css" rel="stylesheet" type="text/css" />
<!--<link href="/css/metallic.css" rel="stylesheet"  type="text/css"></link>-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/zebra_datepicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
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
			action:'<%=basePath%>/front/StudentManage_importXls.action',
			name:'myFile',
			 onComplete: function(data) {
			 if(data == '1'){
            		//上传成功
            		alert("区域数据导入成功！");
            		location.href=location.href;
            	}else{
            		//失败
            		alert("区域数据导入失败！");           		
            	}
            }
		});
	});
</script>

<!-- 用于Excel表格导出数据 -->
<script type="text/javascript">
	function doExport(){
	window.location.href = "<%= basePath%>/front/StudentManage_exportXls.action";
	}
</script>

<script type="text/javascript">
	//删除
	$(document).ready(function(){
		var studentId;
  		$(".tablelinkdelete").click(function(){
			 studentId = $(this).attr("studentId");
			  $(".tip").fadeIn(200);
	 	 });
		  $(".tiptop a").click(function(){
		 	 $(".tip").fadeOut(200);
			});
		  $(".sure").click(function(){
			  $(".tip").fadeOut(100);
			  window.location.href="<%= basePath%>/front/StudentManage_delete.action?studentId="+studentId;
		 	});
		  $(".cancel").click(function(){
		  	$(".tip").fadeOut(100);
		  });
	});
</script>

</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">学生信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual">
      <div id="tab2" class="tabson">
        <form action="<%=basePath%>/front/StudentManage_list.action" method="post"  target="rightFrame" id="form">
    	<ul class="seachform">
    	 
    	    <li><label>综合查询</label><input class="scinput" name="student.studentId" id="title" placeholder="请输入关键字"/>
    	     
    	    </li>
   			  <li><input type="submit" class="scbtn" value="查询" onclick="submita()"/></li>
           	 	<li class="clickk"><span><img src="<%=path%>/images/t01.png" /></span><a href="<%=basePath%>/front/StudentManage_openAdd.action" >添加学生</a></li>
           	 	<li><input id="import" type="button" class="scbtn" value="Excel导入" /></li>
           	 	<li><input id="Export" type="button" class="scbtn" value="Excel导出" onclick="doExport()"/></li>
           	 	<li></li>
          
           	 	<li></li>
        </ul>
        </form> 
        </div>
        </div>
        


       <!-- <td>${docPath}</td>--> 
          
     	 
     <table class="tablelist" >

   	<thead>
    	<tr>
        <!-- <th>序号</th> -->
        <!-- <th>学生编号</th> -->
        <th>学号</th>
        <th>学生姓名</th>
        <th>班别</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="pageResultList.data" id ="pr">

         <%-- <td>${id }</td>   --%>
        <%--  <td>${studentNumber}</td> --%>
         <td>${studentId}</td> 
         <td>${studentName}</td> 
         <td>${classId}</td> 
         
        <td>
        		<a href="<%= basePath%>/front/StudentManage_openEdit.action?studentId=${studentId}" class="tablelink">修改</a>&nbsp;&nbsp;
	     		<a href="javascript:;" class="tablelinkdelete" id="${id}" studentId="${studentId}">删除</a>        
        </td>
        
        </tbody>
        </s:iterator>
        </table>
    <!-- 分页菜单组件--------------------------开始 -->
    
    <%
		//查询的url地址，统一写
		String listActionURL = basePath+"/front/StudentManage_list.action";
	%>
    
    <script type="text/javascript">
//分页组件
function change()
  {
 	var textfield=document.getElementById("textfield").value;
 	var totalPage=document.getElementById("totalPage").value;
 	var pageNum = 0;
 	if(textfield < totalPage ){
 		pageNum = textfield; 
 		window.location.href="<%=listActionURL%>?page="+pageNum;
 	}else{
 		pageNum = totalPage; 
 		alert("当前只有"+totalPage+"页");
 	}
  	
  }
</script>
<script type="text/javascript">
var form = document.getElementById("form");     //获取表单节点
var url = form.action;    //获取表单url

//首页
function first(){
	form.action  = url+"?page=1";
    form.submit();
 
}
//上一页
function previous(){
    form.action  = url+"?page=${pageResultList.previousPageNumber}";
    form.submit();
    
}
//下一页
function next(){
    form.action  = url+"?page=${pageResultList.nextPageNumber}";
    form.submit();
 
}
//尾页
function last(){
 form.action  = url+"?page=${pageResultList.totalPage}";
 form.submit();
 
}
</script>
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageResultList.total}</i>条记录 	<i class="blue">${pageResultList.totalPage}</i>页， 	当前显示第&nbsp;<i class="blue">${pageResultList.page}</i>页</div>
        <ul class="paginList">
           <c:choose>
			   <c:when test="${pageResultList.isFirst==true}"><li class="paginItem current"><a href="javascript:;">首页</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:first()" target="rightFrame">首页&nbsp;</a></li>
		       </c:otherwise>
		      
		   </c:choose>
		 
           <c:choose>
		      <c:when test="${pageResultList.isFirst==true}"><li class="paginItem current"><a href="javascript:;">上一页</a></li></c:when>
		      <c:otherwise>
			      <li class="paginItem"><a href="javascript:previous()" target="rightFrame">上一页&nbsp;</a></li>
		      </c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResultList.hasNext==true}">
				   <li class="paginItem"><a href="javascript:next()" target="rightFrame">下一页&nbsp;</a></li>
			   </c:when>
			   <c:otherwise><li class="paginItem current"><a href="javascript:;">下一页</a></li></c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResultList.isLast==true}"><li class="paginItem current"><a href="javascript:;">尾页</a></li></c:when>
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
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>
	
	<div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        <div class="tipinfo">
        <span><img src="http://df.gxuwz.com:8089/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认删除信息 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input  type="button"  class="sure" value="确定" />&nbsp;
        <input  type="button"  class="cancel" value="取消" />
        </div>
    
    </div>

</body>

</html>


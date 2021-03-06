<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.gxuwz.Market.business.entity.*" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>题库列表</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/all.js"></script>
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
		var topicBankId;
		$(".tablelinkdelete").click(function(){
		 	topicBankId = $(this).attr("topicBankId");
		  	$(".tip").fadeIn(200);
		 });
	  	$(".tiptop a").click(function(){
		  	$(".tip").fadeOut(200);
		});
		$(".sure").click(function(){
			$(".tip").fadeOut(100);
			window.location.href="<%= basePath%>/front/TopicBank_delete.action?topicBankId="+topicBankId;
		});
	  	$(".cancel").click(function(){
	  		$(".tip").fadeOut(100);
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		var topicBankType;
		var topicBankId;
		$(".queryTopic").click(function(){
		 	topicBankType = $(this).attr("topicBankType");
		 	topicBankId = $(this).attr("topicBankId");
		 	if(topicBankType=="单选题"){
		 		window.location.href="<%= basePath%>/front/ChoiceTopic_getChoicelistByTopicBankId.action?choiceTopic.topicBankId="+topicBankId;
		 	}else if(topicBankType=="填空题"){
		 		window.location.href="<%= basePath%>/front/FillTopic_getFilllistByTopicBankId.action?fillTopic.topicBankId="+topicBankId;
		 	}else if(topicBankType=="简答题"){
		 		window.location.href="<%= basePath%>/front/Topic_getlistByTopicBankId.action?topicBankId="+topicBankId;
		 	}else if(topicBankType=="判断题"){
		 		window.location.href="<%= basePath%>/front/JudgeTopic_getJudgelistByTopicBankId.action?judgeTopic.topicBankId="+topicBankId;
		 	}else if(topicBankType=="多选题"){
		 		window.location.href="<%= basePath%>/front/MultipleTopic_getMultiplelistByTopicBankId.action?multipleTopic.topicBankId="+topicBankId;
		 	}
		 });
	});
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
    <li><a href="#">题库管理</a></li>
    <li><a href="<%= basePath%>/front/TopicBank_list.action">题库列表</a></li>
    </ul>
    </div>
<div class="formbody">
    <div id="usual1" class="usual">
      <div id="tab2" class="tabson">
        
     	<form action="<%= basePath%>/front/TopicBank_list.action" method="post"  target="rightFrame" autocomplete="off">
    	<ul class="seachform">
    	    <li><label>综合查询</label><input class="scinput" name="topicBank.topicBankName"  placeholder="请输入题库关键词"/></li>
            <li><input name="" type="submit" class="scbtn" value="查询"/></li>
            <li class="clickk"><a href="<%= basePath%>/front/TopicBank_openAdd.action"><span><img src="<%=path%>/images/t01.png" /></span>添加</a></li>
        </ul>
        </form> 
	    <table class="tablelist">
	    	<thead>
		    	<tr>
			        <th width="8%"><input id="all" type="checkbox" onclick="selectAll()"/>全选</th>
			        <th width="10%">题库编号</th>
			        <th>题库名称</th>
			        <th>题库类型</th>
			        <th>试题数量</th>
			        <th>创建人</th>
			        <th>最后修改人</th>
			        <p:permissions menu="deleteTopicBank,editTopicBank">
			        <th>操作</th>
			        </p:permissions>
		        </tr>
	        </thead>
	        <tbody>
		        <s:iterator value="pageResult.data" id="id">
		        <tr>
			        <td><input name="checkbox" type="checkbox" value='<s:property value="topicBankId"/>' /></td>
			        <td>${topicBankId}</td>
			        <td>${topicBankName}</td>
			        <td>${topicBankType}</td>
			        <td><a href="javascript:;" class="queryTopic" topicBankType="${topicBankType}" topicBankId="${topicBankId}"><b><u>${TopicNum}</u></b></a></td>
			        <td>${creator}</td>
			        <td>${finalModifier}</td>
			        
			        <td>&nbsp;
			        	<a href="<%= basePath%>/front/TopicBank_openEdit.action?topicBankId=${topicBankId}" class="tablelink">编辑</a>&nbsp;&nbsp;
			        	<a href="javascript:;" class="tablelinkdelete" topicBankId="${topicBankId}">删除</a>
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
String listActionURL = basePath+"/front/TopicBank_list.action";
%>
 
<script type="text/javascript">
//分页组件
function change()
  {
    var url = "<%= basePath%>/front/TopicBank_list.action";                 //获取表单url
 	var textfield=document.getElementById("textfield").value;
 	var totalPage='${pageResult.totalPage}';
 	var pageNum = 0;
 	if(totalPage*1 >= textfield*1){
 		pageNum = textfield; 
 		window.location.href  = url+"?page="+pageNum;
 	}else{
 		pageNum = totalPage; 
 		alert("当前只有"+totalPage+"页");
 	}
  	
  }
</script>
<script type="text/javascript">
var url = "<%= basePath%>/front/TopicBank_list.action";                 //获取表单url
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

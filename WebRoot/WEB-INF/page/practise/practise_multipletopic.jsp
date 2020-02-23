<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题练习——多选题列表</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>

<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/icon.css" />
	
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
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
        function answer(){
	  	   document.getElementById("tanswer").style.display = 'block';
	}
</script>
</head>
  <body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
			    <li><a href="#">试题练习</a></li>
			    <li><a href="#">多选题</a></li>
		    </ul>
	    </div>
	    
	    <div class="formbody">
	    <div id="usual1" class="usual">
	     	 <div id="tab2" class="tabson">
			  	  <c:set var="index" value="1"/><!--统计题目 -->
			  	    <s:if test="pageResult1.data!=null">
				  	    <s:iterator value="pageResult1.data" id="id"> 
					  	  <div class="view_box">
						  	  	<div class="view_description">
							  	  	<div>${pageResult1.page }.${description}?(${type})</div>
							  	  	<input name="choiceTopicId" type="hidden" value='${id }'/>
							  	  	<c:set var="index" value="${index+1 }"/><!--统计题目 -->
						  	  	</div>
						  	  	<div class="view_answer">
						  	  		<ul>
						  	  			<div class="radio">
						  	  				<label><input name="answer_${id }" type="checkbox" value="A"/>A.${optionA } </label>
						  	  			</div>
						  	  			<div class="radio">
						  	  				<label><input name="answer_${id }" type="checkbox" value="B"/>B.${optionB }</label>
						  	  			</div>
						  	  			<div class="radio">
						  	  				<label><input name="answer_${id }" type="checkbox" value="C"/>C.${optionC }</label>
						  	  			</div>
						  	  			<div class="radio">
						  	  				<label><input name="answer_${id }" type="checkbox" value="D"/>D.${optionD }</label>
						  	  			</div>
						  	  		</ul>
						  	  	</div>
						  	  	<div class="view_description">
						  	  		<div><input value="查看答案" type="button" onClick="answer()" class="scbtn1"/></div>
						  	  		<div id="tanswer" style="display:none">${answer }</div>
						  	  	</div>
					  	  </div>
				  	  </s:iterator> 
			  	  </s:if>
 	 	  </div>  
	 </div>
	 
	   <div class="pagin">
    	<div class="message">共<i class="blue">${pageResult1.total}</i>道题 	<i class="blue">${pageResult1.totalPage}</i>页， 当前显示第&nbsp;<i class="blue">${pageResult1.page}</i>题</div>
        <ul class="paginList">
           <c:choose>
			   <c:when test="${pageResult1.isFirst==true}"><li class="paginItem current"><a href="javascript:;">首题</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:first()" target="rightFrame">首题&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
           <c:choose>
		      <c:when test="${pageResult1.isFirst==true}"><li class="paginItem current"><a href="javascript:;">上一题</a></li></c:when>
		      <c:otherwise>
			      <li class="paginItem"><a href="javascript:previous()" target="rightFrame">上一题&nbsp;</a></li>
		      </c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult1.hasNext==true}">
				   <li class="paginItem"><a href="javascript:next()" target="rightFrame">下一题&nbsp;</a></li>
			   </c:when>
		       <c:otherwise><li class="paginItem current"><a href="javascript:;">下一题</a></li></c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult1.isLast==true}"><li class="paginItem current"><a href="javascript:;">尾题</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:last()" target="rightFrame">尾题&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
        <li class="paginItem-page">
           跳转到：&nbsp;
           <input name="textfield" type="text" size="4" class="page-input" id="textfield" onchange="change()"/>&nbsp;题
        </li>
        </ul>
    </div>
    
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
     
	    <!-- 分页菜单组件--------------------------开始 -->
	<%//查询的url地址，统一写
	String listActionURL = basePath+"/front/MultipleTopic_practiseList.action";
	%>
	<script type="text/javascript">
	//分页组件
	function change()
	  {
	  var url = "<%= basePath%>/front/MultipleTopic_practiseList.action";                 //获取表单url
	 	var textfield=document.getElementById("textfield").value;
	 	var totalPage='${pageResult1.totalPage}';
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
	var url = "<%= basePath%>/front/MultipleTopic_practiseList.action";                 //获取表单url
	//首页
	function first(){
		
	   window.location.href  = url+"?page=1";
	}
	//上一页
	function previous(){
	    window.location.href  = url+"?page=${pageResult1.previousPageNumber}";
	}
	//下一页
	function next(){
	    window.location.href  = url+"?page=${pageResult1.nextPageNumber}";
	}
	//尾页
	function last(){
	  window.location.href  = url+"?page=${pageResult1.totalPage}";
	}
	</script>
	<!-- 分页菜单组件--------------------------结束 -->
	<script type="text/javascript"> 
     	 $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
  </body>
</html>

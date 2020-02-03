<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>填空题管理——列表</title>
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
		var id;
		$(".tablelinkdelete").click(function(){
			id = $(this).attr("id");
		  	$(".tip").fadeIn(200);
		});
	  	$(".tiptop a").click(function(){
	  	$(".tip").fadeOut(200);
	});
	$(".sure").click(function(){
		$(".tip").fadeOut(100);
		window.location.href="<%= basePath%>/front/FillTopic_delete.action?id="+id;
	});
	  	$(".cancel").click(function(){
	  		$(".tip").fadeOut(100);
		});	

	});
</script>
<script type="text/javascript">
//预览页面（弹窗显示）
  function preview(id){
  	layer.open({
      type: 2,
      title: '试题预览',
      area: ['700px', '460px'],
      shadeClose: true, //点击遮罩关闭
      content: '<%= basePath%>/front/FillTopic_openView.action?id='+id
    });
  }
</script>

</head>
<body>
    
<div class="formbody">
    <div id="usual1" class="usual">
      <div id="tab2" class="tabson">
        
     	<form action="<%= basePath%>/front/Testpaper_openFillTopicList.action" method="post" >
    	<ul class="seachform">
    	    <li><label>综合查询</label><input class="scinput1" name="fillTopic.description"  placeholder="请输入试题关键词"></li>
    	    <li><label>所属题库</label>
	           <select name="fillTopic.topicBankName" id="fillTopic.topicBankName" onchange="selectValue(this)"  class="scinput1" >
	            <c:forEach items="${session.FillTopicBankNameList}" var="FillTopicBankNameList">
	                <option>${FillTopicBankNameList}</option>
	            </c:forEach>
	           </select>
		    </li>
            <li><input name="" type="submit" class="scbtn" value="查询"/></li>
        </form> 
        <form action="<%= basePath%>/front/TestPaperTopic_addF.action">
        	<li><input name="" type="submit" class="scbtn" value="添加到试卷"/></li> 
       	</ul>
     	     <table class="tablelist " >
		    	<thead>
			    	<tr>
				        <th width="8%"><input id="all" type="checkbox" value="" onclick="selectAll()"/>全选</th>
				        <th>试题编号</th>
				        <th width="20%">试题题干</th>
				        <th>所属题库</th>
				        <th>试题类型</th>
				        <th>试题难度</th>
				        <th>创建人</th>
				        <p:permissions menu="deleteRole,editRole">
				        <th>操作</th>
				        </p:permissions>
			        </tr>
		        </thead>
		        <tbody>
			        <s:iterator value="pageResult3.data" id="id">
				        <tr>
					        <td><input name="checkbox" type="checkbox" value='<s:property value="id"/>'/></td>
					        <td>${id}</td>
					        <td>${description}</td>
					        <td>${topicBankName}</td>
					        <td>${type}</td>
					        <td>${difficulty}</td>
					        <td>${creator}</td>
					        <td>
					            <a href="javascript:;" onclick="preview('${id}')" class="tablelink">预览试题</a>&nbsp;&nbsp;
					           <!-- <a href="<%= basePath%>/front/TestPaperTopic_addF.action?id=${id}" class="tablelink">添加到试卷</a>  --> 
					        </td>
				        </tr> 
			        </s:iterator>
		        </tbody>
		    </table>
        </form>
        
  </div>  
      
       
	</div>
    
    <!-- 分页菜单组件--------------------------开始 -->
<%
//查询的url地址，统一写
String listActionURL = basePath+"/front/FillTopic_list.action";
%>
    
<script type="text/javascript">
//分页组件
function change()
  {
  var url = "<%= basePath%>/front/FillTopic_list.action";                 //获取表单url
 	var textfield=document.getElementById("textfield").value;
 	var totalPage='${pageResult3.totalPage}';
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
var url = "<%= basePath%>/front/FliiTopic_list.action";                 //获取表单url
//首页
function first(){
	
   window.location.href  = url+"?page=1";
}
//上一页
function previous(){
    window.location.href  = url+"?page=${pageResult3.previousPageNumber}";
}
//下一页
function next(){
    window.location.href  = url+"?page=${pageResult3.nextPageNumber}";
}
//尾页
function last(){
  window.location.href  = url+"?page=${pageResult3.totalPage}";
}
</script>
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageResult3.total}</i>条记录 	<i class="blue">${pageResult3.totalPage}</i>页， 	当前显示第&nbsp;<i class="blue">${pageResult3.page}</i>页</div>
        <ul class="paginList">
           <c:choose>
			   <c:when test="${pageResult3.isFirst==true}"><li class="paginItem current"><a href="javascript:;">首页</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:first()" target="rightFrame">首页&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
           <c:choose>
		      <c:when test="${pageResult3.isFirst==true}"><li class="paginItem current"><a href="javascript:;">上一页</a></li></c:when>
		      <c:otherwise>
			      <li class="paginItem"><a href="javascript:previous()" target="rightFrame">上一页&nbsp;</a></li>
		      </c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult3.hasNext==true}">
				   <li class="paginItem"><a href="javascript:next()" target="rightFrame">下一页&nbsp;</a></li>
			   </c:when>
		       <c:otherwise><li class="paginItem current"><a href="javascript:;">下一页</a></li></c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult3.isLast==true}"><li class="paginItem current"><a href="javascript:;">尾页</a></li></c:when>
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

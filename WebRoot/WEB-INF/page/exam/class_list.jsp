<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户管理-班级列表</title>
	<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.2.6/themes/icon.css" />
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.ocupload-1.1.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
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
			var classId;
			$(".tablelinkdelete").click(function(){
			 	classId = $(this).attr("classId");
			  	$(".tip").fadeIn(200);
			 });
		  	$(".tiptop a").click(function(){
		  	$(".tip").fadeOut(200);
		});
		$(".sure").click(function(){
			$(".tip").fadeOut(100);
			window.location.href="<%= basePath%>/front/Group_delete.action?classId="+classId;
		});
		  	$(".cancel").click(function(){
		  		$(".tip").fadeOut(100);
			});
		});
	</script>
	<script type="text/javascript">
		window.onload = function(){
			$(".tablelist tbody tr").mouseover(function(){
				$(this).attr("style","background:#f5f5f5");
			});
			$(".tablelist tbody tr").mouseout(function(){
				$(this).attr("style","background:#ffffff");
			});
			tmBatch.loadBranches();
		}

		var tmBatch = {
			toggleBranch : function(obj){
				$("input[name='checkbox']").prop("checked", $(obj).prop("checked"));
			},

			addBranches : function(){
				$("input[name='checkbox']").each(function(idx, item){
					var classId = $(item).attr("classId");
					var className = $(item).attr("className");
					var is_me_checked = $(item).is(':checked') ;
					if(is_me_checked){
						tmBatch.addOneBranch(classId, className);
					}else{
						tmBatch.removeOneBranch(classId);
					}
				});
				window.parent.layer.msg('操作成功');
				window.location.reload();
			}, 

			addOneBranch : function(classId, className){
				var isExist = tmBatch.branchExsit(classId);
				if(!isExist){
					var shtml = [];
					shtml.push('<label>');
					shtml.push('<input type="hidden" name="classId" value="'+classId+'" /> ' + className );
					shtml.push('<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>');
					shtml.push('</label>');

					$('#div_link_branch', window.parent.document).append(shtml.join(""));
				}
			}, 

			doInsertBranch : function(obj){
				var classId = $(obj).attr("classId");
				var className = $(obj).attr("className");
				tmBatch.addOneBranch(classId, className);
				window.parent.layer.msg('操作成功');
				window.location.reload();
			},
			
			removeOneBranch : function(classId){
				$('#div_link_branch input[value='+classId+']', window.parent.document).parent().remove();
				window.parent.layer.msg('操作成功');
				window.location.reload();
			},

			loadBranches : function(){
				$("a.tm-a-branches").each(function(idx, item){
					var classId = $(item).attr("classId");
					var isExist = tmBatch.branchExsit(classId);
					if(isExist){
						$(item).html('<img src="<%=path%>/images/remove.png" />移除').attr("onclick","javascript:tmBatch.removeOneBranch('"+classId+"')").css({"color":"#f00"});
						$(item).parent().parent().children("td").first().html('<img src="<%=path%>/images/gou.png" />');
					}
				});
			},
			
			branchExsit : function(classId){
				return $('#div_link_branch input[value='+classId+']', window.parent.document).length>0;
			}
		};
	</script>
	
</head>
<body>
    
    <div class="formbody">
	    <div id="usual1" class="usual">
	      <div id="tab2" class="tabson">
	        <form action="<%= basePath%>/front/Group_list.action" method="post"  target="rightFrame">
	    	<ul class="seachform">
	    	    <li><label>综合查询</label><input class="scinput" name="group.className" placeholder="请输入要查找的班级名称"/></li>
	            <li><input name="" type="submit" class="scbtn" value="查询"/></li>
	        </ul>
	        </form> 
	        
		    <table class="tablelist">
		    	<thead>
			    	<tr>
			    	<th width="8%"><input id="all" type="checkbox" value="" onclick="selectAll()"/>全选</th>
			    	<th width="8%">班级ID</th>
			        <th>班级名称</th>
			        <th width="10%">年级</th>
			        <th>学院</th>
			        <th width="10%">学生人数</th>
			        <th>操作</th>
			        </tr>
		        </thead>
		        <tbody>
			        <s:iterator value="pageResult.data" id="id">
				        <tr>
					        <td><input name="checkbox" type="checkbox" classId="${classId}" className="${className}" /></td>
					        <td>${classId}</td>
					        <td>${className}</td>
					        <td>${grade}</td>
					        <td>${institute}</td>
					        <td><a href="<%= basePath%>/front/Student_getlistByClassId.action?classId=${classId}"><b><u>${studentNumber}</u></b></a></td>
					        <td>
					            <a href="javascript:void(0);" class="tm-a-branches" classId="${classId}" className="${className}" onclick="javascript:tmBatch.doInsertBranch(this)"><img src="<%=path%>/images/add1.png" />选择</a>
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
	String listActionURL = basePath+"/front/Group_list.action";
	%>
	 
    <script type="text/javascript">
		//分页组件
		function change()
		  {
		  	var url = "<%= basePath%>/front/Group_list.action";  
		 	var textfield=document.getElementById("textfield").value;
		 	var totalPage = '${pageResult.totalPage}';
		 	var pageNum = 0;
		 	if(totalPage*1 >= textfield*1){
		 		pageNum = textfield; 
		 		window.location.href=url+"?page="+pageNum;
		 	}else{
		 		pageNum = totalPage; 
		 		alert("当前只有"+totalPage+"页");
		 	}
		  }
	</script>
	<script type="text/javascript">
		var url = "<%= basePath%>/front/Group_list.action";            //获取表单url
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
    	<div class="message"><input type="button" value="批量插入" class="scbtn" onclick="javascript:tmBatch.addBranches();"/>
    	共<i class="blue">${pageResult.total}</i>条记录 	<i class="blue">${pageResult.totalPage}</i>页， 	当前显示第&nbsp;<i class="blue">${pageResult.page}</i>页</div>
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

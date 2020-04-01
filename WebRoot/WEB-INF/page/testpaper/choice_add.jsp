<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理——选择题列表</title>
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
		window.location.href="<%= basePath%>/front/ChoiceTopic_delete.action?choiceTopic.id="+id;
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
	      content: '<%= basePath%>/front/ChoiceTopic_openView.action?choiceTopic.id='+id,
	    });
	  }
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
					var choiceId = $(item).attr("choiceId");
					var description = $(item).attr("description");
					var is_me_checked = $(item).is(':checked') ;
					if(is_me_checked){
						tmBatch.addOneBranch(choiceId, description);
					}else{
						tmBatch.removeOneBranch(choiceId);
					}
				});
				window.parent.layer.msg('操作成功');
				window.location.reload();
			}, 

			addOneBranch : function(choiceId, description){
				var isExist = tmBatch.branchExsit(choiceId);
				if(!isExist){
					var shtml = [];
					shtml.push('<div class="choice">');
					shtml.push('分值：');
					shtml.push('<input type="text" name="choicescore" class="tm_qscore"/>');
					shtml.push('<input type="hidden" name="choiceId" value="'+choiceId+'" /> ' + description );
					shtml.push('<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>');
					shtml.push('</div>');

					$('#div_link_branch', window.parent.document).append(shtml.join(""));
				}
			}, 

			doInsertBranch : function(obj){
				var choiceId = $(obj).attr("choiceId");
				var description = $(obj).attr("description");
				tmBatch.addOneBranch(choiceId, description);
				window.parent.layer.msg('操作成功');
				window.location.reload();
			},
			
			removeOneBranch : function(choiceId){
				$('#div_link_branch input[value='+choiceId+']', window.parent.document).parent().remove();
				window.parent.layer.msg('操作成功');
				window.location.reload();
			},

			loadBranches : function(){
				$("a.tm-a-branches").each(function(idx, item){
					var choiceId = $(item).attr("choiceId");
					var isExist = tmBatch.branchExsit(choiceId);
					if(isExist){
						$(item).html('<img src="<%=path%>/images/remove.png" />移除').attr("onclick","javascript:tmBatch.removeOneBranch('"+choiceId+"')").css({"color":"#f00"});
						$(item).parent().parent().children("td").first().html('<img src="<%=path%>/images/gou.png" />');
					}
				});
			},
			
			branchExsit : function(choiceId){
				return $('#div_link_branch input[value='+choiceId+']', window.parent.document).length>0;
			}
		};
	</script>
</head>
  
  <body>
    <div class="formbody">
	    <div id="usual1" class="usual">
	     	 <div id="tab2" class="tabson">
		     	<form action="<%=basePath%>/front/Testpaper_openChoiceTopicList.action" method="post">
			    	<ul class="seachform">
			    	    <li><label>综合查询</label><input class="scinput1" name="choiceTopic.description"  placeholder="请输入试题关键词"></li>
			    	    <li><label>所属题库</label>
				           <select name="choiceTopic.topicBankName" id="choiceTopic.topicBankName" onchange="selectValue(this)"  class="scinput1" >
				            	<option> </option>
				            <c:forEach items="${session.ChoiceTopicBankNameList}" var="ChoiceTopicBankNameList">
				                <option>${ChoiceTopicBankNameList}</option>
				            </c:forEach>
				           </select>
					    </li>
			            <li><input name="" type="submit" class="scbtn" value="查询"/></li>
		            </ul>
		        </form>
		        <form action="<%=basePath%>/front/TestPaperTopic_addC.action">
				    <table class="tablelist ">
				    	<thead>
					    	<tr >
						        <th width="8%"><input type="checkbox" id="all" value="" onclick="selectAll()"/>全选</th>
						        <th>试题编号</th>
						        <th width="20%">试题题干</th>
						        <th>所属题库</th>
						        <th>试题类型</th>
						        <th>试题难度</th>
						        <p:permissions menu="deleteRole,editRole">
						        <th>操作</th>
						        </p:permissions>
					        </tr>
				        </thead>
				        <tbody>
				        <s:iterator value="pageResult2.data" id="id">
					        <tr>
						        <td><input name="checkbox" type="checkbox" choiceId="${id}" description="${description}"/></td>
						        <td>${id}</td>
						        <td>${description}</td>
						        <td>${topicBankName}</td>
						        <td>${type}</td>
						        <td>${difficulty}</td>
						        <td>
						            <a href="javascript:;" onclick="preview('${id}')" class="tablelink">预览试题</a>&nbsp;&nbsp;
						            <a href="javascript:void(0);" class="tm-a-branches" choiceId="${id}" description="${description}" onclick="javascript:tmBatch.doInsertBranch(this)"><img src="<%=path%>/images/add1.png" />选择</a>
						      </td>
					        </tr> 
				        </s:iterator>
				        </tbody>
		  	 	 </table>
		      </form>
		        
 	 	  </div>  
	 </div>
	 
	   <div class="pagin">
    	<div class="message"><input type="button" value="批量插入" class="scbtn" onclick="javascript:tmBatch.addBranches();"/>
    	共<i class="blue">${pageResult2.total}</i>条记录 	<i class="blue">${pageResult2.totalPage}</i>页， 	当前显示第&nbsp;<i class="blue">${pageResult2.page}</i>页</div>
        <ul class="paginList">
           <c:choose>
			   <c:when test="${pageResult2.isFirst==true}"><li class="paginItem current"><a href="javascript:;">首页</a></li></c:when>
		       <c:otherwise>
			       <li class="paginItem"><a href="javascript:first()" target="rightFrame">首页&nbsp;</a></li>
		       </c:otherwise>
		   </c:choose>
           <c:choose>
		      <c:when test="${pageResult2.isFirst==true}"><li class="paginItem current"><a href="javascript:;">上一页</a></li></c:when>
		      <c:otherwise>
			      <li class="paginItem"><a href="javascript:previous()" target="rightFrame">上一页&nbsp;</a></li>
		      </c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult2.hasNext==true}">
				   <li class="paginItem"><a href="javascript:next()" target="rightFrame">下一页&nbsp;</a></li>
			   </c:when>
		       <c:otherwise><li class="paginItem current"><a href="javascript:;">下一页</a></li></c:otherwise>
		   </c:choose>
           <c:choose>
			   <c:when test="${pageResult2.isLast==true}"><li class="paginItem current"><a href="javascript:;">尾页</a></li></c:when>
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
	String listActionURL = basePath+"/front/Testpaper_openChoiceTopicList.action";
	%>
	<script type="text/javascript">
	//分页组件
	function change()
	  {
	  var url = "<%= basePath%>/front/Testpaper_openChoiceTopicList.action";                 //获取表单url
	 	var textfield=document.getElementById("textfield").value;
	 	var totalPage='${pageResult2.totalPage}';
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
	var url = "<%= basePath%>/front/Testpaper_openChoiceTopicList.action";                 //获取表单url
	//首页
	function first(){
		
	   window.location.href  = url+"?page=1";
	}
	//上一页
	function previous(){
	    window.location.href  = url+"?page=${pageResult2.previousPageNumber}";
	}
	//下一页
	function next(){
	    window.location.href  = url+"?page=${pageResult2.nextPageNumber}";
	}
	//尾页
	function last(){
	  window.location.href  = url+"?page=${pageResult2.totalPage}";
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

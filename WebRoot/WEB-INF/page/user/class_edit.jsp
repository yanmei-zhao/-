<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改班级信息</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>

<script type="text/javascript">
</script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
  $(function() {
    var grade="${group.grade}";
   $("select[name='grade']").find("option[value='"+grade+"']").attr("selected",true);
    var institute="${group.institute}";
   $("select[name='institute']").find("option[value='"+institute+"']").attr("selected",true);
   });
</script>

</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">班级基本信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>班级基本信息</span></div>
    <form action="<%= basePath%>/front/Group_update.action" method="post" id="commonform" autocomplete="off">
	    <ul class="forminfo">
	    <input name=classId id="classId" type="hidden" value="${group.classId}" />
	    <li><label>班级Id</label><label style="width:50%">${group.classId}</label></li>
	    <li><label>班级名称</label><input name="group.className" id="className" type="text"  class="dfinput" value="${group.className}" /></li>
	    <li><label>年级</label>
	           <select name="grade" id="grade" onchange="selectValue(this)"  class="dfinput" required="required">
	                <option value="2015级">2015级</option>
	                <option value="2016级">2016级</option>
	                <option value="2017级">2017级</option>
	                <option value="2018级">2018级</option>
	         </select>
	     </li>
	    <li><label>学院</label>
	          <select name="institute" id="institute" onchange="selectValue(this)"  class="dfinput">
	                <option value="大数据与软件工程学院">大数据与软件工程学院</option>
	                <option value="电子与信息工程学院">电子与信息工程学院</option>
	                <option value="文学与传媒学院">文学与传媒学院</option>
	                <option value="教师教育学院">教师教育学院</option>
	                <option value="外国语学院">外国语学院</option>
	                <option value="宝石与艺术学院">宝石与艺术学院</option>
	                <option value="商学院">商学院</option>
	                <option value="马克思主义学院">马克思主义学院</option>
	                <option value="法学与公共管理学院">法学与公共管理学院</option>
	                <option value="机械与材料工程学院&化学与资源再利用学院">机械与材料工程学院&化学与资源再利用学院</option>
	          </select><i>
	    </li>
	    <li><label>班级人数</label><input name="studentNumber" id="studentNumber" type="text"  class="dfinput" value="${group.studentNumber}" readonly="readonly"/></li>
	      <li><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>

</body>

</html>
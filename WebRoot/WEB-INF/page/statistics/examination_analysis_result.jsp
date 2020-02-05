<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考试分析</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/echarts.min.js"></script>
<script type="text/javascript">
     $(function(){

		//如果是新增成功，会返回1，如果是1，则提示保存成功
		if("1" == "${actionState}"){
			alert('保存成功！');
		}
         $("#commonform").validate({
             errorClass: "errorInfo", //默认为错误的样式类为：error
             focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
             onkeyup: false,   
             submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
			 checkFrom();
                 form.submit();   //提交表单   
             },   
             rules:{
                 "exam.examName":{
                     required:true,
                 },
             },
             messages:{
                 "exam.examName":{
                     required:"必填",
                 },
               }
         });    
     });
</script>
<script type="text/javascript">
	 $(function() {
	 	 var examName="${exam.examName}";
	  	$("select[name='exam.examName']").find("option[value='"+examName+"']").attr("selected",true);
	 }
</script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">统计分析</a></li>
		    <li><a href="#" style="cursor:default">考试分析</a></li>
	    </ul>
    </div>
    
    <div class="formbody" id="tab1">
    
    <div class="formtitle"><span>考试分析</span></div>
	    <form action="<%= basePath%>/front/Statistics_getScoreSituation.action" method="post" id="commonform">
		    <ul class="forminfo">
			      <li><label>选择试卷</label>
			           <select name="exam.examName" id="exam.examName" onchange="selectValue(this)"  class="dfinput">
			               <option> </option>
			            <c:forEach items="${session.examNameList}" var="examNameList">
			                <option>${examNameList}</option>
			            </c:forEach>
			          </select><i><font color="#FF0000">*必填</font></i>
		     	 </li>
		    </ul>
		    <ul class="forminfo">
			    <li>
			    <label>&nbsp;</label><input name="" type="submit" class="btn" value="开始统计"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    </li>
		    </ul>
	    </form>
    
	 <div id="summary" style="width:48%;height:250px;display:none"></div>
	 
    <script type="text/javascript">
    	document.getElementById("summary").style.display = 'block';
    	var maxScore = '<%=session.getAttribute("maxScore")%>';
		var minScore = '<%=session.getAttribute("minScore")%>';
		var avgScore = '<%=session.getAttribute("avgScore")%>';
		var examName = '<%=session.getAttribute("examName")%>';
        var myChart = echarts.init(document.getElementById('summary'));
        var option = {
		 title: {
		        text: '考试统计分析',
		    },
		    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    legend: {
		        data: ['最高分', '最低分','平均分'],
		         textStyle:{fontSize:"14"}
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        boundaryGap: [0, 0.01]
		    },
		    yAxis: {
		        type: 'category',
		        data: [examName],
		    },
		    series: [
		        {
		            name: '最高分',
		            type: 'bar',
		            stack:'总量',
		            label:{
		            	show:true,
		            	position: 'insideRight'
		            },
		            data: [maxScore]
		        },
		        {
		            name: '最低分',
		            type: 'bar',
		             label:{
		            	show:true,
		            },
		            data: [minScore]
		        },
		        {
		            name: '平均分',
		            type: 'bar',
		            label:{
		            	show:true,
		            	position:'inside'
		            },
		            data: [avgScore]
		        }
		    ]
		};
        myChart.setOption(option);
    </script>

    
    </div>

</body>

</html>

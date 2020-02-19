<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <base href="<%= basePath%>"/>
	<title>线上考核系统</title>
	<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/echarts.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
	<script type="text/javascript">
		$(function(){
			var url = "<%= basePath%>/biz/ServiceTourProduct_getTotalNumber.action";
			$.post(url,{"type":1},function(data){
				$("#product").html(data);
			},"json");
		
			$.post(url,{"type":2},function(data){
				$("#tour").html(data);
			},"json");
			
			$.post("<%= basePath%>/biz/ServiceTripMate_getTotalTripMate.action",function(data){
				$("#tripMate").html(data);
			},"json");
			
			$.post("<%= basePath%>/biz/ServiceRaiders_getTotalRaiders.action",function(data){
				$("#raiders").html(data);
			},"json");
		});	
	</script>
	<script type="text/javascript">
	 function new1(){
     layer.open({
     	 type: 1,
     	 title: '创建题库',
     	 area: ['400px', '200px'],
     	 shadeClose: true, //点击遮罩关闭
         content: '\<\div style="padding:10px;font-size:10pt;line-height:25px;">1.题库为一种试题按类型分组的形式。 <br>2.题库可以理解为一门学科，即按照学科的名称命名试题库。  <br>3.一个题库按试题类型区分，即一个题库只包含一种类型题目。\<\/div>',
        });
     };
     function new2(){
     layer.open({
     	 type: 1,
     	 title: '添加试题',
     	 area: ['400px', '200px'],
     	 shadeClose: true, //点击遮罩关闭
         content: '\<\div style="padding:10px;font-size:10pt;line-height:25px;">1.系统默认支持3种题型：单选题，填空题，简答题。<br>2.试题创建支持手动单题创建和批量导入（excel）。<br>\<\/div>',
        });
     };
     function new3(){
     layer.open({
     	 type: 1,
     	 title: '创建试卷',
     	 area: ['400px', '200px'],
     	 shadeClose: true, //点击遮罩关闭
         content: '\<\div style="padding:10px;font-size:10pt;line-height:25px;">1.系统支持教师用户自己手动创建，也可以随机快速创建试卷。<br>2.试卷中的客观题会在考生交卷后自动批改。<br>3.试卷中的主观题需要手工批改。\<\/div>',
        });
     };
     function new4(){
     layer.open({
     	 type: 1,
     	 title: '查看结果',
     	 area: ['400px', '200px'],
     	 shadeClose: true, //点击遮罩关闭
         content: '\<\div style="padding:10px;font-size:10pt;line-height:25px;">1.考试结束后，教师用户可以查看学生考试成绩。<br>2.教师和管理员可以导出学生成绩。<br>3.统计分析功能可以分析考试。\<\/div>',
        });
     };
</script>
</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					首页
				</li>
			</ul>
		</div>

		<div class="mainindex">
			<%String userName=(String)request.getSession().getAttribute("userName"); %>
			<div class="t_container">
				<div class="t_container1">
					<span><img src="images/sun.png" alt="天气" /></span>
					<b>${userName}您好，欢迎使用线上考核系统</b>
				</div>
			</div>
			
			<div class="t_container">
				<dl class="t_welcome_box1">
					<div class="t_all" style="background:#ddd">
						<h1><u><a href="<%= basePath%>/front/Testpaper_list.action" target="rightFrame"><%=session.getAttribute("testPaperNum")%></a></u></h1>
						<h2>总试卷数</h2>
					</div>
					<div class="t_all" style="background:#eee">
						<h1><u><%=session.getAttribute("studentNum")%></u></h1>
						<h2>总用户数</h2>
					</div>
					<div class="t_all" style="background:#eee">
						<h1><u><a href="<%= basePath%>/front/TopicBank_list.action" target="rightFrame"><%=session.getAttribute("topicBankNum")%></a></u></h1>
						<h2>总题库数</h2>
					</div>
					<div class="t_all" style="background:#ddd">
						<h1><u><a href="<%= basePath%>/front/Course_list.action" target="rightFrame"><%=session.getAttribute("courseNum")%></a></u></h1>
						<h2>总课程数</h2>
					</div>
				</dl>
				<div id="summary" class="t_welcome_boxb">
					    <script type="text/javascript">
					    	var choiceNum = '<%=session.getAttribute("choiceNum")%>';
					    	var fillNum = '<%=session.getAttribute("fillNum")%>';
					    	var topicNum = '<%=session.getAttribute("topicNum")%>';
					    	var multipleNum = '<%=session.getAttribute("multipleNum")%>';
					    	var judgeNum = '<%=session.getAttribute("judgeNum")%>';
					        var myChart = echarts.init(document.getElementById('summary'));
					        var option = {
							    title: {
							        text: '系统试题类型汇总统计',
							        left: 'center'
							    },
							    tooltip: {
							        trigger: 'item',
							        formatter: '{a} <br/>{b} : {c} ({d}%)'
							    },
							    legend: {
							        orient: 'vertical',
							        right:30,
							        top:'center',
							        data: ['单选题', '填空题', '简答题', '多选题', '判断题'],
							        center: ['55%', '50%'],
							        textStyle:{fontSize:"13"},
							    },
							    series: [
							        {
							            name: '访问来源',
							            type: 'pie',
							            radius: '55%',
							            roseType: 'angle',//设置图标类型
							            center: ['40%', '50%'],
							            data: [
							                {value: choiceNum, name: '单选题'},
							                {value: fillNum, name: '填空题'},
							                {value: topicNum, name: '简答题'},
							                {value: multipleNum, name: '多选题'},
							                {value: judgeNum, name: '判断题'},
							            ],
							            emphasis: {
							                itemStyle: {
							                    shadowBlur: 10,
							                    shadowOffsetX: 0,
							                    shadowColor: 'rgba(0, 0, 0, 0.5)'
							                }
							            }
							        }
							    ]
							};
					        myChart.setOption(option);
					    </script>
				</div>
           </div>
			
		   <div class="t_container">
				<dl class="t_welcome_box">
					<dt>
						<span><img src="images/dp.png" alt="提醒" /></span>
						<b>服务器运行状态</b>
					</dt>
					<dd>
						<ul class="infolist1">
							<li><%  
							    double total = (Runtime.getRuntime().totalMemory()) / (1024.0 * 1024);  
							    double max = (Runtime.getRuntime().maxMemory()) / (1024.0 * 1024);  
							    double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024); 
							    out.println("最大内存量(当前JVM的最大可用内存): " + max + "MB<br/>"); %>
					    	</li> 
						    <li><%out.println("内存总量(当前JVM占用的内存总数): " + total + "MB<br/>"); %></li>
							<li><%  out.println("空闲内存量(当前JVM空闲内存): " + free + "MB<br/>");   %></li>
						    <li><%out.println("JVM实际可用内存: " + (max - total + free) + "MB<br/>");   %></li>
						    <jsp:useBean id="now" class="java.util.Date" scope="page"></jsp:useBean>
						    <li><%out.println("服务器当前时间:");%><fmt:formatDate value="${now }" pattern="yyyy年MM月dd日" /></li>
						</ul>
					</dd>
				</dl>
				<dl class="t_welcome_box">
					<dt>
						<span><img src="images/dp.png" alt="提醒" /></span>
						<b>系统帮助</b>
					</dt>
					<dd>
						<p style="text-align:center;margin-top:10px">快速组织考试？</p>
						<div class="t_step">
							<div class="t_step_item"><a href="javascript:;" onclick="new1()"><img src="images/topicbank.png" />创建题库</a></div>
							<div class="t_step_pointer"><img src="images/jiantou.png" /></div>
							<div class="t_step_item"><a href="javascript:;" onclick="new2()"><img src="images/topic.png" />添加试题</a></div>
							<div class="t_step_pointer"><img src="images/jiantou.png" /> </div>
							<div class="t_step_item"><a href="javascript:;" onclick="new3()"><img src="images/testpaper.png" />创建试卷</a></div>
							<div class="t_step_pointer"><img src="images/jiantou.png" /></div>
							<div class="t_step_item"><a href="javascript:;" onclick="new4()"><img src="images/result.png" />查看结果</a></div>
						</div>
					</dd>
				</dl>
		 </div>
			
			<div class="t_container">
				
				
			</div>
			

			
			<!--<div class="uimakerinfo">
				<b>技术支持：
				<a href="#" target="_blank">梧州学院 软件开发中心</a>
				</b>
			</div>

			<div class="xline">
			</div>  -->

		</div>

	</body>

</html>

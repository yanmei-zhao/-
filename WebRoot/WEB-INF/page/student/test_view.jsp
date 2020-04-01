<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.gxuwz.Market.business.entity.*" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>试卷页</title>

<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=path %>/css/bootstrap-admin-theme.css">
<link rel="stylesheet" href="<%=path %>/css/process.css">
<link rel="stylesheet" href="<%=path %>/css/self.css">
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
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
	window.onload = function(){
		setInterval(function (){
				var remainTime=document.getElementById("remainTime").getElementsByTagName("span");
				var remainTime1=document.getElementById("remainTime1").getElementsByTagName("span");
				var examStart='${session.exam.examStart}';//获取后台存的值
				var examEnd='${session.exam.examEnd}';
				var now = new Date();//当前时间
				var time2 = Date.parse(examEnd);//转换成时间戳
				var now1 = Date.parse(now);//转换成时间戳
				var num =time2- now1;////最后时间-当前时间
				if(num>0){
					var minute=parseInt(num/(60*1000));//转换成秒
					 num=num%(60*1000);
				     var seconde=parseInt(num/1000);
				     remainTime[0].innerHTML=minute;
					 remainTime[1].innerHTML=seconde;
					  remainTime1[0].innerHTML=minute;
					 remainTime1[1].innerHTML=seconde;
				}else{
					   document.getElementById("form").submit();
				}
			}, 100)
		}
</script>
<script type="text/javascript">
	//交卷提示
	$(document).ready(function(){
		var id;
		$(".tablelinkdelete").click(function(){
			id = $(this).attr("id");
			if(window.confirm("是否确定交卷，是请点击确定，否则点击取消")){
				document.getElementById("form").submit();
				alert("提交成功");
			} 
		});
	});
</script>
  </head>
  	
  <body class="bootstrap-admin-with-small-navbar">
  	
  		<form id="form" class="form-horizontal" action="<%= basePath%>/front/ExamQuestionAnswer_putAnswer.action" method="post" autocomplete="off"> 
		<!-- content -->
            <div class="col-md-10" style="float:left">
            
            	<!-- 试卷信息头 -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">试卷信息</div>
                            </div>
                            <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <div class="col-lg-12 form-group">
                                        <label class="col-lg-6 control-label" for="query_ano" style="margin-left:70px;"><h2>${session.testpaper.testpaperName}<h2></label>
                                    </div>
                                    <div class="col-lg-12 form-group">
                                        <label class="col-lg-6 control-label" for="query_ano" style="margin-left:30px;"><i>(卷面总分:${session.testpaper.totalScore}分)</i></label>
                                    </div>
                                      <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">课程:</label>
                                         <input type="hidden" id="test_subjectId" value="<s:property value="#request.subject.subjectId"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i><s:property value="#request.subject.course.courseName"/>计算机网络</i></label>
                                    </div>
                                    
                                     <input type="hidden" name="exam.examName" id="exam.examName" value="<s:property value="exam.examName"/>">
                                     <input type="hidden" name="exam.examId" id="exam.examId" value="<s:property value="exam.examId"/>">
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考试时间:</label>
                                        	<input type="hidden" name="testpaper.totalScore" id="testpaper.totalScore00000" value="<s:property value="exam.examDuration"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${session.exam.examDuration}分钟</i></label>
                                    </div>
                                    
                                    <div class="col-lg-3 form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  考生姓名:</label>
                                        <input type="hidden" name="studentId" id="studentId" value="<s:property value="#session.studentId"/>">
                                          <label class="col-lg-6 control-label" for="query_bno1"><i>${userName}</i> </label>
                                    </div>
                                    
                                    <div class="col-lg-3  form-group">
                                        <label class="col-lg-6 control-label" for="query_bno1">|  剩余时间:</label>
                                          <label class="col-lg-6 control-label" for="query_bno1" id="remainTime"><span></span>分<span></span>秒</label>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 试卷信息头 -->
                
                <!-- 试卷主体 -->
                <div class="row">
                      <c:set var="index" value="1"/><!--统计题目 -->
                            <!---在此插入信息-->
                        <s:if test="result1.data!=null">
                            	<!--单选题 -->
	                            <s:iterator value="result1.data" id="id">    
	                              <div class="col-md-12" id="id_<s:property value="#id[6]"/>">
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【<s:property value="#id[8]"/>分】</div>
	                         			      	 	 <input name="choiceTopicId" type="hidden" value='<s:property value="#id[6]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>" id="answer" value="A"/>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>" id="answer" value="B"/>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>"  id="answer" value="C"/>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="radio" name="answer_<s:property value="#id[6]"/>"  id="answer" value="D"/>D. <s:property value="#id[5]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                        </s:if>
                            
                        <s:if test="result4.data!=null">
                            	<!--多选题 -->
	                            <s:iterator value="result4.data" id="id">   
	                               <div class="col-md-12" id="id_<s:property value="#id[6]"/>"> 
	                        				<div class="panel panel-default">
	                        			    	<div class="panel-heading">
	                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【<s:property value="#id[8]"/>分】</div>
	                         			      	 	 <input name="multipleTopicId" type="hidden" value='<s:property value="#id[6]"/>'/>
	                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
	                         				  	</div>
	                            			<div class="bootstrap-admin-panel-content">
			                                	<ul>
			                                	    <div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>" id="answer" value="A"/>A. <s:property value="#id[2]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>" id="answer" value="B"/>B. <s:property value="#id[3]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>"  id="answer" value="C"/>C. <s:property value="#id[4]"/>
													  </label>
													</div>
													<div class="radio">
													  <label>
													    <input type="checkbox" name="answer_<s:property value="#id[6]"/>"  id="answer" value="D"/>D. <s:property value="#id[5]"/>
													  </label>
													</div>
			                               		 </ul>
	                           			 	</div>
	                       		 		</div>
	                 			   </div>
	                            </s:iterator>
                        </s:if>
                            
                        <s:if test="result2.data!=null">
                           	<!--填空题 -->
                            <s:iterator value="result2.data" id="id">  
                               <div class="col-md-12" id="id_<s:property value="#id[2]"/>">  
                        				<div class="panel panel-default">
                        			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index}.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【<s:property value="#id[4]"/>分】</div>
                         			      	 	<input name="fillTopicId" type="hidden" value='<s:property value="#id[2]"/>'/>
                         			      	   <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				  	</div>
                            			<div class="bootstrap-admin-panel-content">
                            				<input name="answer_<s:property value="#id[2]"/>" style="-webkit-border-radius:3px;height:30px;width:300px;border:solid 1px #a7b5bc;text-indent:10px;" type="text" placeholder="请在此输入答案">
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                        </s:if> 
                             
                        <s:if test="result3.data!=null">
                            	<!-- 判断题 -->
                            <s:iterator value="result3.data" var="id">    
                              <div class="col-md-12" id="id_<s:property value="#id[2]"/>">
                        			<div class="panel panel-default">
                       			    	<div class="panel-heading">
                         			      	 <div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)</div>
                         			      	 <input name="judgeTopicId" type="hidden" value='<s:property value="#id[2]"/>'/>
                         			      	 <c:set var="index" value="${index+1}"/><!--统计题目 -->
                       				  	</div>
                            			<div class="bootstrap-admin-panel-content">
		                                	<ul>
		                                	  <div class="radio">
												  <label>
												    <input type="radio" name="answer_<s:property value="#id[2]"/>" id='options_<s:property value="#id[2]"/>' value="正确">正确
												  </label>
												</div>
												<div class="radio">
												  <label>
												    <input type="radio" name="answer_<s:property value="#id[2]"/>" id='options_<s:property value="#id[2]"/>' value="错误">错误
												  </label>
												</div>
		                               		 </ul>
                           			 	</div>
                       		 		</div>
                 			   </div>
                            </s:iterator>
                        </s:if>     
                             
                        <s:if test="result.data!=null">
                           	<!--简答题 -->
                            <s:iterator value="result.data" id="id">    
                              <div class="col-md-12" id="id_<s:property value="#id[2]"/>">
                       				<div class="panel panel-default">
                       			    	<div class="panel-heading">
                         			      	<div class="text-muted bootstrap-admin-box-title">${index }.<s:property value="#id[0]"/>?(<s:property value="#id[1]"/>)【<s:property value="#id[4]"/>分】</div>
                       			      	 	 <input name="topicId" type="hidden" value='<s:property value="#id[2]"/>'/>
                       			      	     <c:set var="index" value="${index+1 }"/><!--统计题目 -->
                         				</div>
                            			<div class="bootstrap-admin-panel-content">
                            				<textarea name="answer_<s:property value="#id[2]"/>" rows="3" cols="100" placeholder="请在此输入答案" style="-webkit-border-radius:3px;border:solid 1px #a7b5bc;text-indent:10px;"></textarea>
                           			 	</div>
                     		 		</div>
                 			  </div>
                            </s:iterator>
                       </s:if>  
           		  </div> 
           		  <!-- 试卷主体 -->
	    	</div>
	    	<!-- content -->
	    	
	    	<!-- 题目导航 -->
	    	<div id="div_processor" style="left: 659px; top:20px;margin-left:425px;;">
				<div id="div_processor_timer">
					<div>题目导航</div>
				</div>
				<div id="div_processor_fastto">
					 <c:set var="index1" value="1"/>
					<s:iterator value="result1.data" var="id" status="st">
						<a href="#id_<s:property value="#id[6]"/>" >${index1 }</a>
						<c:set var="index1" value="${index1+1 }"/>
					</s:iterator>
					<s:iterator value="result4.data" var="id" status="st">
						<a href="#id_<s:property value="#id[6]"/>" >${index1}</a>
						<c:set var="index1" value="${index1+1 }"/>
					</s:iterator>
					<s:iterator value="result2.data" var="id" status="st">
						<a href="#id_<s:property value="#id[2]"/>" >${index1}</a>
						<c:set var="index1" value="${index1+1 }"/>
					</s:iterator>
					<s:iterator value="result3.data" var="id" status="st">
						<a href="#id_<s:property value="#id[2]"/>" >${index1}</a>
						<c:set var="index1" value="${index1+1 }"/>
					</s:iterator>
					<s:iterator value="result.data" var="id" status="st">
						<a href="#id_<s:property value="#id[2]"/>">${index1}</a>
						<c:set var="index1" value="${index1+1 }"/>
					</s:iterator>
				</div>
				
				<div style="margin-top:17px; margin-left:12px;text-align:center">
					<div>
						<div style="width: 17px; float:left;margin-left:10px;height: 17px; background: white; border:solid 1px #ddd;"></div>
						<div style="float:left; margin-left:6px;"><label style="margin:0">未做答</label></div>
					</div>
					<div>
						<div style="width: 17px;margin-left:20px; float:left;height: 17px; background: blue;"></div>
						<div style="float:left;margin-left:6px;"><label>已做答</label></div>
					</div>
				</div>
				
				<div id="div_processor_ops">
					<input type="button" id="putAnswer" style=" text-align:center" class="tablelinkdelete btn btn-primary" onclick="" value="交卷"/>
				</div>
				
				<div class="time">
	    			<div><label>剩余时间</label></div>
	    			<h2><label id="remainTime1"><span></span>分<span></span>秒</label></h2>
	    		</div>
		  </div>
	    	
    	</form>
    	
  <script type="text/javascript">

		var tm_pid = "48caba57-e11f-449f-8948-b14a1f27317d";
		var tm_uid = "6fcb9dcd-702c-4a21-8a0e-6ab69a7d82c4";
		var tm_layerid = 0;
		var tm_arr_markers = [];


		$(document).ready(function() {
			tmUserPaper.initPaper();
			$(".tm_paper_section h1").click(function(){
				$(this).parent().children(".tm_paper_question").toggle();
			});
			tm_resetPosition();
			tmUserDataCache.removeCache(tm_uid, tm_pid);
		});

		function tm_resetPosition(){
			var nw = $(".tm_paper_head").width() + 45;
			$("#div_processor").css("left",nw + "px");
		}

		$(window).resize(function(){
			tm_resetPosition();
		});
		 
		$(window).scroll(function(){
			var tp = $(window).scrollTop();
			if(tp > 240){
				$("#div_processor").css("top", "20px");
			}else{
				var ntp = 240 - tp;
				$("#div_processor").css("top", ntp + "px");
			}
		});
	
		//创建弹出层
		function makeAddForm(qid, userkey){
			var tm_html_options = [];
			tm_html_options.push('<select class="tm_select" style="min-width:200px" name="c_tid">');
			
			tm_html_options.push('<select>');

			var html = [];
			html.push('<div style="margin:10px">');
			html.push('	<table width="100%" cellpadding="5" border="0" class="tm_table_form">');
			html.push('	<tr>');
			html.push('		<th width="100">所属分类</th>');
			html.push('		<td>'+tm_html_options+'</td>');
			html.push('	</tr>');
			html.push('	<tr>');
			html.push('		<th>收藏备注</th>');
			html.push('		<td><input type="text" class="tm_txt" size="50" maxlength="50" name="c_remark" /></td>');
			html.push('	</tr>');
			html.push('	<tr>');
			html.push('		<th></th>');
			html.push('		<td><button class="tm_btn tm_btn_primary" type="button" onclick="tmUserPaper.doAddFav();">提交</button></td>');
			html.push('	</tr>');
			html.push('	</table>');
			html.push('</div>');
			html.push('<input type="hidden" name="c_qid" value="'+qid+'" />');
			html.push('<input type="hidden" name="c_userkey" value="'+userkey+'" />');
			return html.join("");
		}
		

		
		var tmUserPaper = {
			initPaper : function(){
				$.each(tm_arr_markers, function(idx, item){
					if(item["value"]){
					
					}else{
						$("#fast_" + item["name"]).prop("class", "wrong");
					}
				});
			},


			moveToQuestion : function(qid){
				var thetop = $("#quick-Q-" + qid).offset().top;
				$("html:not(:animated),body:not(:animated)").animate({ scrollTop: thetop}, 500);
			},
			
			addFavorite : function(qid, userkey){
				tm_layerid = layer.open({
					title: '添加收藏',
					type: 1,
					area: ['500px', '250px'],
					shadeClose: true,
					content: makeAddForm(qid, userkey)
				});
			},
			
			doAddFav : function(){
				var c_remark = $("input[name='c_remark']").val();
				var c_tid = $("select[name='c_tid']").val();
				var c_qid = $("input[name='c_qid']").val();
				var c_userkey = $("input[name='c_userkey']").val();
				$.ajax({
					type: "POST",
					url: "http://demo-stnd.tomexam.com/user/collection/add.do",
					data: {"c_tid":c_tid, "c_uid":tm_uid, "c_qid":c_qid, "c_userkey":c_userkey, "c_remark":c_remark, "t":Math.random()},
					dataType: "json",
					success: function(ret){
						if(ret["code"] == "ok"){
							layer.msg('操作成功');
						}else if(ret["code"] == "has"){
							layer.msg('收藏已经存在，请勿反复操作');
						}else{
							layer.msg('操作失败');
						}
						layer.close(tm_layerid);
					},
					error:function(){
						alert('系统忙，请稍后再试');
					}
				}); 
			}
		};

		//本地缓存操作
		var tmUserDataCache = {
			support : function(){
				if(window.localStorage){
					return true;
				}else{
					return false;
				}
			},
			removeCache : function(uid, pid){
				if(!tmUserDataCache.support()){
					return;
				}
				var cacheKey = "C" + uid + pid;
				localStorage.removeItem(cacheKey);
			}
		};

		function tmPaperFont(i){
			$("#tm_font_1").removeClass("tm_font_on");
			$("#tm_font_2").removeClass("tm_font_on");
			$("#tm_font_3").removeClass("tm_font_on");
			$("#tm_font_"+i).addClass("tm_font_on");
	
			var v_font_size = "12px";
			var v_line_height = "20px";
			if(i==2){
				v_font_size = "18px";
				v_line_height = "30px";
			}else if(i ==3){
				v_font_size = "24px";
				v_line_height = "35px";
			}
			
			$(".tm_paper_question thead tr td.tm_question_lineheight").css({"font-size":v_font_size, "line-height":v_line_height});
			$(".tm_paper_question thead tr td.tm_question_lineheight *").css({"font-size":v_font_size, "line-height":v_line_height});
			$(".tm_paper_question tbody tr td *").css({"font-size":v_font_size, "line-height":v_line_height});

		}
  </script>
                
  	<!-- 分页菜单组件--------------------------结束 -->
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
	<!-- 交卷操作提示框------>
	  <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        <div class="tipinfo">
        	<span><img src="<%= basePath%>images/ticon.png" /></span>
	        <div class="tipright">
		        <p>是否确认交卷 ？</p>
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

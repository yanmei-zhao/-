<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试卷管理-配置试卷</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= path%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<style>
	#div_link_branch{display:none;}
	#judgeTab {display:none;}
	#blankTab{display:none;}
	#briefTab {display:none;}
	#mulTab{display:none;}
	#div_link_branch:target{display:block;}
	#judgeTab:target{display:block;}
	#blankTab:target{display:block;}
	#judgeTab:target{display:block;}
	#briefTab:target{display:block;}
	#mulTab:target{display:block;}
</style>
<script>
	var  _contextPath="<%=path%>";
	var  _modulePath=_contextPath+"/sys/";
	$(document).ready(function(e) {
	    $(".btn").click(function(){
			_sbmForm(_modulePath+"textures_add.action?view=list","");
			});
	});
</script>
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
                    "totalscore":{
                        required:true,
                    },
                    "passscore":{
                        required:true,
                    },
                },
                messages:{
                    "totalscore":{
                        required:"必填",
                    },
                    "passscore":{
                        required:"必填",
                    },
            }    
        });
    });
        </script>
        <script type="text/javascript">//动态实现二级联动
            function firstSel() {//如果第一个下拉列表的值改变则调用此方法
			var courseName = $("#courseName").val();//得到第一个下拉列表的值
				//通过ajax传入后台，把orderTypeName数据传到后端
				window.location.href="<%= basePath%>/front/TopicBank_gettopicBankName.action?courseName"+courseName;
				var url = "<%=basePath%>/front/TopicBank_gettopicBankName.action?courseName"+courseName;
			$.post("<%=basePath%>/front/TopicBank_gettopicBankName.action",{courseName:courseName});
			}
        </script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">试卷管理</a></li>
		    <li><a href="#">配置试卷</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
	    <div class="formtitle"><span>配置试卷</span></div>
	    	<div>
	    		<form action="<%= basePath%>/front/TestPaperTopic_add.action" method="post" id="commonform" autocomplete="off">
			    	<div class="t_head">
			    		<h1>${testpaper.testpaperName}</h1>
			    		<input name="testpaperName" type="hidden"  class="dfinput" value="${testpaper.testpaperName}"/></li> 
			    		<h2 style="background-color:#ddd;padding:5px 0;"><b>卷面总分设定：</b>${testpaper.totalScore}&nbsp;&nbsp;&nbsp;&nbsp; <b>及格分数设定：</b>${testpaper.passScore}</h2>
			    		<h2><b>当前卷面总分：</b> <input name="totalscore" type="text" class="t_text">&nbsp;&nbsp;&nbsp;&nbsp;<b>当前及格分数：</b><input name="passscore" type="text" class="t_text"></h2>
			    		<input name="testpaperId" type="hidden"  class="dfinput" value="${testpaper.testpaperId}"/></li> 
			    	</div>
				    <ul class="forminfo"> 
					      <li>
					       <div style="padding-left: 30px;padding-top:10px">
						        <input type="button" value="添加选择题" class="layui_btn"  onclick="preview('${testpaper.testpaperId}')"> 
						        <input type="button" value="添加填空题" class="layui_btn"  onclick="preview1('${testpaper.testpaperId}')"> 
						        <input type="button" value="添加简答题" class="layui_btn"  onclick="preview2('${testpaper.testpaperId}')">
						        <input type="button" value="添加判断题" class="layui_btn"  onclick="preview3('${testpaper.testpaperId}')"> 
						        <input type="button" value="添加多选题" class="layui_btn"  onclick="preview4('${testpaper.testpaperId}')">  
						        <input type="button" value="计算总分" class="layui_btn"  onclick="tmPaper.countScore()">       
					       </div>
					      </li>
			         </ul>
				     
					<div class="row">
					    <div class="col">
					   	  <ul class="tabs tabs-fixed-width">
					        <li class="tab">
					        	<div class="div1"><a href="#div_link_branch">选择题</a></div>
				        		<div class="div2"><input type="button" value="清空" onclick="tm_clearBracnhes()" style="margin-top:12px;"/></div>
					        </li>
					        <li class="tab">
					        	<div class="div1"><a href="#blankTab">填空题</a></div>
				        		<div class="div2"><input type="button" value="清空" onclick="tm_clearBracnhes1()" style="margin-top:12px;" /></div>
					        </li>
					        <li class="tab">
					        	<div class="div1"><a href="#briefTab">简答题</a></div>
				        		<div class="div2"><input type="button" value="清空" onclick="tm_clearBracnhes2()" style="margin-top:12px;"/></div>
					        </li>
					        <li class="tab">
					        	<div class="div1"><a href="#judgeTab">判断题</a></div>
				        		<div class="div2"><input type="button" value="清空" onclick="tm_clearBracnhes3()" style="margin-top:12px;"/></div>
					        </li>
					        <li class="tab">
					        	<div class="div1"><a href="#mulTab">多选题</a></div>
				        		<div class="div2"><input type="button" value="清空" onclick="tm_clearBracnhes4()" style="margin-top:12px;"/></div>
					        </li>
					      </ul>
					    </div>
					    <div id="div_link_branch" class="s12"><!-- 单选题 选项卡 -->
					    	 <s:iterator value="result1.data" id="id">
					    	 	<div class="choice">
					    	 		分值：<input type="text" name="choicescore" class="tm_qscore" value='<s:property value="#id[8]"/>'/>
					    	 		<input type="hidden" name="choiceId" value='<s:property value="#id[6]"/>' /><s:property value="#id[0]"/>
					    	 		<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>
					    	 	</div>
					    	 </s:iterator>
					    </div>
					    <div id="blankTab" class="s12"><!-- 填空题 选项卡 -->
					    	<s:iterator value="result2.data" id="id">
					    		<div class="choice">
					    			分值：<input type="text" name="fillscore" class="tm_qscore" value='<s:property value="#id[4]"/>'/>
					    	 		<input type="hidden" name="fillId" value='<s:property value="#id[2]"/>' /><s:property value="#id[0]"/>
					    	 		<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>
					    	 	</div>
					    	 </s:iterator>
					    </div>
					    <div id="briefTab" class="s12"><!-- 简答题 选项卡 -->
					    	<s:iterator value="result.data" id="id">
					    		<div class="choice">
					    			分值：<input type="text" name="briefscore" class="tm_qscore" value='<s:property value="#id[4]"/>'/>
					    	 		<input type="hidden" name="topicId" value='<s:property value="#id[2]"/>' /><s:property value="#id[0]"/>
					    	 		<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>
					    	 	</div>
					    	</s:iterator>
					    </div>
					    <div id="mulTab" class="s12"><!-- 多选题 选项卡 -->
					    	<s:iterator value="result4.data" id="id">
					    	 	<div class="choice">
					    	 		分值：<input type="text" name="multiplescore" class="tm_qscore" value='<s:property value="#id[8]"/>'/>
					    	 		<input type="hidden" name="multipleId" value='<s:property value="#id[6]"/>' /><s:property value="#id[0]"/>
					    	 		<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>
					    	 	</div>
					    	 </s:iterator>
					    </div>
					    <div id="judgeTab" class="s12"><!-- 判断题 选项卡 -->
					    	<s:iterator value="result3.data" id="id">
					    		<div class="choice">
					    			分值：<input type="text" name="judgescore" class="tm_qscore" value='<s:property value="#id[4]"/>'/>
					    	 		<input type="hidden" name="judgeId" value='<s:property value="#id[2]"/>' /><s:property value="#id[0]"/>
					    	 		<a href="javascript:void(0);" onclick="javascript:tm_removeBranch(this)"><img src="<%=path%>/images/no.png" /></a>
					    	 	</div>
					    	 </s:iterator>
					    </div>
				  </div>
				     
			      <ul class="forminfo">
				      <li>
				        <label>&nbsp;</label><input style="margin-top:12px" name="add_btn" type="submit" class="btn" onclick="tmPaper.countScore()" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <label>&nbsp;</label><a href="<%= basePath%>/front/Testpaper_list.action"><input name="" type="button" class="btn" value="取消"/></a>
				      </li>
			     </ul> 
   		 		</form>
	    	</div>
   		 
 	 </div>
    
        <script type="text/javascript">
		//===============题目选择器===============
		//预览选择题列表页面（弹窗显示）
		  function preview(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加选择题',
		       maxmin:true,
		      area: ['1100px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openChoiceTopicList.action?testpaperId='+id,
		    });
		  }
	
		//清空所有单选题题目
		function tm_clearBracnhes(){
			if(window.confirm('确定要清空吗？')){
				$("#div_link_branch").empty();
			}
		}

		//清空所有填空题题目
		function tm_clearBracnhes1(){
			if(window.confirm('确定要清空吗？')){
				$("#blankTab").empty();
			}
		}
		
		//清空所有简答题题目
		function tm_clearBracnhes2(){
			if(window.confirm('确定要清空吗？')){
				$("#briefTab").empty();
			}
		}
		
		//清空所有判断题题目
		function tm_clearBracnhes3(){
			if(window.confirm('确定要清空吗？')){
				$("#judgeTab").empty();
			}
		}
		
		//清空所有多选题题目
		function tm_clearBracnhes4(){
			if(window.confirm('确定要清空吗？')){
				$("#mulTab").empty();
			}
		}

		//删除一道题目
		function tm_removeBranch(obj){
			$(obj).parent().remove();
		}

		  //预览填空题列表页面（弹窗显示）
		  function preview1(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加填空题',
		       maxmin:true,
		      area: ['1100px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openFillTopicList.action?testpaperId='+id,
		    });
		  }
		  //预览简答题列表页面（弹窗显示）
		  function preview2(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加简答题',
		      area: ['1100px', '600px'],
		       maxmin:true,
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openTopicList.action?testpaperId='+id,
		    });
		  }
		//预览多选题列表页面（弹窗显示）
		  function preview4(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加多选题',
		       maxmin:true,
		      area: ['1100px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openMultipleTopicList.action?testpaperId='+id,
		    });
		  }
		  //预览判断题列表页面（弹窗显示）
		  function preview3(id){
		  	layer.open({
		      type: 2,
		      title: '从题库添加判断题',
		       maxmin:true,
		      area: ['1100px', '600px'],
		      shadeClose: true, //点击遮罩关闭
		      content: '<%= basePath%>/front/Testpaper_openJudgeTopicList.action?testpaperId='+id,
		    });
		  }
		  
		var tmPaper = {
			countScore : function(){
				var totalscore = 0,passscore = 0;
				$(".tm_qscore").each(function(i,o){
					var score = parseInt($(this).val());
					totalscore += score;
				});
				passscore = Math.ceil(0.6*totalscore);
				$("input[name='totalscore']").val(totalscore);
				$("input[name='passscore']").val(passscore);
			},
		}
    </script>
    
</body>

</html>

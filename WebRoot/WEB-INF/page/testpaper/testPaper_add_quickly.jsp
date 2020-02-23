<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试卷管理-快速创建试卷</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= path %>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/layui-v2.4.5/layui/layui.js"></script>
<script>
var  _contextPath="<%=path%>";
var  _modulePath=_contextPath+"/sys/";
$(document).ready(function(e) {
    $(".btn").click(function(){
		_sbmForm(_modulePath+"textures_add.action?view=list","");
		});
});
</script>
<script language="javascript">
	$(function(){
		var url = "<%=basePath%>/front/SysJson_checkTestpaperId.action";
		$("#checkTestpaperId").blur(function(){//给角色编号添加失去焦点事件
			var id = $("input[name='checkTestpaperId']").val();//获取角色编号值 
		$.post(url,{"checkId":id},function(data){//发送请求验证角色编号 
				if(data == "no"){//如果返回 no,提示已存在 
					$("#gradeInfo").html("<font color=\"red\">您输入的编号存在！请重新输入！</font>"); 
				}else{//否则隐藏 
					$("#gradeInfo").hide();
				}
			},"json");
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
                    "testpaperName":{
                        required:true,
                    },
                },
                messages:{
                    "testpaperName":{
                        required: "必填",
                    }
                  }
            });    
        });
</script>
 <script type="text/javascript">
	   var str2 = 0;
	   /*1、定义复选框函数*/
	   function test(id) {
		    var type = document.getElementById(id).value;
		     var arry1 = new Array();
		    arr1 = id.split("_");
	        var arry = new Array();
		    if (type=="单选题") {
		    	var obj=document.getElementById("topicBankName_"+arr1[1]);
	            obj.options.length=1;
	             <c:forEach items="${session.ChoiceTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var  option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName_"+arr1[1]).append(option);
	            }
		   }else if(type=="填空题"){
		  		 var obj=document.getElementById("topicBankName_"+arr1[1]);
	            obj.options.length=1;
	             <c:forEach items="${session.FillTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName_"+arr1[1]).append(option);
	            }
		   }else if(type=="简答题"){
		   		var obj=document.getElementById("topicBankName_"+arr1[1]);
	            obj.options.length=1;
	             <c:forEach items="${session.TopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName_"+arr1[1]).append(option);
	            }
		   }
		   else if(type=="判断题"){
		  		 var obj=document.getElementById("topicBankName_"+arr1[1]);
	            obj.options.length=1;
	             <c:forEach items="${session.JudgeTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName_"+arr1[1]).append(option);
	            }
		   }
		   else if(type=="多选题"){
		   		var obj=document.getElementById("topicBankName_"+arr1[1]);
	            obj.options.length=1;
	             <c:forEach items="${session.MultiplesTopicBankNameList}" var="item" varStatus="status">
		            arry.push("${item}");
		         </c:forEach>
	            for(var i=0;i<arry.length;i++){
	            	var option = document.createElement("option");
	            	$(option).val(arry[i]);
	            	$(option).text(arry[i]);
	            	$("#topicBankName_"+arr1[1]).append(option);
	            }
		   }
		}
	</script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="<%=basePath%>/front/Login_openIndex.action" target="rightFrame">首页</a></li>
		    <li><a href="#">试卷管理</a></li>
		    <li><a href="#">快速创建试卷</a></li>
	    </ul>
    </div>
  
    <div class="formbody">
	    <div class="formtitle"><span>快速创建试卷</span></div>
	  		<ul class="forminfo">
		    	<form action=" <%=basePath%>/front/Testpaper_CreateTestRandom.action" method="post" id="commonform">
					    <li><label>试卷名称</label><input name="testpaperName" id="testpaperName" type="text" class="dfinput" /><i><font color="#FF0000">*必填</font>不能超过20个汉字</i></li>
					    <li><label>卷面总分</label><input name="totalScore" id="totalScore" type="text" class="dfinput"/></li>
					    <li><label>及格分数</label><input name="passScore" id="passScore" type="text" class="dfinput" /></li>
					    <%String userName=(String)request.getSession().getAttribute("userName"); %>
		           		 <input name="creator" type="hidden" value="${userName}"/>
	     			
				    <div style="padding-left: 85px;margin-top:12px">
				    	<button type="button" class="btn layui-btn layui-btn-sm" onClick="tmPaper.addSection();" style="width: 110px;">添加题目设置</button>
				    	<!--  <button type="button" class="btn layui-btn layui-btn-sm" onclick="tmPaper.countScore();" style="width: 110px;margin-left:15px;">计算分数</button>-->
				   </div>
				    
				    <div class="tm_section_setting" style="margin-top:10px;"></div>
				    
				    <ul class="forminfo">
				       <li>
					        <label>&nbsp;</label><input style="margin-top:12px" name="add_btn" type="submit" class="btn" value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <label>&nbsp;</label><a href="<%= basePath%>/front/Testpaper_list.action"><input name="" type="button" class="btn" value="取消"/></a>
				      </li>
				    </ul>
				    
	   		    </form>
	   		</ul>
      </div>
      			 <!-- 增加章节模板 -->
				    <div class="tm_section_template" style="display:none;">
						<table border="0" cellpadding="5" cellspacing="0" class="tm_section_table">
							<tbody>
								<tr>
									<td>
										<select name="topicTypes" id="topicTypes_" onchange="test(this.id)" class="tm_select" style="min-width:100px">
											<option value="">请选择题型</option>
											<option value="单选题">单选题</option>
											<option value="多选题">多选题</option>
											<option value="判断题">判断题</option>
											<option value="填空题">填空题</option>
											<option value="简答题">简答题</option>
										</select>
					
										<select name="topicBankName" id="topicBankName_" class="tm_select tm_width200" style="min-width:100px" >
											<option>请选择所属题库</option>
										</select>
					
										<select name="difficulty" class="tm_select" style="min-width:100px">
											<option value="">选择难度</option>
											<option value="非常容易">非常容易</option>
											<option value="比较容易">比较容易</option>
											<option value="常规">常规</option>
											<option value="较难">较难</option>
											<option value="非常难">非常难</option>
										</select>
					
										试题数量 : 
										<input type="text" class="tm_txt" id="tm1" maxlength="3" size="3" name="topicNum">
					
										每题分值 : 
										<input type="text" class="tm_txt" id="tm2" maxlength="2" size="3" name="topicScores">
									</td>
									<th width="50" align="center" rowspan="1">
										<a href="javascript:;" onclick="tmPaper.removeSection(this);"><img src="<%=path%>/images/no.png" /></a>
									</th>
								</tr>
						   </tbody>
						</table>
					</div>
					 <!-- 增加章节模板 -->
	
	<script language="javascript"> //章节设置
		var var_sectionId = 0;

		$(document).ready(function() {
			tmPaper.addSection();
		});

		var tmPaper = {
			addSection : function(){
				$(".tm_section_template select[name='topicTypes']").prop("id","topicTypes_"+var_sectionId);
				$(".tm_section_template select[name='topicBankName']").prop("id","topicBankName_"+var_sectionId);
				
				var html = $(".tm_section_template").html();
				$(".tm_section_setting").append(html);
				var_sectionId++;

				$(".tm_section_template input[name='topicBankName']").prop("id","topicBankName_");
				$(".tm_section_template input[name='p_dbids']").prop("id","p_dbids_");
			}, 
			
			removeSection : function(obj){
				$(obj).parent().parent().parent().parent().remove();
			},

			countScore : function(){
				var totalScore = 0,passScore = 0;
				$(".tm_section_table").each(function(i,o){
					var num = parseInt($("#tm1").val());
					var score = parseInt($("#tm2").val());
					alert("num=="+num);
					alert("score=="+score);
					totalScore += (num*score);
				});
				totalScore -= 50;
				passScore = Math.ceil(0.6*totalScore);
				$("input[name='totalScore']").val(totalScore);
				$("input[name='passScore']").val(passScore);
			},

			type : {
				'0' : "考生试卷相同",
				'1' : "<font color=\"red\">各考生试卷随机生成</font>"
			},
			changeTypeTip : function(val){
				$("#tm_span_papertype_tip").html(tmPaper.type[val]);
			}
		};

		//检查章节配置是否有重复条件
		function doCheckSectionSettings(){
			var VAR_CONDITIONS = [];
			var VAR_RESULT = false;
			try{
				$("div.tm_section_setting table.tm_section_table").each(function(idx, item){
					var v_qdbs = $(item).find("select[name='topicBankName']").attr("data-qdbs");
					var v_qtype = $(item).find("select[name='topicTypes']").val();
					var v_qlevel = $(item).find("select[name='difficulty']").val();
					if(v_qdbs){
						var v_qdbs_arr = v_qdbs.split(",");
						for(var ixx = 0; ixx <v_qdbs_arr.length; ixx++){
							var v_condition_key = v_qdbs_arr[ixx] + "-" + v_qtype + "-" + v_qlevel;
							//console.log(v_condition_key);
							if(VAR_CONDITIONS[v_condition_key] == "YES"){
								VAR_RESULT = true;
							}else{
								VAR_CONDITIONS[v_condition_key] = "YES";
							}
							
						}
					}
				});
			}catch(e){

			}
			return VAR_RESULT;
		}
	</script> 
</body>

</html>

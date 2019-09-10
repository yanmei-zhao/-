<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'importList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css" />
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/commons.js"></script>
	<script type="text/javascript" src="js/swfobject.js"></script>
	
	<script type="text/javascript">
			$(function(){
				 
				 $('#Btn').click(function(){
			     	 $('#templateDialog').dialog('open');
				 });
				$('#okBtn').click(function(){
					//获取选择模板ID
					var str = $('#templates').combobox('getValue');
					$('#templateDialog').dialog('close');
					$('#importDialog').dialog('open');
					var val = "download?templateId=" + str;
					$('#downloadTemplate').attr('href',val);
				});
				
		});
			
	</script>
  </head>
  
  <body>
		<div><input id="Btn" type="button" class="scbtn"  value="选择模板"> </div>
		
		<div id="templateDialog" title="选择模板" modal=true draggable=false
			class="easyui-dialog" closed=true style="width: 350px;height:220px">
			<form action="">
				<table>
					<tr>
						<td>选择模板：</td>
						<td>
							<input id="templates" name="templates" class="easyui-combobox" panelHeight="auto"
								url="importdata-templates" valueField="templateId" textField="templateName" value="" />
							<a id="okBtn" class="easyui-linkbutton">确定</a>	
						</td>
					</tr>
				
				</table>
			</form>
		</div>
		<div id="importDialog" title="导入Excel" modal=true  draggable=false class="easyui-dialog" closed=true style="width:350px;height:220px;">
    				<table>
    				    <tr>
    						<td>下载模板:</td>
    						<td>
    							<a id = "downloadTemplate" >导入模板</a>
    						</td>
    					</tr>
 		           </table>
 		</div>
  </body>
</html>

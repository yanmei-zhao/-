<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>

<body>
<BR/><span id="div1" style="color:#F00"></span>秒后自动跳转到公司首页...
<BR/>如果无法自动跳转，<a href="http://www.doublecoins.com.cn">点击打开公司首页</a>。
</body>
</html>
<script type="text/javascript">
//设定倒数秒数
var t = 10;
//显示倒数秒数
function showTime(){
    t -= 1;
    document.getElementById('div1').innerHTML= t;
    if(t==0){
        location.href='http://www.doublecoins.com.cn';
    }
    //每秒执行一次,showTime()
    setTimeout("showTime()",1000);
}


//执行showTime()
showTime();
</script>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <!-- 设置路径 -->
    <link rel="stylesheet" type="text/css" href="css/a-upload.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>分享设置</title>
</head>

<body>
<div id="test" style="text-align:left;height:260px;top: 60%;">
<h4>${filename }</h4>
<form action="share/link.do" method="post">
<p><label>分享形式:</label></p>
<input type="radio" name="way"  value="0" checked="checked" />私密分享 
<input type="radio" name="way"  value="1"/>公共分享
<p><label>有效期:</label></p>
<input type="radio" name="time" value="1" checked="checked" />3天
		  <input type="radio" name="time" value="2" />7天
          <input type="radio" name="time" value="3"/>永久
<center><p><input type ="submit" style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="提交" /></p></center>
</form>
</div>
</body>
</html>
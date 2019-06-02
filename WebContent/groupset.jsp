<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <link rel="stylesheet" type="text/css" href="css/a-upload.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <!-- 设置路径 -->
    
    
<title>修改群设置</title>
</head>
<body>
<div id="test" style="text-align:left;height:260px;top: 60%;">
<form action="group/set.do" method="post">
<p>群名：<input type="text" name="gname" class="text_field"/><br/></p>
<p><label>管理员默认权限:</label></p>
<input type="radio" name="managerauth" value="1" checked="checked" />仅下载
		  <input type="radio" name="managerauth" value="2" />仅上传
          <input type="radio" name="managerauth" value="3"/>既可上传又可下载<br/> 
<p><label>用户默认权限:</label></p>
<input type="radio" name="uauth" value="1" checked="checked" />仅下载
		  <input type="radio" name="uauth" value="2" />仅上传
          <input type="radio" name="uauth" value="3"/>既可上传又可下载<br/>
<center><p><input type ="submit" style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="提交" /></p></center>
</form>
</div>
</body>
</html>
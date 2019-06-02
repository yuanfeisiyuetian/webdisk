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
    
<title>新建群</title>
</head>
<body>
<div id="test" style="text-align:left;height:280px;top: 60%;">
<center><h4>新建群组</h4></center>
<form action="group/create.do" method="post">
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
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
    
    <title>文件上传</title>
  </head>
  
  <body>
  	<div id="test">
  	<h4>成功！</h4>
   <p><a style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" href="upload.jsp">继续上传</a></p>
   <p><a style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" href="main/init.do">返回</a></p>
    </div>
  </body>
</html>
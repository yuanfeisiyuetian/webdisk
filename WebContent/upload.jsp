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
    <title>文件上传</title>
  </head>
  
  <body>
    <form action="file/upload.do" enctype="multipart/form-data" method="post">
        上传文件1：<input type="file" name="file" multiple><br/>
        <input type="submit" value="上传">
    </form>
    ${msg }
  </body>
</html>
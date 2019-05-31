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
    <title></title>
  </head>
  
  <body>
    <form action="share/credit.do"  method="post">
        请输入密码：<input type="text" name="pwd"><br/>
        <input type ="submit" value="提交" />
    </form>
    ${msg }
  </body>
</html>
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
    <form action="user/pwd.do"  method="post">
        请输入新密码：<input type="text" name="password"><br/>
        <input type ="submit" value="提交" />
    </form>
  </body>
</html>
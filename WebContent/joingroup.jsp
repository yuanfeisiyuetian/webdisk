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
    
    
<title>Insert title here</title>
</head>
<body>
<h2>加入群组</h2>
<form action="group/join.do" method="post">
邀请码：<input type="text" name="token" /><br/>
<input type ="submit" value="提交" />
</form>
</body>
</html>
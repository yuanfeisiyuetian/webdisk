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
<h2>注册</h2>
<form action="user/register.do" method="post">
email：<input type="text" name="uemail" /><br/>
name:<input type="text" name="uname"/><br/>
password：<input type="text" name="passwordhash"><br/>
<input type ="submit" value="提交" />
<input type="reset" value="重置" />
</form>
${msg }
</body>
</html>
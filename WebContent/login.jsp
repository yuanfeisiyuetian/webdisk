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
<h2>这是登陆界面</h2>
<form action="user/login.do" method="post">
email：<input type="text" name="uemail" /><br/>
password：<input type="text" name="passwordhash"><br/>
<input type ="submit" value="提交" />
<input type="reset" value="重置" />
</form>
<a href="register.jsp">还没有账号？注册一个</a>
${msg }
</body>
</html>
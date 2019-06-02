<%@ page language="java" import="java.util.*,com.webcloud.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <!-- 设置路径 -->
    <%Shareforusr shareforusr = (Shareforusr)request.getAttribute("shareforusr");%>
    <link rel="stylesheet" type="text/css" href="css/a-upload.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>重置密码</title>
</head>
<body>
	<div id="test" style="height:120px">
	<div style="height: 15px;"></div>
	<center><p>${msg }</p></center>
	<center><a style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" href = "user/admin.do">返回</a></center>
	</div>
</body>
</html>
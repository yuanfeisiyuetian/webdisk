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
    
<title>Insert title here</title>
</head>
<body>
<h2><%=shareforusr.getUfilename() %></h2>
文件id：<%=shareforusr.getUfilepath() %>
<%if(shareforusr.getUfilepassword()!= null) { %>
密码：<%=shareforusr.getUfilepassword()%>
<%} %>
<a href = "share/init.do">返回</a>
</body>
</html>
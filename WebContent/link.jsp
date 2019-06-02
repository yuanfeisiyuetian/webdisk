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
<title>分享链接</title>
</head>
<body>
	<div id="test" style="text-align:left;height:200px">
	<h4><%=shareforusr.getUfilename() %></h4>
  	<p><label class="label_input" >文件id：</label>
	<%=shareforusr.getUfilepath() %></p>
	<%if(shareforusr.getUfilepassword()!= null) { %>
	<p><label class="label_input" >密码：</label>
	<%=shareforusr.getUfilepassword()%></p>
	<%} %>
<center><a style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" href = "share/init.do">返回</a></center>
</div>
</body>
</html>
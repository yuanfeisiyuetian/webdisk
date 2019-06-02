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
    
    <meta name="Keywords" content="500错误页面"/>
	<meta name="Description" content="500错误页面"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link href="css/error404.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">setTimeout(function(){top.location='main/init.do';},5000)</script>
<title>500</title>
</head>
<body>
<div class="error404">
		<div class="info">
			<h1>500</h1>
			<h2>抱歉，您访问的页面出错！请重新登陆</h2>
			<!--<p>The page you are looking for was moved, removed, renamed or might never existed.</p>-->
			
			<a href="login.jsp" class="btn">返回登陆</a>
		</div>
		<div class="pic">
			<img src="image/404.gif" alt=" " />
		</div>
	</div>
</body>
</html>
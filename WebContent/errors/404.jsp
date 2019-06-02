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
    
    <meta name="Keywords" content="404错误页面"/>
	<meta name="Description" content="404错误页面"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link href="css/error404.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">setTimeout(function(){top.location='main/init.do';},5000)</script>
<title>404</title>
</head>
<body>
<div class="error404">
		<div class="info">
			<h1>404</h1>
			<h2>抱歉，您访问的页面不存在或已被删除！ (｡•ˇ‸ˇ•｡)</h2>
			<p class="p1">5秒钟后将带您返回首页</p>
			<!--<p>The page you are looking for was moved, removed, renamed or might never existed.</p>-->
			
			<a href="main/init.do" class="btn">返回首页</a>
		</div>
		<div class="pic">
			<img src="image/404.gif" alt=" " />
		</div>
	</div>
</body>
</html>
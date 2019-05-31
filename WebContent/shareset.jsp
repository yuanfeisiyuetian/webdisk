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
<h2>${filename }</h2>
<form action="share/link.do" method="post">
<input type="radio" name="way"  value="0" checked="checked" />私密分享 
<input type="radio" name="way"  value="1"/>公共分享<br/> 
分享时长：<input type="radio" name="time" value="1" checked="checked" />3天
		  <input type="radio" name="time" value="2" />7天
          <input type="radio" name="time" value="3"/>永久<br/> 
<input type ="submit" value="提交" />
</form>
</body>
</html>
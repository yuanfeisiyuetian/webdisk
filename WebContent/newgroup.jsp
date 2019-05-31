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
<h2>新建群组</h2>
<form action="group/create.do" method="post">
群名：<input type="text" name="gname" /><br/>
管理员默认权限<input type="radio" name="managerauth" value="1" checked="checked" />仅下载
		  <input type="radio" name="managerauth" value="2" />仅上传
          <input type="radio" name="managerauth" value="3"/>既可上传又可下载<br/> 
用户默认权限：<input type="radio" name="uauth" value="1" checked="checked" />仅下载
		  <input type="radio" name="uauth" value="2" />仅上传
          <input type="radio" name="uauth" value="3"/>既可上传又可下载<br/>
<input type ="submit" value="提交" />
<input type="reset" value="重置" />
</form>
</body>
</html>
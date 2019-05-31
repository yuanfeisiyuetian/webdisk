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
    
    
<title>修改默认权限</title>
</head>
<body>
<form action="group/set.do" method="post">
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
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
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    
<title>注册</title>
</head>
<body>
<div id="login_frame">
<p id="image_logo"><img src="image/login/girl.png" ></p>
<form action="user/register.do" method="post">
<p><label class="label_input">邮箱</label><input type="text" name="uemail" class="text_field"/></p>
<p><label class="label_input">昵称</label><input type="text" name="uname" class="text_field"/></p>
<p><label class="label_input">密码</label><input type="password" name="passwordhash" class="text_field"></p>
<input type ="submit" value="提交" />
</form>
<%if(session.getAttribute("msg")!=null){ %>
<script type="text/javascript">
	alert("该邮箱已被注册!");
</script>
<%} %>
</div>
</body>
</html>
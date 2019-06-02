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

<title>登陆</title>
</head>
<body>

<div id="login_frame">
<p id="image_logo"><img src="image/login/girl.png" ></p>
<form action="user/login.do" method="post">
<p><label class="label_input">邮箱</label><input type="text" name="uemail"  class="text_field"/></p>
<p><label class="label_input">密码</label><input type="password" name="passwordhash" class="text_field"/></p>
<div id="login_control">
<input type ="submit"style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="提交" />
</div>
</form>
<a href="register.jsp">还没有账号？注册一个</a>
<%if(session.getAttribute("msg")!=null){ %>
<script type="text/javascript">
	alert("用户名或者密码错误！");
</script>
<%} %>
</div>
</body>

</html>
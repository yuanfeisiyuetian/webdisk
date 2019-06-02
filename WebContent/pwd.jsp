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
    <link rel="stylesheet" type="text/css" href="css/a-upload.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <title>修改密码</title>
  </head>
  
  <body>
  <div id="test" style="height:200px">
  <p id="image_logo"><img src="image/login/girl.png" ></p>
    <form action="user/pwd.do"  method="post">
        <p><label class="label_input" >新密码：</label><input type="password" name="password" class="text_field"></p>
        <br/>
        <div id="login_control">
        <input type ="submit" style="height:35px ;width:60px;font-size: 16px;font-family: 宋体;color: black;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="提交" />
    	</div>
    </form>
    </div>
  </body>
</html>
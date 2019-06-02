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
    <title>查看分享</title>
  </head>
  
  <body>
  <div id="test">
  	<div style="height: 35px;"></div>
    <form action="share/credit.do"  method="post">
    <p><label class="label_input">口令：</label><input type="password" name="pwd"  class="text_field"/></p>
    <div id="login_control"><input type ="submit" style="height:32px ;width:50px;font-size: 16px;font-family: 宋体;color: white;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="提交" /></div>
    </form>
    </div>
    <%if(session.getAttribute("msg")!=null){ %>
	<script type="text/javascript">
		alert("口令错误！");
	</script>
	<%} %>
  </body>
</html>
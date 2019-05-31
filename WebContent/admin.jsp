<%@ page language="java" import="java.util.*,com.webcloud.entity.*" isELIgnored="false" pageEncoding="utf-8"%>
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

<div id="user">
<table>
<tr>
<td>用户名</td>
<td>邮箱</td>
<td>注册时间</td>
</tr>
<%
List<User> userlist=(List<User>)request.getAttribute("userlist");
for(int i=0;i<userlist.size();i++){
	User user = userlist.get(i) ;
%> 
<tr>
<td><%=user.getUname() %></td>
<td><%=user.getUemail() %></td>
<td><%=user.getUregistertime() %></td>
<td><a href="user/resetpwd.do?key=<%=user.getUid() %>">重置密码</a></td>
<td><a href="user/del.do?key=<%=user.getUid() %>">注销该用户</a></td>
</tr>
<%} %>
</table>
</div>
${msg }
<br/>
<div>
<ul>
<li>
<a href = "user/logout.do">安全退出</a>
</li>
</ul>
</div>
</body>
</html>
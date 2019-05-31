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
<div id = bar>
<a href="groupset.jsp">修改默认权限</a>
</div>
<div id=search>
<form action="group/searchuser.do" method="post">
用户昵称：<input type="text" name="uname" />
<input type ="submit" value="搜索" />
</form>
</div>
<div id=search>
</div>
<div id="manager">
管理员<br/>
<table>
<%
List<User> managers=(List<User>)request.getAttribute("managers");
for(int i=0;i<managers.size();i++){
	User user = managers.get(i) ;
%> 
<tr>
<td><%=user.getUname() %></td>
<td><a href="group/managereset.do?key=<%=user.getUid() %>">移出管理员</a></td>
<td><a href="group/removemanage.do?key=<%=user.getUid() %>">移出该群</a></td>
</tr>
<%} %>
</table>
</div>
<div id="user">
其他用户<br/>
<table>
<%
List<User> users=(List<User>)request.getAttribute("users");
for(int i=0;i<users.size();i++){
	User user = users.get(i) ;
%> 
<tr>
<td><%=user.getUname() %></td>
<td><a href="group/manageset.do?key=<%=user.getUid() %>">设为管理员</a></td>
<td><a href="group/removeuser.do?key=<%=user.getUid() %>">移出该群</a></td>
</tr>
<%} %>
</table>
</div>


</body>
</html>
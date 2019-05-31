<%@ page language="java" import="java.util.*,com.webcloud.entity.*" isELIgnored="false" pageEncoding="utf-8"%>
<style type="text/css">
ul{padding: 0px;margin: 0px; }
li{float: left; list-style: none;}
#prodCateDiv{height: 50px;}
#prodCateDiv li{width: 100px;height: 30px;line-height: 30px;border: solid 1px red;text-align: center;}
#prodCateDiv a{text-decoration: none;color: red;}
#prodCateDiv a:HOVER {
	text-decoration: none;color: blue;
}
</style>
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
<a href="upload.jsp">上传</a>
<a href="newgroup.jsp">创建群</a>
<a href="joingroup.jsp">加入群</a>
</div>
<div id="group">
<table>
创建的群
<tr>
<td>群名</td>
<td>群邀请码</td>
</tr>
<%
List<Group> groupownList=(List<Group>)request.getAttribute("groupownList");
for(int i=0;i<groupownList.size();i++){
	Group group = groupownList.get(i) ;
%> 
<tr>
<td><a href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a></td>
<td><%=group.getToken() %></a></td>
</tr>
<%} %>
</table>
<table>
管理的群
<tr>
<td>群名</td>
<td>群邀请码</td>
</tr>
<%
List<Group> groupmanageList=(List<Group>)request.getAttribute("groupmanageList");
for(int i=0;i<groupmanageList.size();i++){
	Group group = groupmanageList.get(i) ;
%> 
<tr>
<td><a href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a></td>
<td><%=group.getToken() %></a></td>
</tr>
<%} %>
</table>
<br/>
<table>
加入的群
<tr>
<td>群名</td>
</tr>
<%
List<Group> groupjoinList=(List<Group>)request.getAttribute("groupjoinList");
for(int i=0;i<groupjoinList.size();i++){
	Group group = groupjoinList.get(i) ;
%> 
<tr>
<td><a href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a></td>
</tr>
<%} %>
</table>
</div>

<div id="bar">
<ul>
<li>
<a href = "main/init.do">我的文件</a>
<a href = "share/init.do">我的分享</a>
<a href = "group/init.do">我的群组</a>
<a href = "main/recycle.do">回收站</a>
</li>
</ul>
</div>
<br/>
<div>
<ul>
<li>
<a href = "user/logout.do">安全退出</a>
<a href = "pwd.jsp">修改密码</a>
</li>
</ul>
</div>
</body>
</html>
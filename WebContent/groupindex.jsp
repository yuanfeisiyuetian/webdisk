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
    
<title><%=request.getAttribute("groupname") %></title>
</head>

<body>
<%=request.getAttribute("groupname") %>
<div id = bar>
<%
short auth = (short)request.getAttribute("auth");
if(auth==7||auth==3){
%>
<a href="groupupload.jsp">上传</a>
<%} %>
<%if(auth==7){ %>
<a href="groupfile/recycle.do">群组回收站</a>
<a href="group/manage.do">管理群</a>
<%} %>
</div>
<div id=search>
<form action="groupfile/search.do" method="post">
文件名：<input type="text" name="filename" />
<input type ="submit" value="搜索" />
</form>
</div>
<div id="file">
<table>
<tr>
<td>文件名</td>
<td>文件大小</td>
<td>上传时间</td>
<td>上传者</td>
<td>下载次数</td>
</tr>
<%
List<Fileforgru> fileforgrulist=(List<Fileforgru>)request.getAttribute("fileforgrulist");
for(int i=0;i<fileforgrulist.size();i++){
	Fileforgru fileforgru = fileforgrulist.get(i) ;
%> 
<tr>
<td><a href="wenjianyulanjiemian"><%=fileforgru.getGfilename() %></a></td>
<td><%=fileforgru.getGfilsize() %></td>
<td><%=fileforgru.getGuploadtime() %></td>
<td><%=fileforgru.getGuploadusrid()%></td>
<td><%=fileforgru.getGdownloadtimes() %></td>
<td><a href="gfile/download.do?key=<%=fileforgru.getGfileid() %>">下载</a></td>
<%
if(auth==7||auth==3){
%>
<td><a href="groupfile/del.do?key=<%=fileforgru.getGfileid() %>">删除</a></td>
<%} %>
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
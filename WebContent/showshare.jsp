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
<div id="file">
<table>
<tr>
<td>文件名</td>
<td>文件大小</td>
<td>分享人</td>
</tr>
<tr>
<%Fileforusr fileforusr = (Fileforusr)request.getAttribute("fileforusr"); %>
<td><a href="wenjianyulanjiemian"><%=fileforusr.getUfilename() %></a></td>
<td><%=fileforusr.getUsize() %></td>
<td><%=fileforusr.getUid() %></td>
<td><a href="file/download.do?key=<%=fileforusr.getUfileid() %>">下载</a></td>
</tr>
</table>
</div>
<a href="main/init.do">返回</a></td>
</body>
</html>
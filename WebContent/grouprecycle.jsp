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
<table>
<tr>
<td>文件名</td>
<td>删除时间</td>
</tr>
<%
List<Fileforgru> fileforgrulist=(List<Fileforgru>)request.getAttribute("fileforgrulist");
for(int i=0;i<fileforgrulist.size();i++){
	Fileforgru fileforgru = fileforgrulist.get(i) ;
%> 
<tr>
<td><%=fileforgru.getGfilename() %></td>
<td><%=fileforgru.getGlmodtime() %></td>
<td><a href="groupfile/back.do?key=<%=fileforgru.getGfileid() %>">还原</a></td>
<td><a href="gfile/deltotal.do?key=<%=fileforgru.getGfileid() %>">彻底删除</a></td>
</tr>
<%} %>
</table>
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
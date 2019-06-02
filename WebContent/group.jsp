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
    <link rel="stylesheet" type="text/css" href="css/alpha.css"/>
    <link rel="stylesheet" type="text/css" href="css/disk.header.css"/>
    <link rel="stylesheet" type="text/css" href="css/diskSystem-theme.css"/>
    <link rel="stylesheet" type="text/css" href="css/home-all_5215898.css"/>
    <link rel="stylesheet" type="text/css" href="css/function.css"/>
    <link rel="stylesheet" type="text/css" href="css/cover.css"/>
    <link rel="stylesheet" type="text/css" href="css/context-all_1aa43af.css"/>
    <link rel="stylesheet" type="text/css" href="css/all_fe4c0e3.css"/>
<title>我的群组</title>
</head>


<body>
<div class="frame-all" id="layoutApp">
<div id="layoutHeader">
	<div class="module-header">
	<div class="module-header-wrapper" style="height: 62px;">
	<dl class="xtJbHcb">
		<dd class="vyQHNyb">
		<span class="cMEMEF">
		<a href = "main/init.do">我的文件</a>
		</span>
		<span class="cMEMEF">
		<a href = "share/init.do">我的分享</a>
		</span>
		<span class="cMEMEF">
		<a href = "group/init.do" style="color:#09AAFF;">我的群组</a>
		</span>
		<span class="cMEMEF">
		<a href = "main/recycle.do">回收站</a>
		</span>
		</dd>
		
		<dd class="CDaavKb">
		<span class="DIcOFyb">
		<span class="user-photo-box">
		<i id="image_logo"><img src="image/login/girl.png" ></i>
		</span>
		</span>
		<a href = "user/logout.do" class="app-download">安全退出</a>
		<a href = "pwd.jsp" class="app-download">修改密码</a>
		</dd>
		
		<dd class="gOIbzPb"></dd>
	</dl>
	</div>
	</div>
</div>


<div class="9jy1grqD">
<div class="G2BuhR3">
<div class="frame-main" id="layoutMain" style="display: block;">
<div class="aEqywC">
<div class="DxdbeCb g-clearfix">
<div class="uyiLGWX">
	<div class="OFaPaO">
	<div class="oclLlDK">
	<form action="group/join.do" method="post" class="rodJJ7 nqlj1aPp">
		<input type="text" name="token" class="klzvyY8g" placeholder="输入邀请码加入新群"/>
		<span class="gHHsaL">
			<input type ="submit"style="height:20px ;width:40px;font-size: 12px;font-family: 宋体;color: white;background-color: #7EC0EE;border-radius: 6px;border: 0;" value="加入" />
		</span>
	</form>
	</div>
	</div>
	
	<div class="oyLWOp" style="white-space: nowrap; position: relative;">
	<div class="tcuLAu" style="top: 0px; width: auto; line-height: normal; padding-top: 16px; padding-left: 30px; position: absolute;">
	<a title="创建群" class="g-button" href="newgroup.jsp">
		<span class="g-button-right">
		<span class="text" style="width: auto;">创建群</span>
		</span>
	</a>
	</div>
	
	</div>
</div>

<HR color=EAEAEA SIZE=1>

<div class="4rXmMeR">
<div class="KPDwCE" style="height: 597.024px;">
<div class="QxJxtg" style="display: block;">
<div class="xGLMIab">
<ul class="QAfdwP tvPMvPb" style="display: block;">
<li class="fufHyA yfHIsP MCGAxG" style="width:60%;">
<div class="Qxyfvg fydGNC"></div>
<span class="test" >群名</span>
</li>
<li class="fufHyA" style="width:40%;">
<span class="test" >群邀请码</span>
</li>
</ul>
</div>
</div>


<div class="zJMtAEb">
<div class="NHcGw" style="height: 539.024px; overflow-y: auto;">
<%
List<Group> groupownList=(List<Group>)request.getAttribute("groupownList");
for(int i=0;i<groupownList.size();i++){
	Group group = groupownList.get(i) ;
%> 
<div class="vdAfKMb" style="height: auto;">
<dd  onmouseover="this.className='g-clearfix AuPKyz open-enable ehd7py'" onmouseout="this.className='g-clearfix AuPKyz open-enable'" class="g-clearfix AuPKyz open-enable">
<div class="Qxyfvg fydGNC"></div>

<div class="file-name" style="width:60%">
	<div class="text">
	<a title="" class="ltvdXqk" href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a>
	</div>
</div>

<div class="wsbdJ7D" style="width:40%"><%=group.getToken() %></div>

</dd>
</div>
<%} %>
<%
List<Group> groupmanageList=(List<Group>)request.getAttribute("groupmanageList");
for(int i=0;i<groupmanageList.size();i++){
	Group group = groupmanageList.get(i) ;
%> 
<div class="vdAfKMb" style="height: auto;">
<dd  onmouseover="this.className='g-clearfix AuPKyz open-enable ehd7py'" onmouseout="this.className='g-clearfix AuPKyz open-enable'" class="g-clearfix AuPKyz open-enable">
<div class="Qxyfvg fydGNC"></div>

<div class="file-name" style="width:60%">
	<div class="text">
	<a title="" class="ltvdXqk" href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a>
	</div>
	<div class="operate">
	<div class="button-box-mark" style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
	<div style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;"></div>
		<a class="g-button" style="display: inline-block;" href="group/quitmanage.do?key=<%=group.getGid()%>">退出该群</a>
	</div>
	</div>
</div>

<div class="wsbdJ7D" style="width:40%"><%=group.getToken() %></div>

</dd>
</div>
<%} %>
<%
List<Group> groupjoinList=(List<Group>)request.getAttribute("groupjoinList");
for(int i=0;i<groupjoinList.size();i++){
	Group group = groupjoinList.get(i) ;
%>  
<div class="vdAfKMb" style="height: auto;">
<dd  onmouseover="this.className='g-clearfix AuPKyz open-enable ehd7py'" onmouseout="this.className='g-clearfix AuPKyz open-enable'" class="g-clearfix AuPKyz open-enable">
<div class="Qxyfvg fydGNC"></div>

<div class="file-name" style="width:60%">
	<div class="text">
	<a title="" class="ltvdXqk" href="groupfile/init.do?key=<%=group.getGid()%>"><%=group.getGname() %></a>
	</div>
	<div class="operate">
	<div class="button-box-mark" style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
	<div style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;"></div>
		<a class="g-button" style="display: inline-block;" href="group/quitgroup.do?key=<%=group.getGid()%>">退出该群</a>
	</div>
	</div>
</div>

<div class="wsbdJ7D" style="width:40%"><%=group.getToken() %></div>

</dd>
</div>
<%} %>
</div>
</div>


</div>
</div>

</div>
</div>
</div>
</div>
</div>
</div>
</body>

</html>
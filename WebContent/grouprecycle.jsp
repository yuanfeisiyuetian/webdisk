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
<title>Insert title here</title>
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
	<div class="oclLlDK"></div>
</div>

<div class="oyLWOp" style="white-space: nowrap; position: relative;">
<div class="tcuLAu" style="top: 0px; width: auto; line-height: normal; padding-top: 16px; padding-left: 30px; position: absolute;">
<a title="返回" class="g-button" href="groupfile/init.do">
		<span class="g-button-right">
		<span class="text" style="width: auto;">返回</span>
		</span>
	</a>
</div>
<div class="tcuLAu" style="top: 0px; width: auto; line-height: normal; padding-top: 10px; padding-left: 30px; ">
	<center>
	<span class="cMEMEF" style="font-size:16px;">
	<%=request.getAttribute("groupname") %>
	</span>
	</center>
	</div>
</div>
</div>

<div class="4rXmMeR">
<div class="KPDwCE" style="height: 597.024px;">
<div class="QxJxtg" style="display: block;">
<div class="xGLMIab">
<ul class="QAfdwP tvPMvPb" style="display: block;">
<li class="fufHyA yfHIsP MCGAxG" style="width:60%;">
<div class="Qxyfvg fydGNC"></div>
<span class="test" >文件名</span>
</li>
<li class="fufHyA gObdAzb" style="width:40%;">
<span class="test" >删除时间</span>
</li>
</ul>
</div>
</div>


<div class="zJMtAEb">
<div class="NHcGw" style="height: 539.024px; overflow-y: auto;">
<%
List<Fileforgru> fileforgrulist=(List<Fileforgru>)request.getAttribute("fileforgrulist");
for(int i=0;i<fileforgrulist.size();i++){
	Fileforgru fileforgru = fileforgrulist.get(i) ;
%> 
<div class="vdAfKMb" style="height: auto;">
<dd  onmouseover="this.className='g-clearfix AuPKyz open-enable ehd7py'" onmouseout="this.className='g-clearfix AuPKyz open-enable'" class="g-clearfix AuPKyz open-enable">
<div class="Qxyfvg fydGNC"></div>

<div class="file-name" style="width:60%">
	<div class="text">
	<a title="" class="ltvdXqk" ><%=fileforgru.getGfilename() %></a>
	</div>
	<div class="operate">
	<div class="button-box-mark" style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
	<div style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;"></div>
		<a class="g-button" style="display: inline-block;" href="groupfile/back.do?key=<%=fileforgru.getGfileid() %>">还原</a>
		<a class="g-button" style="display: inline-block;" href="gfile/deltotal.do?key=<%=fileforgru.getGfileid() %>">彻底删除</a>
	</div>
	</div>
</div>

<div class="pdgbd47Z" style="width:23%"><%=fileforgru.getGlmodtime() %></div>

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
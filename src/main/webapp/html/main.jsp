<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<s:if test="msg2!=null">
	<script type="text/javascript">
	var msg2 = "<s:property value='msg2' />"
	alert(msg2);	
	</script>
</s:if>
</head>
<body>
	<div class="head">
	
		<div id="shortcut">
			<div id="info">
				欢迎您：<s:property value="#session.user.userName"/> 
				<a class="modifypwd">修改密码</a> 
				<a id="out" href="loginOut">退出</a>
			</div>
		</div>
		<h1>代理商管理系统</h1>
	</div>
	<div id="menu">
		<ul>
			<li onClick="menu(this)" id="p_1"><a href="index" target="inside">代理商管理</a></li>
			<li onClick="menu(this)" id="p_2"><a href="getPortal" target="inside">门户管理</a></li>
			<li onClick="menu(this)" id="p_3"><a href="showReport" target="inside">报表管理</a></li>
			<li onClick="menu(this)" id="p_4"><a href="financial" target="inside">系统管理</a></li>
			<li onClick="menu(this)" id="p_5"><a href="financialType?configType=1" target="inside">系统配置管理</a></li>
		</ul>
	</div>
	<div class="submenu">
		<ul class="smenu" id="c_1">
			<li id="i1"><a href="keywords_application" target="inside">关键词申请</a></li>
			<li id="i2"><a href="pageList" target="inside">代理商客户管理</a></li>
			<li id="i3"><a href="prepay" target="inside">代理商预付款</a></li>
			<li id="i4"><a href="keywordsList" target="inside">关键词申请管理</a></li>
			<li id="i5"><a href="loglist" target="inside">操作日志</a></li>
		</ul>
		<ul class="smenu" id="c_2">
			<li id="i18"><a href="getPortal" target="inside">门户管理</a></li>
		</ul>
		<ul class="smenu" id="c_3">
			<li id="i19"><a href="showReport" target="inside">报表管理</a></li>
		</ul>
		<ul class="smenu" id="c_4">
			<li id="i6"><a href="financial" target="inside">财务管理</a></li>
			<li id="i7"><a href="rolema" target="inside">角色管理</a></li>
			<li id="i8"><a href="roleau" target="inside">角色权限管理</a></li>
			<li id="i9"><a href="userma" target="inside">用户管理</a></li>
			<li id="i10"><a href="keywordsCheck" target="inside">关键词审核</a></li>
		</ul>
		<ul class="smenu"  id="c_5">
    		<li id="i11"><a href="financialType?configType=1" target="inside">财务类型</a></li>
       	 	<li id="i12"><a href="serviceType?configType=2" target="inside">服务类型</a></li>
        	<li id="i13"><a href="serviceTime?configType=3" target="inside">服务年限</a></li>
        	<li id="i14"><a href="appAddress?configType=4 "target="inside">app地址</a></li>
        	<li id="i15"><a href="clientType?configType=5" target="inside">客户类型</a></li>
			<li id="i16"><a href="credentialsType?configType=6" target="inside">证件类型</a></li>
			<li id="i17"><a href="preferentialType?configType=7" target="inside">优惠类型</a></li>
    	</ul>
	</div>
	<div class="bg">
	<div id="modify" style="display:none">
		<form action="pModify" method="post">
		<table>
			<tr></tr>
			<tr>
				<td>请输入原密码：</td><td><input type="text" id="oldpwd" name="oldpwd"></td><td><span  id="op" class="pd">您本次登录时的密码</span></td>
			</tr>
			<tr>
				<td>请输入新密码：</td><td><input type="text" id="newpwd" name="newpwd"></td><td><span id="np" class="pd">新密码不少于6个字符</span></td>
			</tr>
			<tr>
				<td>请确认新密码：</td><td><input type="text" id="repwd" name="repwd"></td><td><span id="rp" class="pd">新密码不少于6个字符</span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="sub" value="确认修改密码" /></td>
				<td><input type="button" value="取消" class="cancel" /></td>
			</tr>
			<tr></tr>
		</table>
		</form>
	</div>
	<div id="mid-box">
	<div id="navigation"><span id="n1">代理商管理</span>&nbsp;<span id="n2">\&nbsp;当前账户信息</span>&nbsp;<span id="n3"></span></div>
	</div>
	<div id="main">
		<iframe src="index" frameborder="0" scrolling="no" width="1300px" marginheight="0"
	 	marginwidth="0" onLoad="iFrameHeight()" id="iframepage" id="inside" name="inside"/>
	</div>
	
	</div>
</body>
</html>
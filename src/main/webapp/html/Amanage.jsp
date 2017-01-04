<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>

<style>
body{
	font-size:14px;
	}
.bordered{
	margin:40px;
	width:1200px;
	height:100px;
	border:#CCC 1px solid;
	}
p{
	padding:0px 10px;}
p a{
	text-decoration:none;}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
$('#detail').click(function(){
	$(window.parent.document).find('#n3').html('&#92;&nbsp;查看账户明细');
})
})
</script>
</head>

<body>
<div class="bordered">
<p><span style="font-weight:bold">您好，<s:property value="#session.user.userName"/>!&nbsp;&nbsp;</span>您上次登录时间为：<s:date name="lastLoginT"/></p>
<p>您当前账户余额：￥<s:number name="account.money"/> <a href="showDetail" id="detail">查看账户明细</a></p>
</div>
<div style="height:70px;"></div>
</body>
</html>
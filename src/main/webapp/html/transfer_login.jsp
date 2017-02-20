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
	font-size:20px;
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

</head>

<body>
<div class="bordered">
<p><span style="font-weight:bold">您好，您还未登录，系统将自动跳转到登录界面...</span>
</p>
				<script type="text/javascript">
					setTimeout("window.parent.location.href='logins.jsp'", 3000);
				</script>
	
</div>
<div style="height:70px;"></div>
</body>
</html>
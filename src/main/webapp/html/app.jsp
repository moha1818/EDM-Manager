<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/agentmanage/4.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#sub').click(function(){
		window.close();
	})
})

function compare(){
	var appUserName=$("#name").val();
	var appPassword=$("#pwd").val();
	
	if(appUserName==""||appPassword==""){
		alert("请填写账户和密码")
		return false;
	}else if(appPassword.length()<6){
		alert("密码长度不小于6位")
		return false;
	}
}
$(function(){
	$('#sub').click(function(){
		alert('恭喜您，app开通成功!');
		var href = window.parent.location;
		window.parent.location.href = href;
	})
})
</script>
</head>
<h3>开通APP</h3>
	<form action="openApp" method="get">
    <hr/>
    <input type="hidden" name="kid" value="<s:property value="key.id"/>">
    <table>
    	<tr>
        <td>登录账户：<input id="name" name="appUserName" type="text"/></td>
        <td>登录密码：<input id="pwd" name="appPassword" type="text"/></td>
        </tr>
        <tr>
        <td>关键词：<s:property value="key.keywords"/></td>
        <td>企业名称:<s:property value="key.customName"/></td>
        </tr>
        <tr>
        <td>价格：￥<s:number name="key.price"/></td>
        <td>服务类型：<s:property value="key.systemconfig.configTypeName"/></td>
        </tr>
        
    </table>
    <hr/>
    <div id="sub" >
    	<input type="image" onclick="return compare()" src="image/u9.png"/>
    </div>
    </form>

<body>
</body>
</html>
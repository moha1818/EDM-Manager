<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/agentmanage/3.css">
</head>
<body>
	<p>基本信息</p>
	<table style="border: #CCC 1px solid; width: 1200px;">
		<tr>
			<td>企业名称：<s:property value="customs.customName" /></td>
			<td>企业类型：<s:property value="customs.customTypeName" /></td>
		</tr>
		<tr>
			<td>企业主页：<s:property value="customs.siteUrl" /></td>
			<td>状态： <s:if test="customs.customStatus==1">
					<span style="color: green">启用</span>
				</s:if> <s:else>
					<span style="color: red">停用</span>
				</s:else>
			</td>
		</tr>
	</table>

	<p>门户信息</p>
	<table style="border: #CCC 1px solid; width: 1200px;">
		<tr>
			<td>法人代表：<s:property value="customs.bossName" /></td>
			<td>注册日期:<s:date name="customs.regDatetime" format="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td>证件类型：<s:property value="customs.cardTypeName" /></td>
			<td>证件号码：<s:property value="customs.cardNum" /></td>
		</tr>
		<tr>
			<td>国家：<s:property value="customs.country" /></td>
			<td>省/地区：<s:property value="province.province" /></td>
		</tr>
		<tr>
			<td>公司传真：<s:property value="customs.companyFax" /></td>
			<td>城市：<s:property value="cityName" /></td>
		</tr>
		<tr>
			<td>公司电话：<s:property value="customs.companyTel" /></td>
			<td>区：<s:property value="areaName" /></td>
		</tr>
		<tr>
			<td>公司地址：<s:property value="customs.companyAddress" /></td>
		</tr>
		<tr>
			<td>备注：<s:property value="customs.memo" /></td>
		</tr>
	</table>
	<p>联系人信息</p>
	<table class="border">
		<s:iterator value="contacts">
			<tr style="width: 200px;">
				<td>姓名：<s:property value="contactName" /></td>
				<td>电话：<s:property value="contactTel" /></td>
				<td>传真：<s:property value="contactFax" /></td>
				<td>邮箱：<s:property value="contactEmail" /></td>
				<td>职务：<s:property value="contactRole" /></td>
			</tr>
		</s:iterator>
	</table>
	<div class="last">
		<a href="pageList"><img src="image/u57.png" /></a>
	</div>
	<div style="height: 170px;"></div>
</body>
</html>

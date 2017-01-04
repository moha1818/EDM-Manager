<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预付款流水报表</title>
<link href="css/report.css" type="text/css" rel="stylesheet" />
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>预付款流水报表</h1>
<div id="download"><a href="exportExcel?reportType=<s:property value="reportType"/>"><img alt="EXCLE下载" src="image/report/u7.png"></a></div>
			<table>
			<tr class="title">
				<td>序号</td>
				<td>代理商名称</td>
				<td>预付款</td>
				<td>账户余额</td>
				<td>备注信息</td>
				<td>时间</td>
			</tr>
			<s:iterator value="detail" var="detail" status="status">
			<tr>
				<td><s:property value="#status.index+1"/></td>
				<td><s:property value="#detail.user.userName"/></td>
				<td><s:number name="#detail.money"/></td>
				<td><s:number name="#detail.accountMoney"/></td>
				<td><s:property value="#detail.memo"/></td>
				<td><s:date name="#detail.detailDateTime"/></td>
			</tr>	
			</s:iterator>
			</table>
		<div id="foot"></div>
</body>
</html>
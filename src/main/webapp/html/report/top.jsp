<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表管理</title>
<script type="text/javascript" src="js/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<link href="css/reportManager.css" type="text/css" rel="stylesheet" />

</head>

<body>
<form action="getReport" method="get">
<div id="box">
操作类型：<s:select name="reportType" list="#{'1':'财务报表',
						'balance':'- - - - 代理商账户余额报表',
						'preRunning':'- - - - 预付款流水报表',
						'agentRunning':'- - - - 代理商流水报表',
						'2':'产品报表',
						'categories':'- - - - 产品分类数量/金额汇总'				
					}"  listKey="key" listValue="value"></s:select>					 
操作时间：<s:textfield class="laydate-icon" id="demo" name="starttime"/> 至 <s:textfield class="laydate-icon" id="demo1" name="endtime"/>
<script type="text/javascript" src="js/laydate-2.js"></script>
<input id="search" type="image" src="image/keywords review/u3.png" />
</div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

	<link type="text/css" rel="stylesheet" href="dist/css/zui.css" />
<link rel="stylesheet" type="text/css" href="css/agentmanage/2.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/agentmanage.js"></script>
	<script src="dist/js/zui.js"></script>
<script type="text/javascript">
window.onload = function(){
	$(window.parent.document).find('#n3').html('');
}
	$(function(){
	$('#see').click(function(){
		$(window.parent.document).find('#n3').html('&#92;&nbsp;查看客户信息');
	})
	$('#upd').click(function(){
		$(window.parent.document).find('#n3').html('&#92;&nbsp;修改客户信息');
	})
	$('#add').click(function(){
		$(window.parent.document).find('#n3').html('&#92;&nbsp;添加客户信息');
	})
		
	var page='<s:property value="#parameters.current"/>';
	if(page==""){
		page=1;
	}
	var x=$(".page").text();
	for(i=0;i<x.length;i++){
		if($(".page").eq(i).text()==page){
			$(".page").eq(i).addClass("pagecss");
		}
	}
	});
</script>
</head>
<body>
	<form id="head1" action="pageList" method="get">
		<span>客户名称：</span>
		<s:textfield name="name" />
		<a class="btn btn-primary btn-mini sub" href="javascript:void(0);">查询</a>
	</form>
	<div id="u2">
		<%--<a href="javascript:void(0);" id="add"> <img src="image/addcustomeru2.png" />
		</a>--%>
		<a class="btn btn-primary"  href="javascript:void(0);" id="add"><i class="icon icon-plus-sign"></i>添加企业</a>
	</div>
	<table class="table table-hover table-bordered">
		<thead>

			<tr>
				<th>序号</th>
				<th>企业名称</th>
				<th>法人代表</th>
				<th>注册时间</th>
				<th>类型</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>

		<s:iterator value="cusPage.list" status="li">
			<tr>
				<td><s:property value="#li.index+1" /></td>
				<td><s:property value="customName" /></td>
				<td><s:property value="bossName" /></td>
				<td><s:date name="regDatetime" format="yyyy-MM-dd" /></td>
				<td><s:property value="customTypeName" /></td>
				<td><s:if test="customStatus==1">
					<span class="label label-badge label-success">启用</span>
					</s:if> <s:else>
					<span class="label label-badge label-warning">停用</span>
					</s:else></td>
				<td><a class="btn btn-sm" href="see_cus?id=<s:property value="id" />" id="see">查看</a>
					<a class="btn btn-sm btn-primary" href="modify_cus?id=<s:property value="id" />" id="upd">修改</a>
					<a class="btn btn-sm <s:if test="customStatus==1">btn-danger</s:if><s:else>btn-success</s:else>"
					   href="javascript:void(0);" id="cli" onclick="confir(this,<s:property value="id" />)">
						<s:if test="customStatus==1">
							<span>停用</span>
						</s:if>
						<s:else>
							<span>启用</span>
						</s:else>
					</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<div id="pager">
		<ul>
			<li><a
				href="pageList?name=<s:property value="#parameters.name"/>">首页</a></li>
			<s:if test="current!=1">
				<li style="width: 30px;"><a style="width: 30px;"
					href="pageList?current=<s:property value="current-1"/>&name=<s:property value="#parameters.name"/>">〈</a></li>
			</s:if>
			
			<s:if test="cusPage.pageCount<8">
			<s:iterator begin="1" end="cusPage.pageCount" var="n">
				<li class="page"><a
					href="pageList?current=<s:property value="n"/>&name=<s:property value="#parameters.name"/>"><s:property
							value="n" /></a></li>
			</s:iterator>
			</s:if>
			<s:else>
			<s:if test="current-4<=0">
				<s:iterator begin="1" end="8" var="n">
						<li class="page"><a
					href="pageList?current=<s:property value="n"/>&name=<s:property value="#parameters.name"/>"><s:property
							value="n" /></a></li>
				</s:iterator>
			</s:if>
			<s:if test="cusPage.pageCount-current<=4">
				<s:iterator begin="cusPage.pageCount-7" end="cusPage.pageCount" var="n">
						<li class="page"><a
					href="pageList?current=<s:property value="n"/>&name=<s:property value="#parameters.name"/>"><s:property
							value="n" /></a></li>
				</s:iterator>
			</s:if>
			<s:if test="current-4>0 &&cusPage.pageCount-current>4">
				<s:iterator begin="current-3" end="current+4" var="n">
						<li class="page"><a
					href="pageList?current=<s:property value="n"/>&name=<s:property value="#parameters.name"/>"><s:property
							value="n" /></a></li>
				</s:iterator>
			</s:if>
			</s:else>
			
			<s:if test="current!=cusPage.pageCount">
				<li style="width: 30px;"><a style="width: 30px;"
					href="pageList?current=<s:property value="current+1"/>&name=<s:property value="#parameters.name"/>">〉</a></li>
			</s:if>
			<li><a
				href="pageList?current=<s:property value="cusPage.pageCount"/>&name=<s:property value="#parameters.name"/>">尾页</a></li>
		</ul>
	</div>
	<div style="height: 170px;"></div>
	<s:if test="cusPage.list.size()==0">
		<script type="text/javascript">
			alert("请输入存在客户名称！");
			location.href = "pageList";
		</script>
	</s:if>
</body>
</html>

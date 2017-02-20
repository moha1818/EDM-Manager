<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代理商系统后台-登录</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/sh_css.css" rel="stylesheet"type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<s:if test="msg!=null">
	<script type="text/javascript">
	var msg = "<s:property value='msg' />"
	alert(msg);	
	</script>
</s:if>
<script type="text/javascript">
			$(document).ready(function(){
				$("#verifypic").click(function(){
	         		$("#validateCode").attr("src","codes.jsp?id=" + Math.random());
				});
				
				//密码显示
				var password=$("#password").val();
				if(password==''){
					$("#coverPass").css("display","block");
					$("#password").css("display","none");
				}else{
					$("#coverPass").css("display","none");
					$("#password").css("display","block");
				}
				$("#coverPass").focus(function(){
					$(this).css("display","none");
					$("#password").css("display","block");
					$("#password").focus();
				});
				$("#password").blur(function(){
					if($(this).val()==''){
						$("#coverPass").css("display","block");
						$(this).css("display","none");
					}
				});
		
			});
			
			function formSubmit() {
					var userName = $("#userName").val();
			    	var password = $("#password").val();
			    	var merId=$("#agencyId").val();
			    	var code = $("#code").val();
			    	if(merId=null || merId==''||merId=='商户号'){
			    		alert('商户号不能为空!');
			    		$("#agencyId").focus();
			    		return false;
			    	}else if(userName=null || userName==''||userName=='用户名'){
			    		alert('用户名不能为空!');
			    		$("#userName").focus();
			    		return false;
			    	}else if(password==null || password==''||password=='密码'){
			    		alert('密码不能为空!');
			    		$("#password").focus();
			    		return false;
			    	}else if(code==null || code==''||code=='密码'){
			    		alert('验证码不能为空!');
			    		$("#code").focus();
			    		return false;
			    	}
			    	this.loginForm.submit();
				}
				
				//按回车提交 
				function keydown(e){ 
					var explorer = window.navigator.userAgent ;
					//ie //Chrome
					if (explorer.indexOf("MSIE") >= 0||explorer.indexOf("Chrome") >= 0) {
						if (event.keyCode == 13)   
					       {    
					          formSubmit();      
					       }    
					}
					//firefox 
					else if (explorer.indexOf("Firefox") >= 0) {
						if (e.which== 13)   
					       {    
					           formSubmit();  
					       }    
					}
				} 
				document.onkeydown=keydown;
		</script>
	</head>
	<body>
		<div class="sh_top">
			<div class="sht_logo">
				<a href="#"><img src="img/login_02.jpg"
						width="690" height="74" /> </a>
			</div>
		</div>
		<div class="sh_main">
			<div class="sh_image">
				<div class="shm">
					<div class="sh_cont">
						<div class="shc_top"></div>
						<div class="shc_center">
							<div class="shcc_img">
								<img src="img/login_12.png" width="10"
									height="12" />
							</div>
							<div class="shcc_left">
								<img src="img/login_08.jpg" width="199"
									height="178" />
							</div>
							<div class="shcc_right">
								<p class="wrong">
									
								</p>
								<form id="loginForm"
									action="login"
									method="post">
									<table border="0" cellspacing="0" cellpadding="0">
										<!--<tr>
											<td colspan="3">
												<input name="agencyId" class="inputstyle" type="text"
													id="agencyId"
													onfocus="if(this.value=='商户号') {this.value='';}this.style.color='#333';"
													onblur="if(this.value=='') {this.value='商户号';this.style.color='#b2b2b2';}"
													value="商户号"
													 />
											</td>
										</tr>-->
										<tr>
											<td colspan="3">
												<input name="usercode" type="text" class="inputstyle2"
													id="userName"
													onfocus="if(this.value=='用户名') {this.value='';}this.style.color='#333';"
													onblur="if(this.value=='') {this.value='用户名';this.style.color='#b2b2b2';}"
													value="用户名"
													 />
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<input type="text" value="密码" style="color: #b2b2b2;"
													class="inputstyle3" id="coverPass" />
												<input name="password" class="inputstyle3" id="password"
													type="password" style="display: none"
													onfocus="if(this.value=='') {this.style.color='#333';}"
													value="" />
											</td>
										</tr>
										<tr>
											<td width="95">
												<input type="text" class="inputstyle4" name="code" id="code"
													onfocus="if(this.value=='验证码') {this.value='';}this.style.color='#333';"
													onblur="if(this.value=='') {this.value='验证码';this.style.color='#b2b2b2';}"
													value="验证码" />
											</td>
											<td width="104">
												<img src="codes.jsp"
													id="validateCode" border="0" width="94" height="41"
													 align="top" title="刷新验证码" alt="验证码"
													style="cursor: pointer;" />
											</td>
											<td width="131">
												<a id="verifypic" style="cursor: pointer;">看不清,换一张？</a>
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<img src="img/login_26.jpg" width="274"
													onclick="formSubmit();" height="42" />
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<!--  <a href="#">忘记密码？</a>-->
											</td>
										</tr>
									</table>
								</form>
							</div>
							<div class="clear"></div>
						</div>
						<div class="shc_bottom"></div>
						<div class="shc_text">
							
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</body>
</html>
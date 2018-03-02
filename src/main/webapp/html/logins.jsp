<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="Keywords" content="关键字">
    <meta name="description" content="登录页面描述">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/mains.css">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <s:if test="msg!=null">
        <script type="text/javascript">
            var msg = "<s:property value='msg' />"
            alert(msg);
        </script>
    </s:if>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".clickCode").click(function () {
                $("#imageCode").attr("src", "codes.jsp?id=" + Math.random());
            });

            $(".subutton").click(function(){
                formSubmit();
            })
        });

        function formSubmit() {
            var userName = $(".name").val();
            var password = $(".password").val();
            var code = $(".validateCode").val();
            if(userName==null || userName==''||userName=='用户名'){
                alert('用户名不能为空!');
                $(".name").focus();
                return false;
            }else if(password==null || password==''||password=='密码'){
                alert('密码不能为空!');
                $(".password").focus();
                return false;
            }else if(code==null || code==''||code=='密码'){
                alert('验证码不能为空!');
                $(".validateCode").focus();
                return false;
            }

            $.ajax({
                 url: 'login',
                 async: false,
                 type: "get",
                 data:  "usercode="+userName+"&password="+password+"&code="+code,
                 dataType:'json',
                 success: function (data) {
                     if(data == "成功"){
                         window.parent.location.href='/html/main';
                     }
               }
            })
            //this.loginForm.submit();
        }


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
<div class="wrap">
    <div class="header" style="height: auto;">
        <h3>EDM营销管理系统</h3>
    </div>
    <div class="main">
        <div class="main-left">
            <img src="images/7.png" style="height: 282px;">
        </div>
        <div class="main-right">
            <form id="loginForm" method="post">
                <h4>用户登录</h4>            <!-- 注意分区-->
                <div class="username">
                    <img src="images/3.png">
                    <input type="text" name="usercode" class="name" placeholder="用户名"/><br/>
                </div>
                <div class="code">
                    <img src="images/4.png">
                    <input type="password" name="password" class="password" placeholder="密码"/><br/>
                </div>
                <div class="vcode">
                    <a href="javascript:void(0);" class="clickCode" tabindex="-1">
                        <img class="vcodeleft" src="images/updateIcon.png">
                    </a><input type="text" name="code" class="validateCode" placeholder="验证码"/>
                    <div>
                        <img src="codes.jsp"
                             class="clickCode" id="imageCode" border="0" width="90" height="40"
                             align="top" title="刷新验证码" alt="验证码"
                             style="cursor: pointer;" />
                    </div>
                    <br/>
                </div>
                <div class="reminder1">
                    <div class="reminder-left">
                        <input type="checkbox" name="optionButton" />
                        <span>下次自动登录</span>
                    </div>
                </div>
                <input type="button" value="登录" class="button subutton" />
                <br/>
            </form>

        </div>
    </div>
</div>
</body>
</html>
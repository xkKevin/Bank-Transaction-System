<%@ page language="java" isErrorPage="true" pageEncoding="utf-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class = "com.XK.Bean.UserBean" scope = "session">
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="style.css" />
<style type="text/css">
      body {
        margin: 10px;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #fff;
      }
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
    </style>
    <% String prompt = (String)request.getAttribute("prompt"); %>
    <script type="text/javascript">
    	var prompt ="<%=prompt%>";
    	if(prompt!="null"){
    		alert(prompt);
    		prompt="null";
    	}	
    </script>
</head>
<body>

<div class="container" align="center">
      
     <h1>银行自助系统</h1>
 
      <form class="form-signin" action="${pageContext.request.contextPath}/UserServlet?method=login" method="post" >
        <h3 class="form-signin-heading"><strong>用户登录</strong></h3>
        <div>
        <input id="username" type="text" class="input-block-level" name="username" placeholder="帐号"/>
        <input id="password" type="password" class="input-block-level" name="password" placeholder="密码"><br>
      	<button id="login" type="submit" class="btn btn-primary">登录</button>
      	<button type="reset" class="btn btn-primary">重置</button>
      	<a href="Register.jsp">点击注册</a>
       </div>
      </form>
     
    </div> 
</body>
<script type="text/javascript">
				var login = document.getElementById("login");
				login.onclick = function(){
					var username = document.getElementById("username");
					var password = document.getElementById("password");
					if(username.value==""||password.value==""){
						alert("请输入用户名或密码！");
						return false;
					}
					return true;
				}
</script>
</html>
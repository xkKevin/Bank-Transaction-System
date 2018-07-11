<%@ page language="java" isErrorPage="true" pageEncoding="utf-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class = "com.XK.Bean.UserBean" scope = "page">
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
    	}
    	
    	function CheckPSD() {
    		var repsd=document.getElementById("repsd");
    		var psd=document.getElementById("psd");
    		var user=document.getElementById("username");
    		if(user.value==""){
    			window.alert("用户名不能为空！");
    			return false;
    		}else if(user.value.length<3){
    			window.alert("用户名不能小于3位！");
    			return false;
    		}else if(psd.value==""){
    			window.alert("密码不能为空！");
    			return false;
    		}else if(psd.value!=repsd.value){
    			window.alert("两次密码输入不匹配");
    			repsd.value="";
    			return false;
    		}
			return true;
		}
    </script>
</head>
<body>

<div class="container" align="center">
      
     <h1>银行自助系统</h1>
 
      <form class="form-signin" action="${pageContext.request.contextPath}/UserServlet?method=register" method="post" >
        <h3 class="form-signin-heading"><strong>用户注册</strong></h3>
        <div>
        <input id="username" type="text" class="input-block-level" name="username" placeholder="帐号"/>
        <input id="psd" type="password" class="input-block-level" name="password" placeholder="密码">
        <input id="repsd" type="password" class="input-block-level" name="password2" placeholder="确认输入密码" ><br>
      	<input type="submit" value="注册" onclick="return CheckPSD()"/>
      	<button type="reset" class="btn btn-primary">重置</button>
      	<a href="Login.jsp">返回登录</a>
       </div>
      </form>
     
    </div> 
</body>
</html>
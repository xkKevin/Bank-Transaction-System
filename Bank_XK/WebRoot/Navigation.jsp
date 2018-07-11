<%@ page language="java" import="java.util.*" import="com.ccnu.bean.*" pageEncoding="utf-8"%>
<!DOCTYPE html>

<jsp:useBean id="user" class = "com.XK.Bean.UserBean" scope = "session">
</jsp:useBean>

<html lang="zh-CN">
  <head>
    <title>银行系统主界面</title>
       <meta name="viewport" charset="utf-8" content="width=device-width, initial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
<!-- 可选的Bootstrap主题文件（一般不用引入） 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入  加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>  

    <style type="text/css">
    #accountInfo{
      margin:auto;
      width:600px;
      margin-top:60px;
       align:center;
    }
    #mytable{
      margin:auto;
      width:400px;
    }
    </style>
    <% 
    	String prompt = (String)request.getAttribute("prompt"); 
    	String balance = (String)request.getAttribute("balance"); 
    	String bank_info = (String)request.getAttribute("bank_info");
    %>
    <script type="text/javascript">
    	var prompt ="<%=prompt%>";
    	var balance = "<%=balance%>";
    	var bank_info = "<%=bank_info%>";
    	if(prompt!="null"){
    		alert(prompt);
    		prompt="null";
    	}	
    	if(balance!="null"){
    		alert(balance);
    		balance="null";
    	}
    	if(bank_info!="null"){
    		alert(bank_info);
    		bank_info="null";
    	}
    	function deposit(){
    		document.submit.action="${pageContext.request.contextPath}/AccountServlet?method=deposit";
    		document.submit.submit();
    	}
    	function withdraw(){
    		document.submit.action="${pageContext.request.contextPath}/AccountServlet?method=withdraw";
    		document.submit.submit();
    	}
    	function checkbalance(){
    		document.submit.action="${pageContext.request.contextPath}/AccountServlet?method=checkBalance";
    		document.submit.submit();
    	}
    </script>
    
  </head>
  <body>
    
	<div id="accountInfo" align="center"> 
	<h1 >欢迎使用银行自助系统</h1><br/>
		<a href="Navigation.jsp">主菜单</a>&nbsp;&nbsp;
       <a  href="Login.jsp">退出登录</a><br/><br/>
     
      <form name="submit" method="post" action="">
      	<button onclick="deposit()">存款</button>&nbsp;
      	<button onclick="withdraw()">取款</button>&nbsp;
      	<button onclick="checkbalance()">查询余额</button><br/><br/>
      	<input id="username" type="text" style="display:none" name="username" value="<%=session.getAttribute("username") %>"/>&nbsp;
      	存取款金额：<input id="info" type="text" name="info" placeholder="默认为 0 元"/>&nbsp;
      </form><br/>
      <h2>账户信息</h2>
	<table class="table table-hover" id="mytable">
   		<tr> 
			<td>用户名:</td>
			<td><%=session.getAttribute("username") %>  </td>
		</tr>
		
		<tr>
			<td>密码:</td>
			<td><%=session.getAttribute("password") %> </td>
		</tr>
	</table><br><br>
	</div>
 
  </body>
</html>

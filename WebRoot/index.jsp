<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="index.js"> </script>
  <body>
   	<fieldset>
   		<legend>用户登录</legend>
   		<form action="vaildPassword.do" method="POST">
   			<table>
   				<tr>
   					<td>用户名:</td>
   					<td><input type="text" name="username" id="username" onchange="loadUser(this.value);"/><span id="userText"></span></td>
   				</tr>
   				<tr>
   					<td>密码:</td>
   					<td><input type="password" name="password" id="pwd" onchange="loadPwd(this.value)"/><span id="pwdText"></span></td>
   				</tr>
   				<tr><td><input type="submit" value="登录"></td><td><a href="reg.jsp"><input type="button" value="注册"/></a></td></tr>
   			</table>
   			<%pageContext.include("include.jsp"); %>
   		</form>
   		
   	</fieldset>
  </body>
</html>

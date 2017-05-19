<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<script type="text/javascript">
	function $(str){
		return document.getElementById(str);
	}
	function checkUsername(){
		var xmlhttp;
		var username=$("username").value;
		if(username==""){
			alert("用户名不能为空");
			return false;
		}
		if(window.XMLHttpRequest){
			//如果是IE7以上的浏览器
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&& xmlhttp.status==200){
				var vaild=xmlhttp.responseText;
				if(vaild=="true"){
					alert("用户名已经存在");
					$("username").value="";
				}else{
					alert("恭喜用户名可以使用");
				}
			}
		}
		xmlhttp.open("post", "vaildUsername.do", true);
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlhttp.send("username="+username);
	}
</script>
</head>
<body>
	<fieldset>
		<legend>注册页面</legend>
		<form action="">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" id="username" name="username" /></td>
					<td><input type="button" id="checkuser" name="checkuser" value="检测用户" onclick="checkUsername();"></td>
				</tr>
			</table>
		</form>
		<!-- <% //pageContext.forward("index.jsp"); %> -->
	</fieldset>
	
</body>
</html>
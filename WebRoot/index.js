/**
 * ajax楠岃瘉鐢ㄦ埛鍚嶅拰瀵嗙爜
 */
//閫氳繃id鑾峰彇鍏冪礌
function $(id){
	return document.getElementById(id);
}
function loadUser(str){
	var xmlhttp;
	
	if(str==""){
		$("userText").style.color="red";
		$("userText").innerHTML="用户名不能为空";
		return ;
	}
	if(window.XMLHttpRequest){
		//IE7浠ヤ笂鏀寔
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			
			var vaild=xmlhttp.responseText;
			if(vaild=="true"){
				$("userText").style.color="green";
				$("userText").innerHTML="&radic;";
			}else{
				$("userText").style.color="red";
				$("userText").innerHTML="&times;";
			}
		}
	}
	xmlhttp.open("POST", "vaildUsername.do", true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("username="+str);
}

function loadPwd(str){
	var xmlhttp;
	if(str==""){
		return ;
	}
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
		
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			var vaild=xmlhttp.responseText;
			if(vaild=="true"){
				$("pwdText").style.color="green";
				$("pwdText").innerHTML="密码正确";
			}else{
				$("pwdText").style.color="red";
				$("pwdText").innerHTML="密码错误";
			}
		}
	}
	xmlhttp.open("POST","vaildPassword.do", true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("username="+$("username").value+"&password="+$("pwd").value);
}
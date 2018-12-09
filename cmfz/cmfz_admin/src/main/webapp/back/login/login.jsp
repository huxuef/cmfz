<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){

            // 记住用户名
            /*var name=decodeURI(getCookie("name")); // 做中文的解码  === 括号中name为用户名name的属性值
            console.log(name);
            if(name!=""){
                $("#name").val(name);  // name为用户名id的属性值
                $("#isRememberUsername").attr("checked");  // isRememberUsername为记住用户名id的属性值
            }*/

			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				//alert("自己做");
				$(this).attr("src","${pageContext.request.contextPath}/image/getImage.jpg?time="+Math.random());
			});
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				//alert("自己做");
				var name = $("#name").val();
				var password = $("#password").val();
				var code = $("#enCode").val();
				var isRememberUsername = $("#isRememberUsername").val();
                console.log(isRememberUsername);
				$.post(
				    "${pageContext.request.contextPath}/manager/login",
					{"name":name,"password":password,"enCode":code,"isRememberUsername":isRememberUsername},
					function(result){
				        if(result.success){
				            location.href="${pageContext.request.contextPath}/back/main/main/main.jsp";
						}else{
				            alert(result.message);
						}
					},"json");
				return false;
			});
		});



	</script>
</head>
<body>
	
		<div class="login" >
			<form id="loginForm" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="name"  name="name" class="text" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/image/getImage.jpg" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="isRememberUsername"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="./inc/meta.jsp"%>
<%@ include file="./inc/bootstrap.jsp"%>
</head>
<body>
	<img src="${basePath}/weblib/img/loginbg.png" width="100%" height="100%" style="z-index: -100; position: absolute; left: 0; top: 0">
	<div style="position: absolute; top: 10%; margin: 0 auto; width: 500px; left: 50%; margin-left: -250px;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center animated fadeInDown" style="margin-bottom: 50px;">
					<h2>欢迎登陆 求职网</h2>
				</div>
			</div>
			<div class="row" align="center">
				<div class="well col-lg-12 col-md-12 col-sm-12 col-xs-12 animated fadeInDown">
					<form id="loginForm" action="${basePath }/login.html" method="post">
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<i class="glyphicon glyphicon-user text-info" aria-hidden="true" style="margin: 0 5px;"></i>
								</div>
								<input type="email" class="form-control input-lg" name="username" id="username" placeholder="请输入电子邮箱" required autofocus>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-lock text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<input type="password" class="form-control input-lg" name="password" id="password" placeholder="请输入密码" required>
								<%--<div class="input-group-addon">
									<a href="javascript:void(0);" aria-hidden="true" tabindex="-1"><span class="glyphicon glyphicon-question-sign" style="font-size: 20px;" style="margin: 0 5px;" onclick="forgetPwd()"></span></a>
								</div>--%>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<img src="${basePath }/vcode.jpg" style="height: 30px; width: 100px; padding: 0px; margin: 0px;" onclick="this.src='${basePath }/vcode.jpg?'+Math.random()" />
								</div>
								<input type="text" name="validateCode" class="form-control input-lg" placeholder="请输入验证码" required />
							</div>
						</div>
						<div style="padding: 10px;">
							<span> <input type="checkbox" name="rememberMe" tabindex="-1" data-bv-excluded> 自动登陆
							</span>&nbsp;&nbsp;
							<button type="submit" class="btn btn-info btn-lg" id="loginBtn" style="width: 150px;">登陆</button>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									注册 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a href="${basePath }/user/registerPage1.html">求职者</a></li>
									<li><a href="${basePath }/user/registerPage2.html">用人单位</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center animated fadeInUp" style="margin-top: 10px;">
					<p>来求职网找好工作</p>
					<p>©2015 weishengze and guoyu</p>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			// 开启表单验证
			$('#loginForm').bootstrapValidator();
			// 提示错误信息
			var errmessage = '${errmessage}';
			if (errmessage != null && errmessage != '') {
				layer.msg(errmessage, {
					offset : 0,
					shift : 6
				});
			}
		});
		function forgetPwd() {
			//layer.msg('密码已进行加密！');
		}
	</script>
</body>
</html>
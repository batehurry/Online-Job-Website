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
					<h2>欢迎注册 求职网(用人单位注册)</h2>
				</div>
			</div>
			<div class="row" align="center">
				<form id="regForm">
					<!-- 账号信息 -->
					<div class="well col-lg-12 col-md-12 col-sm-12 col-xs-12 animated fadeInDown" id="baseform">
						<%-- 电子邮箱 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<i class="glyphicon glyphicon-user text-info" aria-hidden="true" style="margin: 0 5px;"></i>
								</div>
								<input type="email" class="form-control input-lg" name="userName" id="username" placeholder="请输入电子邮箱" required autofocus>
							</div>
						</div>
						<%-- 密码 --%>
						<div class="form-group">
							<div class="input-group " style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-lock text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<input type="password" class="form-control input-lg" name="userPwd" id="pwd" placeholder="请输入密码" required>
							</div>
						</div>
						<%-- 确认密码 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-lock text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<input type="password" class="form-control input-lg" name="pwdok" id="pwdok" placeholder="确认密码" required data-bv-identical="true" data-bv-identical-field="userPwd">
							</div>
						</div>
						<%-- 下一步 --%>
						<div style="padding: 10px;">
							<button type="button" class="btn btn-info btn-lg" id="nextBtn" onclick="next()" style="width: 150px;">下一步</button>
						</div>
					</div>
					<!-- 基本信息 -->
					<div class="well col-lg-12 col-md-12 col-sm-12 col-xs-12 animated fadeInDown" id="jform" hidden="hidden">
						<%-- 企业名称 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<i class="glyphicon glyphicon-user text-info" aria-hidden="true" style="margin: 0 5px;"></i>
								</div>
								<input type="text" class="form-control input-lg" name="name" placeholder="请输入企业名称" required>
							</div>
						</div>
						<%-- 企业类型 --%>
						<div class="input-group" style="padding: 10px;">
							<c:forEach items="${type }" var="t">
								<label class="radio-inline"><input type="radio" class="check" name="type" value="${t.id }" required checked> ${t.name } </label>
							</c:forEach>
						</div>
						<%-- 地址 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-glass text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<input type="text" class="form-control input-lg" name="enterpriseAdd" onclick="areaTree(this);" placeholder="请点击选择企业的地址" data-bv-excluded>
							</div>
						</div>
						<%-- 电话 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-earphone text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<input type="tel" class="form-control input-lg" name="tel" placeholder="请输入您的电话号码" required>
							</div>
						</div>
						<%-- 简介 --%>
						<div class="form-group">
							<div class="input-group" style="padding: 10px;">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-pencil text-info" aria-hidden="true" style="margin: 0 5px;"></span>
								</div>
								<textarea name="info" rows="5" class="form-control" placeholder="请输入企业的简介" required></textarea>
							</div>
						</div>
						<%-- 注册 --%>
						<div style="padding: 10px;">
							<button type="button" class="btn btn-info btn-lg" onclick="perv();" style="width: 150px;">上一步</button>
							<button type="button" class="btn btn-success btn-lg" onclick="regBtn();" style="width: 150px;">注册</button>
						</div>
					</div>
				</form>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center animated fadeInUp" style="margin-top: 10px;">
						<p>来求职网找好工作</p>
						<p>© 2015 weishengze and guoyu</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var errorInfo = '${errorInfo}';
			if(errorInfo != '') {
				layer.msg(errorInfo);
			}
			// 开启表单验证
			$('#baseform').bootstrapValidator();
		});
		function perv() {
			$('#jform').hide();
			$('#baseform').show();
			$('#baseform').bootstrapValidator();
		}
		function next() {
			var isValid = $('#baseform').data('bootstrapValidator').isValid();
			if (isValid == true) {
				$('#baseform').hide();
				$('#jform').show();
				$('#jform').bootstrapValidator();
			} else {
				layer.msg('请按正确格式填写');
			}
		}
		function regBtn() {
			$('#jform').bootstrapValidator();
			var isValid = true;//$('#jform').data('bootstrapValidator').isValid();
			if (isValid == true) {
				var json = iTsai.form.serialize($('#regForm'));
				delete json.pwdok;
				json.enterprise = {
							name : json.name,
							enterpriseAdd : json.enterpriseAdd,
							tel : json.tel,
							info : json.info,
							type : {
								id : json.type
							}
				}
				delete json.name;
				delete json.enterpriseAdd;
				delete json.tel;
				delete json.type;
				delete json.info;
				$.ajax({
		    		type : 'post',
		    		url : top.basePath + '/user/register2.html',
		    		data : JSON.stringify(json),
		    		contentType : 'application/json',
		    		dataType : 'json',
		    		success : function(data) {
		    			layer.msg(data.msg);
		    			if(data.success){
		    				setTimeout(function() {
		    					window.location.href = top.basePath + '/login.html'; 
		    				}, 2000);
		    			} else {
		    				setTimeout(function() {
		    					window.location.href = top.basePath + '/user/registerPage2.html';
		    				}, 2000);
		    			}
		    		}
		    	});
			} else {
				layer.msg('请按正确格式填写');
			}
		}
	</script>
</body>
</html>
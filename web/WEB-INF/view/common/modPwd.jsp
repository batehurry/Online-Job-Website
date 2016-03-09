<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="modPwdForm" class="form-horizontal">
				<div class="col-xs-12 col-md-12 col-sm-12">
					<div class="form-group">
						<div class="input-group " style="padding: 10px;">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock text-info" aria-hidden="true" style="margin: 0 5px;"></span>
							</div>
							<input type="password" class="form-control input-lg" name="userPwd" placeholder="请输入新密码" required>
						</div>
					</div>
					<%-- 确认密码 --%>
					<div class="form-group">
						<div class="input-group" style="padding: 10px;">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock text-info" aria-hidden="true" style="margin: 0 5px;"></span>
							</div>
							<input type="password" class="form-control input-lg" name="pwdok" placeholder="确认密码" required data-bv-identical="true" data-bv-identical-field="userPwd">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
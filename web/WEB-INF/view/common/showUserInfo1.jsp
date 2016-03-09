<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="userInfoForm" class="form-horizontal">
				<input name="id" style="display: none;">
				<input name="createDate" style="display: none;">
				<input name="updateDate" style="display: none;">
				<div class="form-group">
					<label for="userInfoForm" class="col-xs-3 col-md-3 col-sm-2 control-label">姓名</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="name" class="form-control" placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="userInfoForm" class="col-xs-3 col-md-3 col-sm-2 control-label">性别</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<div fieldset="sex">
							<c:forEach items="${sex }" var="t">
								<label class="radio-inline"> <input type="radio" name="id" value="${t.id }">${t.name }</label>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="userInfoForm" class="col-xs-3 col-md-3 col-sm-2 control-label">年龄</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="name" class="form-control" placeholder="请输入年龄">
					</div>
				</div>
				<div class="form-group">
					<label for="userInfoForm" class="col-xs-3 col-md-3 col-sm-2 control-label">电话</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="tel" class="form-control">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	var userInfo = $.parseJSON('${userInfo}');
	$('#userInfoForm')[0].reset();
	iTsai.form.deserialize($('#userInfoForm'), userInfo);
})
</script>
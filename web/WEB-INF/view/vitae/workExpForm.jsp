<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="workExpForm" class="form-horizontal" data-bv-feedbackicons-valid="glyphicon glyphicon-ok" data-bv-feedbackicons-invalid="glyphicon glyphicon-remove" data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				<input name="id" style="display: none;">
				<div fieldset="user">
					<input name="id" style="display: none;">
				</div>
				<input name="createDate" style="display: none;">
				<input name="updateDate" style="display: none;">
				<div class="form-group">
					<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2 control-label">公司/企业名称</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="etpName" class="form-control" placeholder="请输入公司/企业名称" required autofocus>
					</div>
				</div>
				<div class="form-group">
					<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2 control-label">开始时间</label>
					<div class="form-inline col-xs-9 col-md-9 col-sm-8">
						<input class="form-control" name="startDate" id="startDate" type="text" onchange="timeValidator()" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'%y-%M-%d'})">
					</div>
				</div>
				<div class="form-group">
					<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2 control-label">截止时间</label>
					<div class="form-inline col-xs-9 col-md-9 col-sm-8">
						<input class="form-control" name="endDate" id="endDate" type="text" onchange="timeValidator()" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'%y-%M-%d'})">
					</div>
				</div>
				<div class="form-group">
					<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2 control-label">工作内容</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<textarea class="form-control" name="info" rows="3" placeholder="请输入工作内容" required></textarea>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function checkTime() {
	var startTime = $("#startDate").val();
	var start = new Date(startTime.replace('-', '/'));
	var endTime = $("#endDate").val();
	var end = new Date(endTime.replace('-', '/'));
	if (end < start) {
		return false;
	}
	return true;
}
function timeValidator() {
	if(!checkTime()) {
		layer.alert('截止时间不能小于开始时间');
		$('#startDate').val('');
		$('#endDate').val('');
	}
}
$(function() {
	$('#workExpForm').bootstrapValidator();
})
</script>
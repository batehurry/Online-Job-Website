<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="publishPositionForm" class="form-horizontal">
				<input name="id" style="display: none;">
				<div fieldset="user">
					<input name="id" style="display: none;">
				</div>
				<input name="createDate" style="display: none;">
				<input name="updateDate" style="display: none;">
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">行业</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<select class="form-control selectator" name="industry" onchange="loadPost(this, 'postSelect')" required="required">
							<option value="">---请选择---</option>
							<c:forEach items="${industry }" var="t">
								<option value="${t.id }">${t.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">职位</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<div fieldset="position">
							<select name="id" id="postSelect" class="form-control selectator" required="required">
								<option value="">---请选择---</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">工作地点</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="workAdd" onclick="areaTree(this)" class="form-control" data-bv-excluded>
					</div>
				</div>
				
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">招聘人数</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="number" name="peopleNumber" class="form-control" placeholder="请输入招聘的人数" required="required" min="1" max="1000">
					</div>
				</div>
				
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">职位薪资</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<div fieldset="salary">
							<select name="id" class="form-control selectator">
								<option value="">---请选择---</option>
								<c:forEach items="${salary }" var="t">
									<option value="${t.id }">${t.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="publishPositionForm" class="col-xs-3 col-md-3 col-sm-2 control-label">招聘详情</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<textarea name="info" rows="5" class="form-control" required="required"></textarea>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$('#publishPositionForm').bootstrapValidator();
})
</script>
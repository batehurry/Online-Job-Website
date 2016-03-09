<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="viteaForm" class="form-horizontal" data-bv-feedbackicons-valid="glyphicon glyphicon-ok" data-bv-feedbackicons-invalid="glyphicon glyphicon-remove" data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				<input name="id" style="display: none;">
				<div fieldset="user">
					<input name="id" style="display: none;">
				</div>
				<input name="createDate" style="display: none;">
				<input name="updateDate" style="display: none;">
				<div id="baseform" data-bv-feedbackicons-valid="glyphicon glyphicon-ok" data-bv-feedbackicons-invalid="glyphicon glyphicon-remove" data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
					<h4 style="color: blue;">基本信息</h4>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">简历名称</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="title" class="form-control" placeholder="请输入简历名称" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">姓名</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="name" class="form-control" placeholder="请输入姓名" required>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">性别</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="sex">
								<c:forEach items="${sex }" var="t">
									<label class="radio-inline"> <input class="check" type="radio" name="id" value="${t.id }" checked>${t.name }</label>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">生日</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input class="form-control" name="birthday" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'%y-%M-%d'})">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">身份证号</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="idCard" class="form-control" pattern="^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$" data-bv-message="请填写正确的身份证号" data-bv-notempty-message="请填写身份证号" required>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">现居地</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="presentAdd" onclick="areaTree(this)" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">户口所在地</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="householdAdd" onclick="areaTree(this)" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">身高（厘米）</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="number" min="50" max="250" name="stature" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">体重（千克）</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="number" min="20" max="150" name="weight" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">婚育状况</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="married">
								<select name="id" class="form-control selectator">
									<option value="">---请选择---</option>
									<c:forEach items="${married }" var="t">
										<option value="${t.id }">${t.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">电话</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="tel" name="tel" class="form-control" required>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">Email</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="email" name="email" class="form-control" required>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">微信</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="weChat" class="form-control"  data-bv-excluded>
						</div>
					</div>
					<%-- 下一步 --%>
					<div style="padding: 10px;" align="center">
						<button type="button" class="btn btn-info btn-sm" id="nextBtn" onclick="next()" style="width: 150px;">下一步</button>
					</div>
				</div>
				<div id="jobform" hidden="hidden" data-bv-feedbackicons-valid="glyphicon glyphicon-ok" data-bv-feedbackicons-invalid="glyphicon glyphicon-remove" data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
					<h4 style="color: blue;">求职信息</h4>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">目前状况</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="workExpState">
								<select name="id" class="form-control selectator">
									<option value="">---请选择---</option>
									<c:forEach items="${workExpState }" var="t">
										<option value="${t.id }">${t.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">参加工作时间/毕业时间</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input class="form-control" name="workDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'%y-%M-%d'})">
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">工作状况</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="workState">
								<select name="id" class="form-control selectator">
									<option value="">---请选择---</option>
									<c:forEach items="${workState }" var="t">
										<option value="${t.id }">${t.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">工作类型</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="workType">
								<select name="id" class="form-control selectator">
									<option value="">---请选择---</option>
									<c:forEach items="${workType }" var="t">
										<option value="${t.id }">${t.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">相关行业</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<select class="form-control selectator" name="industry" onchange="loadPost(this, 'postSelect')" required>
								<option value="">---请选择---</option>
								<c:forEach items="${industry }" var="t">
									<option value="${t.id }">${t.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">相关职位</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="position">
								<select name="id" id="postSelect" class="form-control selectator" required></select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">工作地点</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<input type="text" name="workAdd" class="form-control" required>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">期望薪资</label>
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
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">主要教育经历</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="educationExp">
								<select class="form-control selectator" name="id" data-bv-excluded>
									<option value="">---请选择---</option>
									<c:forEach items="${educationExpList }" var="edu">
										<option value="${edu.id }">${edu.schoolName } (
											<fmt:formatDate value="${edu.startDate }" pattern="yyyy.MM.dd" />~
											<fmt:formatDate value="${edu.endDate }" pattern="yyyy.MM.dd" />)
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">主要工作经验</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<div fieldset="workExp">
								<select class="form-control selectator" name="id" data-bv-excluded>
									<option value="">---请选择---</option>
									<c:forEach items="${workExpList }" var="work">
										<option value="${work.id }">${work.etpName } (
											<fmt:formatDate value="${work.startDate }" pattern="yyyy.MM.dd" />~
											<fmt:formatDate value="${work.endDate }" pattern="yyyy.MM.dd" />)
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="viteaForm" class="col-xs-3 col-md-3 col-sm-2 control-label">自我简介</label>
						<div class="col-xs-9 col-md-9 col-sm-8">
							<textarea name="selfEval" rows="5" class="form-control" required></textarea>
						</div>
					</div>
					<div style="padding: 10px;" align="center">
						<button type="button" class="btn btn-info btn-sm" onclick="perv();" style="width: 150px;">上一步</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function perv() {
	$('#jobform').hide();
	$('#baseform').show();
	//$('#baseform').bootstrapValidator();
}
function next() {
	/* var isValid = $('#baseform').data('bootstrapValidator').isValid();
	if (isValid == true) { */
		$('#baseform').hide();
		$('#jobform').show();
		/* $('#jobform').bootstrapValidator();
	} else {
		layer.msg('请按正确格式填写');
	} */
}
$(function() {
	var educationExpCount = '${educationExpList.size()}';
	var workExpCount = '${workExpList.size()}';
	if (educationExpCount == 0 || workExpCount == 0) {
		layer.msg('您还没有添加教育经历或工作经验，建议先去添加！');
	}
	$('.check').iCheck({
		checkboxClass : 'icheckbox_flat-blue',
		radioClass : 'iradio_flat-blue'
	});
	//$('#baseform').bootstrapValidator();
	$('#viteaForm').bootstrapValidator();
})
</script>
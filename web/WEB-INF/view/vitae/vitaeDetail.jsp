<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px;">
	<div class="col-xs-12 col-md-12 col-sm-12">
		<h4 style="color: blue;">基本信息</h4>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">简历名称</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="title"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">姓名</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="name"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">性别</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="sex"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">生日</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="birthday"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">身份证号</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="idCard"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">现居地</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="presentAdd"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">户口所在地</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="householdAdd"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">身高（厘米）</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="stature"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">体重（千克）</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="weight"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">婚育状况</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="married"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">电话</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="tel"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">Email</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="email"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">微信</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="weChat"></div>
		</div>
		<hr>
		<h4 style="color: blue;">求职信息</h4>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">目前状况</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workExpState"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">参加工作时间/毕业时间</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workDate"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">工作状况</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workState"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">工作类型</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workType"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">相关行业</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="industry"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">相关职位</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="position"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">工作地点</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workAdd"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">期望薪资</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="salary"></div>
		</div>
		<div class="row" style="margin-bottom: 3px;">
			<label class="col-xs-3 col-md-3 col-sm-2">主要教育经历</label>
			<div class="col-xs-9 col-md-9 col-sm-8">
				<button class="btn btn-info btn-sm" onclick="openLookDetail('vitae/educationExpDetail.html');">查看详情</button>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">主要工作经验</label>
			<div class="col-xs-9 col-md-9 col-sm-8">
				<button class="btn btn-info btn-sm" onclick="openLookDetail('vitae/workExpDetail.html');">查看详情</button>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">自我简介</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="selfEval"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	try {
		var index = top.index;
		var id = top.rowInfo[index].id;
		var json = top.rowInfo[index].vitae;
		$.post('${basePath}/vitaeRecord/updateVitaeReadStatus.html', {'id' : id}, function() {

		}, 'json');
		$('#title').html('<p>' + json.title +'</p>');
		$('#name').html('<p>' + json.name +'</p>');
		$('#sex').html('<p>' + json.sex.name +'</p>');
		$('#birthday').html('<p>' + json.birthday +'</p>');
		$('#idCard').html('<p>' + json.idCard +'</p>');
		$('#presentAdd').html('<p>' + json.presentAdd +'</p>');
		$('#householdAdd').html('<p>' + json.householdAdd +'</p>');
		$('#stature').html('<p>' + json.stature +'</p>');
		$('#weight').html('<p>' + json.weight +'</p>');
		$('#married').html('<p>' + json.married.name +'</p>');
		$('#tel').html('<p>' + json.tel +'</p>');
		$('#email').html('<p>' + json.email +'</p>');
		$('#weChat').html('<p>' + json.weChat +'</p>');
		$('#workExpState').html('<p>' + json.workExpState.name +'</p>');
		$('#workDate').html('<p>' + json.workDate +'</p>');
		$('#workState').html('<p>' + json.workState.name +'</p>');
		$('#workType').html('<p>' + json.workType.name +'</p>');
		$('#industry').html('<p>' + json.position.industry.name +'</p>');
		$('#position').html('<p>' + json.position.name +'</p>');
		$('#workAdd').html('<p>' + json.workAdd +'</p>');
		$('#salary').html('<p>' + json.salary.name +'</p>');
		$('#selfEval').html('<p>' + json.selfEval +'</p>');
	} catch (e) {
		log(e);
	}
})
</script>
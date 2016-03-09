<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="col-xs-12 col-md-12 col-sm-12">
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">选择招聘的行业</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="industry"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">选择招聘的职位</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="position"></div>
		</div>
		
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">工作地点</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="workAdd"></div>
		</div>
		
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">招聘人数</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="peopleNumber"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">职位薪资</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="salary"></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">招聘详情</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="info"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	try {
		var index = top.index;
		var json = top.rowInfo[index];
		$('#industry').html('<p>' + json.position.industry.name +'</p>');
		$('#position').html('<p>' + json.position.name +'</p>');
		$('#workAdd').html('<p>' + json.workAdd +'</p>');
		$('#peopleNumber').html('<p>' + json.peopleNumber +'</p>');
		$('#salary').html('<p>' + json.salary.name +'</p>');
		$('#info').html('<p>' + json.info +'</p>');
	} catch (e) {
		log(e);
	}
})
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="col-xs-12 col-md-12 col-sm-12">
		<div class="row">
			<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2">公司/企业名称</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="etpName"></div>
		</div>
		<div class="row">
			<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2">开始时间~截止时间</label>
			<div class="form-inline col-xs-9 col-md-9 col-sm-8" id="time"></div>
		</div>
		<div class="row">
			<label for="workExpForm" class="col-xs-3 col-md-3 col-sm-2">工作内容</label>
			<div class="col-xs-9 col-md-9 col-sm-8" id="info"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	try {
		var index = top.index;
		var json = top.rowInfo[index].vitae.workExp;
		$('#etpName').html('<p>' + json.etpName +'</p>');
		$('#time').html('<p>' + json.startDate + ' ~ ' + json.endDate +'</p>');
		$('#info').html('<p>' + json.info +'</p>');
	} catch (e) {
		log(e);
	}
})
</script>
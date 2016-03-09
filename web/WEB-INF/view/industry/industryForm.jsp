<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="industryForm" class="form-horizontal">
				<input name="id" style="display: none;">
				<input name="createDate" style="display: none;">
				<input name="updateDate" style="display: none;">
				<div class="form-group">
					<label for="industryForm" class="col-xs-3 col-md-3 col-sm-2 control-label">行业名称</label>
					<div class="col-xs-9 col-md-9 col-sm-8">
						<input type="text" name="name" class="form-control" placeholder="请输入行业名称" required="required">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$('#industryForm').bootstrapValidator();
})
</script>
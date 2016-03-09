<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../common/header.jsp"%>
<!-- 网站主体 Start -->
<div class="container" id="container">
	<div class="row" id="page">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<h3>管理行业</h3>
			<table id="industryTable"></table>
		</div>
	</div>
</div>
<!-- 工具栏（增加、删除、修改） -->
<div id="toolbar">
	<button type="button" class="btn btn-success" onclick="openDetail('${basePath}/industry/industryForm.html', '${basePath}/industry/saveIndustry.html', '${basePath}/industry/editIndustry.html', 'industryTable', 'industryForm');">增加</button>
	<button type="button" class="btn btn-info" onclick="edit('${basePath}/industry/industryForm.html', '${basePath}/industry/saveIndustry.html', '${basePath}/industry/editIndustry.html', 'industryTable', 'industryForm');">修改</button>
	<button type="button" class="btn btn-danger" onclick="delte('${basePath}/industry/deleteIndustry.html', 'industryTable');">删除</button>
</div>
<!-- 工具栏结束 -->
<script type="text/javascript">
$(function() {
	// 初始化数据表格
	$('#industryTable').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/industry/industryTable.html',
		idField : 'id',
		//分页相关
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		pageList : [ 5, 10, 15, 20 ],
		//查找相关
		search : true,
		//显示按钮
		//striped : true,
		showColumns : true,
		showRefresh : true,
		showToggle : true,
		showPaginationSwitch : true,
		//排序相关
		sortOrder : 'desc',
		sortName : 'createDate',
		//选择相关
		clickToSelect : true,
		maintainSelected : true,
		//工具栏
		toolbar : '#toolbar',
		columns : [{
			field : 'checkbox',
			checkbox : true
		}, {
			field : 'id',
			visible : false
		}, {
			field : 'name',
			title : '行业名称',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'createDate',
			title : '创建时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'updateDate',
			title : '更新时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}]
	});
});
</script>
<!-- 网站主体 End -->
<%@ include file="../common/footer.jsp"%>
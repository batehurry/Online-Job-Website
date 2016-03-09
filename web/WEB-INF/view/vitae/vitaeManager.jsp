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
			<h3>我的简历</h3>
			<div>
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#vitae" aria-controls="vitae" role="tab" data-toggle="tab">简历</a></li>
					<li role="presentation"><a href="#educationExp" aria-controls="educationExp" role="tab" data-toggle="tab">教育经历</a></li>
					<li role="presentation"><a href="#workExp" aria-controls="workExp" role="tab" data-toggle="tab">工作经验</a></li>
				</ul>
				<div class="tab-content">
					<!-- 我的简历 -->
					<div role="tabpanel" class="tab-pane fade in active" id="vitae">
						<table id="vitaeTable"></table>
					</div>
					<!-- 我的教育经历 -->
					<div role="tabpanel" class="tab-pane fade" id="educationExp">
						<table id="educationExpTable"></table>
					</div>
					<!-- 我的工作经验 -->
					<div role="tabpanel" class="tab-pane fade" id="workExp">
						<table id="workExpTable"></table>
					</div>
				</div>
			</div><!-- Tab end -->
		</div>
	</div>
</div>
<!-- vitaeTableToolbar工具栏 -->
<div id="vitaeTableToolbar">
	<button type="button" class="btn btn-success" onclick="openDetail('${basePath }/vitae/vitaeForm.html', '${basePath }/vitae/saveVitae.html', '${basePath }/vitae/editVitae.html', 'vitaeTable', 'viteaForm')">创建简历</button>
	<button type="button" class="btn btn-info" onclick="edit('${basePath }/vitae/vitaeForm.html', '${basePath }/vitae/saveVitae.html', '${basePath }/vitae/editVitae.html', 'vitaeTable', 'viteaForm')">修改</button>
	<button type="button" class="btn btn-danger" onclick="delte('${basePath }/vitae/deleteVitae.html', 'vitaeTable')">删除</button>
</div>
<!-- 工具栏结束 -->
<!-- educationExpToolbar工具栏 -->
<div id="educationExpToolbar">
	<button type="button" class="btn btn-success" onclick="openDetail('${basePath }/vitae/educationExpForm.html', '${basePath }/vitae/saveEducationExp.html', '${basePath }/vitae/editEducationExp.html', 'educationExpTable', 'educationExpForm')">创建教育经历</button>
	<button type="button" class="btn btn-info" onclick="edit('${basePath }/vitae/educationExpForm.html', '${basePath }/vitae/saveEducationExp.html', '${basePath }/vitae/editEducationExp.html', 'educationExpTable', 'educationExpForm')">修改</button>
	<button type="button" class="btn btn-danger" onclick="delte('${basePath }/vitae/deleteEducationExp.html', 'educationExpTable')">删除</button>
</div>
<!-- 工具栏结束 -->
<!-- workExpToolbar工具栏 -->
<div id="workExpToolbar">
	<button type="button" class="btn btn-success" onclick="openDetail('${basePath }/vitae/workExpForm.html', '${basePath }/vitae/saveWorkExp.html', '${basePath }/vitae/editWorkExp.html', 'workExpTable', 'workExpForm')">创建工作经验</button>
	<button type="button" class="btn btn-info" onclick="edit('${basePath }/vitae/workExpForm.html', '${basePath }/vitae/saveWorkExp.html', '${basePath }/vitae/editWorkExp.html', 'workExpTable', 'workExpForm')">修改</button>
	<button type="button" class="btn btn-danger" onclick="delte('${basePath}/vitae/deleteWorkExp.html', 'workExpTable')">删除</button>
</div>
<!-- 工具栏结束 -->
<script type="text/javascript">
$(function() {
	// 初始化简历的数据表格
	$('#vitaeTable').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/vitae/vitaeTable.html',
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
		toolbar : '#vitaeTableToolbar',
		columns : [{
			field : 'checkbox',
			checkbox : true
		}, {
			field : 'id',
			visible : false
		}, {
			field : 'title',
			title : '简历标题',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'position.name',
			title : '相关职位',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'salary.name',
			title : '期望薪资',
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
			title : '修改时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}]
	});
	
	// 初始化教育经历的数据表格
	$('#educationExpTable').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/vitae/educationExpTable.html',
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
		toolbar : '#educationExpToolbar',
		columns : [{
			field : 'checkbox',
			checkbox : true
		}, {
			field : 'id',
			visible : false
		}, {
			field : 'schoolName',
			title : '学校名称',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'startDate',
			title : '开始时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'endDate',
			title : '结束时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'createDate',
			title : '创建时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'updateDate',
			title : '修改时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}]
	});
	
	// 初始化工作经验的数据表格
	$('#workExpTable').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/vitae/workExpTable.html',
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
		toolbar : '#workExpToolbar',
		columns : [{
			field : 'checkbox',
			checkbox : true
		}, {
			field : 'id',
			visible : false
		}, {
			field : 'etpName',
			title : '公司/企业名称',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'startDate',
			title : '开始时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'endDate',
			title : '结束时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'createDate',
			title : '创建时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'updateDate',
			title : '修改时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}]
	});
});
</script>
<!-- 网站主体 End -->
<%@ include file="../common/footer.jsp"%>
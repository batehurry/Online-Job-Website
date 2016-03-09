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
			<h3>招聘中的职位</h3>
			<table id="allPublishPositionTable"></table>
		</div>
	</div>
</div>
<!-- 工具栏（增加、删除、修改） -->
<div id="toolbar">
	<button type="button" class="btn btn-success" onclick="sendVitae('allPublishPositionTable');">投递简历</button>
</div>
<!-- 工具栏结束 -->
<script type="text/javascript">
$(function() {
	// 初始化数据表格
	$('#allPublishPositionTable').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/publishPosition/allPublishPositionTable.html',
		idField : 'id',
		//分页相关
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		pageList : [ 5, 10, 15, 20 ],
		//查找相关
		//search : true,
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
			field : 'position.industry.name',
			title : '行业名称',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'position.name',
			title : '职位名称',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'peopleNumber',
			title : '招聘人数',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'salary.name',
			title : '招聘薪资',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'workAdd',
			title : '工作地点',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'createDate',
			title : '发布时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			title : '查看详情',
			align : 'center',
			valign : 'middle',
			formatter : function(value, row, index) {
				if(index != top.rowInfo.length) {
					top.rowInfo.length = 0;//清空数组
				}
				var url = "\'publishPosition/publishPositionDetail.html\'";
				top.rowInfo.push(row);
				return '<button class="btn btn-info btn-sm" onclick="iTsai.stopBubble(this);top.index=' + index + ';openLookDetail(' + url + ');">查看详情</button>';
			}
		}]
	});
});
</script>
<!-- 网站主体 End -->
<%@ include file="../common/footer.jsp"%>
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
			<h3>接收到的简历信息</h3>
			<table id="vitaeRecordTable2"></table>
		</div>
	</div>
</div>
<!-- 工具栏（增加、删除、修改） -->
<div id="toolbar">
	<button type="button" class="btn btn-success" onclick="pass('vitaeRecordTable2');">邀请面试</button>
	<button type="button" class="btn btn-info" onclick="refuse('vitaeRecordTable2');">暂不合适</button>
</div>
<!-- 工具栏结束 -->
<script type="text/javascript">
$(function() {
	// 初始化数据表格
	$('#vitaeRecordTable2').bootstrapTable({
		sidePagination : 'server',
		method : 'post',
		cache : false,
		url : '${basePath}/vitaeRecord/vitaeRecordTable2.html',
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
			field : 'publishPosition.position.name',
			title : '应聘职位',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'vitae.name',
			title : '应聘者姓名',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'vitae.sex.name',
			title : '应聘者性别',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'vitae.tel',
			title : '应聘者电话',
			align : 'center',
			valign : 'middle'
		}, {
			field : 'createDate',
			title : '简历发送时间',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'recordResult.name',
			title : '处理结果',
			align : 'center',
			valign : 'middle',
			sortable : true
		}, {
			field : 'interviewDate',
			title : '邀请面试时间',
			align : 'center',
			valign : 'middle'
		}, {
			title : '查看简历详情',
			align : 'center',
			valign : 'middle',
			formatter : function(value, row, index) {
				if(index != top.rowInfo.length) {
					top.rowInfo.length = 0;//清空数组
				}
				var url = "\'vitae/vitaeDetail.html\'";
				top.rowInfo.push(row);
				return '<button class="btn btn-info btn-sm" onclick="iTsai.stopBubble(this);top.index=' + index + ';openLookDetail(' + url + ');">查看简历</button>';
			}
		}]
	});
});
</script>
<!-- 网站主体 End -->
<%@ include file="../common/footer.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<script charset="utf-8" type="text/javascript">
var qzw = qzw || {};
qzw.path = '${path}';
qzw.basePath = '${basePath}';
qzw.version = '${version}';
top = top || {};
top.path = '${path}';
top.basePath = '${basePath}';
top.version = '${version}';
top.rowInfo = new Array();
</script>
<%-- 引入网站图标 --%>
<link type="image/x-icon" href="${basePath}/weblib/img/favicon.ico?version=${version}" rel="icon">
<%-- 引入main.css文件 --%>
<link href="${basePath}/weblib/main.css?version=${version}" rel="stylesheet" type="text/css">
<%-- 使版本9以下的IE浏览器支持：HTML5、响应式布局、canvas标签 --%>
<!--[if lt IE 9]>
<script src="${basePath}/weblib/lib/ieonly/html5shiv.js?version=${version}" charset="utf-8" type="text/javascript"></script>
<script src="${basePath}/weblib/lib/ieonly/respond.js?version=${version}" charset="utf-8" type="text/javascript"></script>
<script src="${basePath}/weblib/lib/ieonly/excanvas.js?version=${version}" charset="utf-8" type="text/javascript"></script>
<![endif]-->
<%-- 引入main.js文件 --%>
<script src="${basePath}/weblib/main.js?version=${version}" charset="utf-8" type="text/javascript"></script>
<script charset="utf-8" type="text/javascript">
$(function() {
	// 设置数据表格的语言
   	$.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);
	// 定义单复选框的样式
	$('.check').iCheck({
		checkboxClass : 'icheckbox_flat-blue',
		radioClass : 'iradio_flat-blue'
	});
	/* $('.selectator').selectator({
    	labels: {
            search: '在这里搜索...'
        }
    }); */
	//彩蛋
	log('***欢迎使用求职网！');
	log('***本网站项目是魏胜泽和郭妤的毕业设计，如有不足之处请指出。');
	log('***联系邮箱：w0612w@qq.com');
});
</script>
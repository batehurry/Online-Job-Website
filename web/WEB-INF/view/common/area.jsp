<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<link href="${pageContext.request.contextPath}/weblib/lib/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/weblib/js/jquery-1.11.3.min.js" charset="utf-8" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/weblib/lib/zTree_v3/js/jquery.ztree.all-3.5.min.js" charset="utf-8" type="text/javascript"></script>
<div>
	<ul id="areaTree" class="ztree"></ul>
</div>
<script type="text/javascript">
	var setting = {
		async : {
			enable : true,
			url : "${pageContext.request.contextPath}/areaTree.html",
			autoParam : ["id=pid"],
			type : "post",
			dataType : "json"
		},
		callback : {
	        onAsyncSuccess : function(event, treeId, msg) {
	        	var firstAsyncSuccessFlag = 0;
	    		if (firstAsyncSuccessFlag == 0) {
	    			try {
	    		       // 默认展开第一个结点
	    		       var ztreeObj = $.fn.zTree.getZTreeObj(treeId);
	    		       ztreeObj.expandNode(ztreeObj.getNodes()[0], true);
	    		       firstAsyncSuccessFlag = 1;
	    			 } catch (err) {info(JSON.stringify(err));}
	    	     }
	        }
	    }
	};
	$(function() {
		top.treeObj = $.fn.zTree.init($("#areaTree"), setting);
	});
</script>
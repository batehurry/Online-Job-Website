<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px;">
	<div class="col-xs-12 col-md-12 col-sm-12">
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">新闻标题</label>
			<div class="col-xs-9 col-md-9 col-sm-8">${news.title }</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">新闻内容</label>
			<div class="col-xs-12 col-md-12 col-sm-12">${news.content }</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">发布时间</label>
			<div class="col-xs-9 col-md-9 col-sm-8"><fmt:formatDate value="${news.createDate }" pattern="yyyy-MM-dd HH:mm:ss" /></div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-md-3 col-sm-2">更新时间</label>
			<div class="col-xs-9 col-md-9 col-sm-8"><fmt:formatDate value="${news.updateDate }" pattern="yyyy-MM-dd HH:mm:ss" /></div>
		</div>
	</div>	
</div>
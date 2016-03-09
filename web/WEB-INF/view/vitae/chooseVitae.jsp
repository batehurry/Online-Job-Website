<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="width: 500px; margin-top: 10px;">
	<div class="row">
		<div class="col-xs-12 col-md-12 col-sm-12">
			<form id="chooseVitaeForm" class="form-horizontal">
				<div class="col-xs-12 col-md-12 col-sm-12">
					<select class="form-control selectator" name="vitaeId">
						<c:forEach items="${vitaeList }" var="t">
							<option value="${t.id }">${t.title }(创建时间：<fmt:formatDate value="${t.createDate }" pattern="yyyy-MM-dd"/>)</option>
						</c:forEach>
					</select>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="./common/header.jsp"%>
<div class="container" id="container">
	<!-- 网站主体 Start -->
	<div class="row" id="page">
		<div class="col-xs-6 col-sm-5 col-md-4">
			<div class="page-header">
				<h1>
					欢迎来到求职网<br /> <small>来求职网，找好工作！</small>
				</h1>
			</div>
			<h3>求职新闻</h3>
			<c:forEach items="${newsList }" var="t" varStatus="status">
				<p style="font-size: 16px;"><a href="javascript:void(0);" onclick="newsDetail('${t.id}');">${status.count }. ${t.title }</a></p>
			</c:forEach>
		</div>
		<div class="col-xs-12 col-sm-10 col-md-8">
			<div class="carousel slide" id="carousel-bp">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-bp"></li>
					<li data-slide-to="1" data-target="#carousel-bp"></li>
					<li data-slide-to="2" data-target="#carousel-bp"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="${basePath }/weblib/img/index1.png" />
						<div class="carousel-caption">
							<h4>快来寻找合适你的工作吧</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="${basePath }/weblib/img/index2.png" />
						<div class="carousel-caption">
							<h4>来求职网,向第一冲刺</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="${basePath }/weblib/img/index3.png" />
						<div class="carousel-caption">
							<h4>好工作就在求职网</h4>
						</div>
					</div>
				</div>
				<a data-slide="prev" href="#carousel-bp"
					class="left carousel-control">‹</a> <a data-slide="next"
					href="#carousel-bp" class="right carousel-control">›</a>
			</div>
			<c:forEach items="${publishPositionList }" var="t">
				<div>
					<div>
						<h4>最新职位：${t.position.name }</h4><!-- <button type="button" class="btn btn-success" onclick="">投递简历</button> -->
					</div>
					<p>工作地点：${t.workAdd }，薪资：${t.salary.name }， 发布时间：<fmt:formatDate value="${t.createDate }" pattern="yyyy-MM-dd"/></p>
				</div>
			</c:forEach>
			
		</div>
	</div>
</div>
<!-- 网站主体 End -->
<%@ include file="./common/footer.jsp"%>
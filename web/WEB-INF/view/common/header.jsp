<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.qzw.common.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="../inc/meta.jsp"%>
<%@ include file="../inc/bootstrap.jsp"%>
</head>
<body id="mainBody">
	<nav class="navbar navbar-default navbar-fixed-top">
		<!-- 顶部导航 Start -->
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">网站导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${basePath }/index.html">求职网</a>
			</div>
			<div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<%-- <li><a href="${basePath }/index.html">首页</a></li> --%>
					<shiro:hasRole name="<%=Constants.ADMIN%>">
						<li><a href="${basePath }/industry/industryManager.html">管理行业</a></li>
						<li><a href="${basePath }/position/positionManager.html">管理职位</a></li>
						<li><a href="${basePath }/news/newsManager.html">管理新闻</a></li>
					</shiro:hasRole>
					<shiro:hasRole name="<%=Constants.JOBHUNTER%>">
						<li><a href="${basePath }/vitae/vitae.html">我的简历</a></li>
						<li><a href="${basePath }/publishPosition/allPublishPosition.html">招聘中职位</a></li>
						<li><a href="${basePath }/vitaeRecord/vitaeRecordManager1.html">投递记录</a></li>
					</shiro:hasRole>
					<shiro:hasRole name="<%=Constants.ENTERPRISE%>">
						<li><a href="${basePath }/publishPosition/publishPositionManager.html">发布职位</a></li>
						<li><a href="${basePath }/vitaeRecord/vitaeRecordManager2.html">应聘简历</a></li>
					</shiro:hasRole>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<shiro:notAuthenticated>
						<li><a href="${basePath}/login.html">登陆</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">注册<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${basePath }/user/registerPage1.html">求职者</a></li>
								<li><a href="${basePath }/user/registerPage2.html">用人单位</a></li>
							</ul>
						</li>
					</shiro:notAuthenticated>
					<shiro:user>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">欢迎您：<shiro:principal property="userName" /><span class="caret"></span></a>
							<ul class="dropdown-menu">
								<shiro:hasRole name="<%=Constants.JOBHUNTER%>">
									<li><a href="javascript:void(0);" onclick="userInfo1();">个人资料</a></li>
								</shiro:hasRole>
								<shiro:hasRole name="<%=Constants.ENTERPRISE%>">
									<li><a href="javascript:void(0);" onclick="userInfo2();">企业信息</a></li>
								</shiro:hasRole>
								<li><a href="javascript:void(0);" onclick="modPwd();">修改密码</a></li>
								<li><a href="${basePath }/logout.html">退出登录</a></li>
							</ul></li>
					</shiro:user>
					<li><a href="javascript:void(0)" onclick="aboutMe();">关于求职网</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 顶部导航 End -->
<%-- 标签名称	标签条件（均是显示标签内容）
<shiro:authenticated>	登录之后
<shiro:notAuthenticated>	不在登录状态时
<shiro:guest>	用户在没有RememberMe时
<shiro:user>	用户在RememberMe时
<shiro:hasAnyRoles name="abc,123" >	在有abc或者123角色时
<shiro:hasRole name="abc">	拥有角色abc
<shiro:lacksRole name="abc">	没有角色abc
<shiro:hasPermission name="abc">	拥有权限资源abc
<shiro:lacksPermission name="abc">	没有abc权限资源
<shiro:principal>	显示用户身份名称
<shiro:principal property="username"/>     显示用户身份中的属性值 --%>
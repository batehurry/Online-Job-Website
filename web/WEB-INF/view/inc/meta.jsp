<%@ page language="java" pageEncoding="UTF-8"%>
<%
	//项目路径
	String path = request.getContextPath();
	//全路径
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	//项目版本号
	String version = "20151102";
	//设置域变量
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
	pageContext.setAttribute("version", version);
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath }/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>---求职网---来求职网，找好工作</title>
<%-- 关键词,5个左右,单个8汉字以内 --%>
<meta name="keywords" content="求职 招聘 工作 高薪">
<%-- 网站描述，字数尽量控制在80个汉字，160个字符以内！ --%>
<meta name="description" content="来求职网，找好工作">
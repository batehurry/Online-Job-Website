<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/meta.jsp"%>
<%@ include file="../inc/bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="page-header">
					<h1 class="animated slideInDown">
						对不起&nbsp;&nbsp;<small>${message }</small>
					</h1>
					<div style="color: #DDD" class="animated slideInDown">HTTP
						500 : Internal Server Error</div>
				</div>
				<div style="height: 50px; line-height: 50px"
					class="animated slideInUp">
					<a href="javascript:void(0)" onclick="history.back(-1);">返回上一级页面</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
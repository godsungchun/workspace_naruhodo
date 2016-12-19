<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="resourcesPath" value="${contextPath}/resources"/>
<c:set var="now" value="<%=new java.util.Date().getTime()%>" />

<security:authentication var="principal" property="principal"/>
<security:authorize var="isAuthenticated" access="isAuthenticated()"/>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	<title>Simple Sidebar - Start Bootstrap Template</title>
	<!-- Bootstrap Core CSS -->
	<!-- jQuery -->
	<script src="${contextPath}/resources/libs/jquery/jquery-3.1.1.min.js?rd=${now}"></script>
	<script src="${contextPath}/resources/libs/jquery/form/jquery.form.min.js?rd=${now}"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="${contextPath}/resources/libs/bootstrap/js/bootstrap.min.js?rd=${now}"></script>
	
	<!-- Bootstrap Core CSS -->
	<link href="${contextPath}/resources/libs/bootstrap/css/bootstrap.min.css?rd=${now}" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="${contextPath}/resources/libs/bootstrap/css/simple-sidebar.css?rd=${now}" rel="stylesheet">
	
	<link href="${contextPath}/resources/libs/sb-admin2/css/sb-admin-2.css?rd=${now}" rel="stylesheet">
	<link href="${contextPath}/resources/libs/font-awesome/css/font-awesome.min.css?rd=${now}" rel="stylesheet" type="text/css">
	<script src="${contextPath}/resources/js/views/login.js?rd=${now}"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" id="frmLogin" name="frmLogin" method="POST" action="/auth/login">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" id="txtSignInId" name="signInId" type="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" id="txtPwd" name="pwd" type="password" value="">
								</div>
								<div class="checkbox">
									<label>
										<input name="remember" type="checkbox" value="Remember Me">Remember Me
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
						<a id="btnLogin" href="#" class="btn btn-lg btn-success btn-block">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	loginRestApi.contextPath = '${contextPath}';
	login.setEvent();
	
	$(document).ajaxSend(function(e, xhr, options) {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		xhr.setRequestHeader(header, token);
	});
</script>
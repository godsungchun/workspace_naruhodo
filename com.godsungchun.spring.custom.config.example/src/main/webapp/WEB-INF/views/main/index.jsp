<%--
  Created by IntelliJ IDEA.
  User: Dream
  Date: 2016-12-14
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
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

<html>
<head>
	<title>Title</title>
	
	<%@ include file="../commons/includes.jsp" %>
	
	<script src="${contextPath}/resources/js/views/main/index.js?rd=${now}"></script>
</head>
<body>
	SignIn Complete.
	<form id="frmLogout" name="frmLogout" method="post" action="/auth/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	<button id="btnLogout">로그아웃</button>
</body>
</html>

<script type="text/javascript">
	logoutRestApi.contextPath = '${contextPath}';
	mainIndex.isRest = true;
	mainIndex.setEvent();
</script>
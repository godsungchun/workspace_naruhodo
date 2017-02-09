<%--
  Created by IntelliJ IDEA.
  User: Dream
  Date: 2016-11-21
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form role="form">
	<div class="form-group">
		<label>Name</label>
		<input typp="text" id="txtName" title="title" class="form-control">
	</div>
	<div class="form-group">
		<label>LoginId</label>
		<input typp="text" id="txtLoginId" title="loginId" class="form-control" readonly="readonly">
	</div>
	<div class="form-group">
		<label>Password</label>
		<input type="password" id="txtPassword" title="password" class="form-control">
	</div>
	<div class="form-group">
		<label>Password Confirm</label>
		<input type="password" id="txtPasswordConfirm" title="passwordConfirm" class="form-control">
	</div>
	<div class="form-group">
		<label>Email</label>
		<input type="email" id="txtEmail" title="email" class="form-control">
	</div>
	
	<input type="hidden" id="hdnCreatedDate" value=""/>
	<input type="hidden" id="hdnCreatedByName" value=""/>
	<input type="hidden" id="hdnLastModifiedDate" value=""/>
	<input type="hidden" id="hdnLastModifiedByName" value=""/>
	<input type="hidden" id="hdnAccountId" value=""/>
</form>
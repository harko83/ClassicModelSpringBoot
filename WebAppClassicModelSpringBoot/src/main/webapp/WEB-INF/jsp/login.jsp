<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css" />
    <title>Classic Models</title>
</head>

<body>
    <%@ include file="menu.jsp"%>
	<div>
	    <div class="panel-body">
	        <form action="doLogin" method="post">
	            <fieldset>
	                <legend>Please sign in</legend>
	
	                <c:if test="${not empty error}">
	                    <div class="alert alert-danger">
	                        <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
	                        <br/>
	                    </div>
	                </c:if>
	                <div class="form-group">
	                    <input class="form:input-large" placeholder="User Name"
	                           name='login' type="text">
	                </div>
	                <div class="form-group">
	                    <input class=" form:input-large" placeholder="Password"
	                           name='pass' type="password" value="">
	                </div>
	                <input class="btn" type="submit"
	                       value="Login">
	            </fieldset>
	        </form>
	    </div>
	</div>
</body>
</html>
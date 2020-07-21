<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css" />
    <title>Classic Models</title>
</head>

<body>
TEST HOME
<br>
				<sec:authorize access="isAuthenticated()">
	            <sec:authentication property="principal.username" var="username" />
				    Welcome Back, ${username}
				    <br>
				    <form method="get" action="/logout">
				    	<button type="submit">Disconnect</button>
					</form>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('SUPEREMPLOYEE')">
				  This content is only shown to SUPEREMPLOYEE.
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('EMPLOYEE')">
				  This content is only shown to EMPLOYEE.
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('ADMIN')">
				  This content is only shown to administrators.
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('CLIENT')">
				  This content is only shown to client.
				</sec:authorize>
				

</body>
</html>
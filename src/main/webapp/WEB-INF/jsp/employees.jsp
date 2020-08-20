<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<t:pageTemplate>
   <jsp:attribute name="additionalCss">
   </jsp:attribute>
   <jsp:attribute name="additionalJs">
   </jsp:attribute>
   <jsp:body>
   
   		<sec:authorize access="hasAuthority('ADMIN')">
   			<a href="/employees/global"><button>All offices</button></a>	
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="0">Valbonne</button>
			</form>
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="1">San Francisco</button>
			</form>		
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="2">Boston</button>
			</form>
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="3">NYC</button>
			</form>	
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="4">Paris</button>
			</form>
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="5">Tokyo</button>
			</form>		
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="6">Sydney</button>
			</form>
			<form action="/employees/global/byOffice" method="post">
				<button type="submit" name="button" value="7">London</button>
			</form>
			<a href="/employees/global/addEmployee"><button>New Employee</button></a>	
			<br>
		</sec:authorize>
		<section>
			<table>
		    <!-- List of all employees -->
		    <tr>
		        <th>Employee number</th>
		        <th>Lastname</th>
		        <th>Firstname</th>
		        <th>PhoneExt</th>
		        <th>Email</th>
		        <th>Office</th>
		        <th>Report to</th>
		        <th>Job title</th>
		    </tr>
			<c:forEach items="${employees}" var="employees">
		    <tr>
		    	<td><c:out value="${employees.getEmployeeNumber()}" /></td>
		        <td><c:out value="${employees.getLastName()}" /></td>
		        <td><c:out value="${employees.getFirstName()}" /></td>
		        <td><c:out value="${employees.getExtension()}" /></td>
		        <td><c:out value="${employees.getEmail()}" /></td>
		        <td><c:out value="${employees.getOfficeCode().getOfficeCode()}" /></td>
		        <td><c:out value="${employees.getReportsTo().getEmployeeNumber()}" /></td>
		        <td><c:out value="${employees.getJobTitle()}" /></td>
		    </tr>
	   		</c:forEach>
	   		</table>
	    </section>
   </jsp:body>
</t:pageTemplate>
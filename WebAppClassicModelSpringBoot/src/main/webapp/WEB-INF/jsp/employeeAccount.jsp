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
   			<div class="box">
   			
			<section class="account">
				<div>
				<img src="${pageContext.request.contextPath}/img/photos/Employees/${employee.getFirstName()}.jpg" width="25%"
								alt="${employee.getEmployeeNumber()}">
				</div>
				<div>
					<table>
						<tr>
							<th colspan="2">Informations</th>
						</tr>
					    <tr>
					    	<td>Employee number :</td>
					    	<td><c:out value="${employee.getEmployeeNumber()}"/></td>
					    </tr>
					    <tr>
					    	<td>Customer name :</td>
					    	<td><c:out value="${client.getCustomerName()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Contact lastname :</td>
					    	<td><c:out value="${client.getContactLastName()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Contact firstname :</td>
					    	<td><c:out value="${client.getContactFirstName()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Phone :</td>
					    	<td><c:out value="${client.getPhone()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Address :</td>
					    	<td><c:out value="${client.getAddressLine1()}"></c:out>
					    	<c:out value="${client.getAddressLine2()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>City :</td>
					    	<td><c:out value="${client.getCity()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>State :</td>
					    	<td><c:out value="${client.getState()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Postal code :</td>
					    	<td><c:out value="${client.getPostalCode()}"></c:out></td>
					    </tr>
					    <tr>
					    	<td>Country :</td>
					    	<td><c:out value="${client.getCountry()}"></c:out></td>
					    </tr>
			   		</table>
	   		</div>
	    </section>
	    </div>
   </jsp:body>
</t:pageTemplate>
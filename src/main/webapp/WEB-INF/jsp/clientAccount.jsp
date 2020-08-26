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
   			<div class="AccountClientContainer">

				<img src="${pageContext.request.contextPath}/img/photos/Customers/${client.getName()}.jpg"
								alt="${client.getCustomerNumber()}">
					<table>
						<tr>
							<th colspan="2">Informations</th>
						</tr>
					    <tr>
					    	<td>Customer number :</td>
					    	<td><c:out value="${client.getCustomerNumber()}"/></td>
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
					    <tr>
					    	<td>Manage by :</td>
					    	<td><c:out value="${client.getEmployeesEntity().getFirstName()} ${client.getEmployeesEntity().getLastName()}"></c:out></td>
					    </tr>
			   		</table>
	   			<table>
	   				<tr>
	   					<th colspan="2">Orders</th>
	   				</tr>
	   				<tr>
				        <th>Order number</th>
				        <th>Order date</th>
				        <th>Required date</th>
				        <th>Shipped date</th>
				        <th>Status</th>
				        <th>Comments</th>
				    </tr>
				    <c:forEach items="${orders}" var="orders">
	   				<tr>
	   					<td><button value="/client/orders" name="orderNumber"><c:out value="${orders.getOrderNumber()}"></c:out></button></td>
	   					<!-- td><form action="/client/orders" method="get">
	           			<c:out value="${orders.getOrderNumber()}"></c:out>
	           			</form></td-->
					    <td><c:out value="${orders.getOrderDate()}"></c:out></td>
					    <td><c:out value="${orders.getRequiredDate()}"></c:out></td>
					    <td><c:out value="${orders.getShippedDate()}"></c:out></td>
					    <td><c:out value="${orders.getStatus()}"></c:out></td>
					    <td><c:out value="${orders.getComments()}"></c:out></td>
	   				</tr>
	   				</c:forEach>
	   			</table>
	    </div>
   </jsp:body>
</t:pageTemplate>
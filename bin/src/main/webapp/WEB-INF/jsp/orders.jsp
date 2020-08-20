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
	   			<table>
	   				<tr>
	   					<th colspan="2">Order number ${order.getOrderNUmber()}</th>
	   				</tr>
	   				<tr>
				        <th>Order number</th>
				        <th>Order date</th>
				        <th>Required date</th>
				        <th>Shipped date</th>
				        <th>Status</th>
				        <th>Comments</th>
				    </tr>
				    <!--
				    <c:forEach items="${orders}" var="orders">
	   				<tr>
					    <td><c:out value="${orders.getOrderNumber()}"></c:out></td>
					    <td><c:out value="${orders.getOrderDate()}"></c:out></td>
					    <td><c:out value="${orders.getRequiredDate()}"></c:out></td>
					    <td><c:out value="${orders.getShippedDate()}"></c:out></td>
					    <td><c:out value="${orders.getStatus()}"></c:out></td>
					    <td><c:out value="${orders.getComments()}"></c:out></td>
	   				</tr>
	   				</c:forEach>
	   				-->
	   			</table>
	   		</div>
	    </section>
	    </div>
   </jsp:body>
</t:pageTemplate>
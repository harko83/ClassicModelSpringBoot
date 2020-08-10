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
			<section>
			<img src="${pageContext.request.contextPath}/img/photos/Customers/${client.getCustomerNumber()}.jpg" width="100%"
							alt="${client.getCustomerNumber()}">
			<table>
		    <tr>
		    	<td>Customer number :</td>
		    	<td><c:out value="${client.getCustomerNumber()}"/></td>
		    </tr>

	   		</table>
	    </section>
   </jsp:body>
</t:pageTemplate>
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
		<section id="IndexContainer">

	<section id="ProductContainer">

	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart}">
			<c:set var="total" value="${total + item.product.getBuyPrice() * item.quantity}"></c:set>
			<tr>
				<td align="center">
					<a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.getProductCode()}"
					onclick="return confirm('Are you sure?')">Remove</a>
				</td>
				<td>${item.product.getProductCode()}</td>
				<td>${item.product.getProductName()}</td>
				<td>
					<img src="${pageContext.request.contextPath}/img/photos/Products/${products.getProductCode()}.jpg" alt="${item.product.getProductName()}" width="25%">
				</td>
				<td>${item.product.getBuyPrice()}</td>
				<td>${item.quantity }</td>
				<td>${item.product.getBuyPrice() * item.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
	<br/>
	<a href="/products">Continue Shopping</a>

		
	</section>
	</section>
   </jsp:body>
</t:pageTemplate>
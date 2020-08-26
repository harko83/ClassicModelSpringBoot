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
	<div id="cartContinue">
	<form method="post" action="/client/cart/update" class="cartContinue">
		<table cellpadding="2" cellspacing="2" border="1">
			<tr>
				<th>Option</th>
				<th>Id</th>
				<th>Name</th>
				<th>Photo</th>
				<th>Price</th>
				<th>
					Quantity
					<input type="submit" value="Update">
				</th>
				<th>Sub Total</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.cart}">
				<c:set var="subTotal" value="${item.product.getMSRP() * item.quantity}"></c:set>
				<tr>
					<td align="center">
						<a href="${pageContext.request.contextPath }/client/cart/remove/${item.product.getProductCode()}">X</a>
					</td>
					<td>${item.product.getProductCode()}</td>
					<td>${item.product.getProductName()}</td>
					<td>
						<img src="${pageContext.request.contextPath}/img/photos/Products/${item.product.getProductCode()}.jpg" alt="${item.product.getProductName()}" width="125px">
					</td>
					<td>${item.product.getMSRP()}</td>
					<td>
						<input type="number" value="${item.quantity}" name="quantity" min="1" style="width: 50px;"> 
					</td>
					<td>${subTotal}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right">Total</td>
				<td>${totalCart}</td>
			</tr>
		</table>
	</form>
	<br/>
	<div class="cartContinue">
	<a href="/products">Continue Shopping</a>
	<a href="/client/cart/checkout">Check Out</a>
	</div>
	</div>
   </jsp:body>
</t:pageTemplate>
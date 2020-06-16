<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="css/styles.css"/>" />
<title>Classic Models</title>
</head>

<body id="BodyContainer">

	<%@ include file="menu.jsp"%>

	<section id="ProductContainer">
		<c:forEach items="${products}" var="product">
				<ul class="sale-item">
					<li class="cards__item">
						<div class="card">
							<img src="img/photos/Products/${product.getProductCode()}.jpg" width="100%"
						alt="${product.getProductName()}">
							<div class="card__content">
								<h1 class="card__title"><c:out value=" ${product.getProductName()}" /></h1>
								Référence de l'article :<c:out value=" ${product.getProductCode()}" />
								<p class="card__text"><c:out value=" ${product.getProductDescription()}" /></p>
								<p>Gamme : <c:out value=" ${product.getProductLine()}" /></p>
								<p>Echelle de la maquette au<c:out value=" ${product.getProductScale()}" /></p>
								
							<p>Prix :<c:out value=" ${product.getBuyPrice()}"/> &euro;
							
								<c:if test="${ !empty sessionScope.login }">
									<a href="${pageContext.request.contextPath }/cart?&action=buy&id=${product.getProductCode() }" class="button card__btn">Buy now</a>
									<br/>
								</c:if>
								
							</div>
						</div>
					</li>
				</ul>

		</c:forEach>
		
	</section>
	
</body>

</html>
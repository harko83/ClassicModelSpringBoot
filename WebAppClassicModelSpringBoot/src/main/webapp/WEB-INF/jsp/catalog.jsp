<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/css/styles.css"/>" />
<title>Classic Models</title>
</head>

<body id="BodyContainer">

	<%@ include file="menu.jsp"%>
	
	<section id="ProductContainer">
		<c:forEach items="${products}" var="products">
				<ul class="sale-item">
					<li class="cards__item">
						<div class="card">
							<img src="${pageContext.request.contextPath}/img/photos/Products/${products.getProductCode()}.jpg" width="100%"
						alt="${products.getProductName()}">
							<div class="card__content">
								<h1 class="card__title"><c:out value=" ${products.getProductName()}" /></h1>
								<br/>
								Référence de l'article :<c:out value=" ${products.getProductCode()}" />
								<br/>
								<p class="card__text"><c:out value=" ${products.getProductDescription()}" /></p>
								<br/>
								<p>Gamme : <c:out value=" ${products.getProductlinesEntity().getProductLine()}" /></p>
								<p>Echelle de la maquette au<c:out value=" ${products.getProductScale()}" /></p>
								<br/>
								<sec:authorize access="hasAuthority('CLIENT')">
				 				<p>Prix :<c:out value=" ${products.getBuyPrice()}"/> &euro;
				 				<br/>
				 				<a href="${pageContext.request.contextPath }/client/cart/buy/${products.getProductCode() }" class="button card__btn">Buy now</a>
				 				<br/>
								</sec:authorize>
								
							</div>
						</div>
					</li>
				</ul>

		</c:forEach>
		
	</section>
	
</body>

</html>
<%@page contentType="text/html" trimDirectiveWhitespaces="true"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<t:pageTemplate>
	<jsp:attribute name="additionalCss">
   </jsp:attribute>
	<jsp:attribute name="additionalJs">
   </jsp:attribute>
	<jsp:body>
        <aside class="element">
            <div>
	            <sec:authorize access="isAuthenticated()">
	            <sec:authentication property="principal.username"
						var="username" />
				    Welcome Back, ${username}
				    <br>
				
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('SUPEREMPLOYEE')">
				<form action="/employees/manager" method="get">
					<button type="submit" name="button" value="${username}">My office</button>
				</form>
				<form action="/employees/account" method="get">
					<button type="submit" name="button" value="${username}">My Account</button>
				</form>
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('EMPLOYEE')">
				<!--This content is only shown to EMPLOYEE.-->
				<form action="/employees/account" method="get">
					<button type="submit" name="button" value="${username}">My Account</button>
				</form>
				<br>
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('ADMIN')">
					<li><a href="/employees/global"> Employees</a></li>
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('CLIENT')">
				  <!--This content is only shown to client.-->
				  <br>
				</sec:authorize>
            </div>
        </aside>
        <div class="IndexContainer">
        <%@ include file="categories.jsp"%>
        <article class="element">
            <div>
                <h2>Welcome to CLassic Models</h2>
                <p>ClassicModels provides a store full of scale models of cars, trucks, buses, tractors but also tanks, ships, boats, aircraft and helicopters to clients from all over the world.</p>
                <br>
                <p>If you need any advice or help on ordering, please do not hesitate to contact us by email or phone. Our experts will answer all your questions and help you navigate through our large range of model miniatures in 1:18 or 1:43 and any other scales. We guarantee total customer satisfaction all the way from ordering to delivery!</p>
            	<br>
            	<p>We will be pleased to accept you order in the near future and will do our very best to make it a long-term business with you.</p>
            	<br>
            	<p>Large numbers of people have already purchased miniatures with ClassicModels as a gift or for an addition to their precious collection.</p>
				<br>            
            </div>
        </article>
         <aside>
       		<img src="${pageContext.request.contextPath}/img/photos/Products/S12_3990.jpg" alt="S12_3990">
       		<img src="${pageContext.request.contextPath}/img/photos/Products/S24_2360.jpg" alt="S24_2360">
       		<img src="${pageContext.request.contextPath}/img/photos/Products/S24_3949.jpg" alt="S24_3949">
        </aside>
        </div>
   </jsp:body>
</t:pageTemplate>
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
   
    	<%@ include file="categories.jsp" %>
        <aside class="element">
            <div>
	            <sec:authorize access="isAuthenticated()">
	            <sec:authentication property="principal.username" var="username" />
				    Welcome Back, ${username}
				    <br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('SUPEREMPLOYEE')">
					<li><a href="/employees/manager"> Employees</a></li>
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('EMPLOYEE')">
				This content is only shown to EMPLOYEE.
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('ADMIN')">
					<li><a href="/employees/global"> Employees</a></li>
				<br>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('CLIENT')">
				  This content is only shown to client.
				  <br>
				</sec:authorize>
				
			<br/>
			
            <h1>Nos Nouveautés</h1>
            <p id="newItem"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                quis nostrud exercitation.
            </p>
            </div>
        </aside>
        <article class="element">
            <div>
                <h2>Mon test normal</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
        </article>
        <article class="element">
            <div>
                <h2 id="intro">Mon test 2 en vert</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
        </article>
    </section>
   </jsp:body>
</t:pageTemplate>
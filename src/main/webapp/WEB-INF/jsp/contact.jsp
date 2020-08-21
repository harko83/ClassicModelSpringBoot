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
        <aside class="element">
            <div>
            	<sec:authorize access="!isAuthenticated()">
				    Welcome Visitor
				    <br>
				</sec:authorize>
	            <sec:authorize access="isAuthenticated()">
	            <sec:authentication property="principal.username" var="username" />
				    Welcome Back, ${username}
				    <br>
				</sec:authorize>
				<sec:authorize access="hasAuthority('CLIENT')">
				  This content is only shown to client.
				  <br>
				</sec:authorize>
			<br/>
            </div>
        </aside>
        <form:form method="POST" id="contactform" action="/contact/sendMessage" modelAttribute="contactMSG" onclick="return contactValidate()">
            <div class="form ContactGridContainer">
                <div class="grid-item-r">
               		<form:label path="firstname">Name</form:label>
               	</div>
               	<div class="grid-item">	
                	<form:input path="firstname" id="firstname" type="text" placeholder="Your name *"/>
                	<span id="nameError" class="alert"></span>
                </div>
                <div class="grid-item-r">
                	<form:label path="lastname">Lastname</form:label>
                </div>
                <div class="grid-item">
                	<form:input path="lastname" type="text" placeholder="Your lastname *"/>
                </div>
                <div class="grid-item-r">
               		<form:label path="phone">Phone</form:label>
               	</div>
               	<div class="grid-item">
                	<form:input path="phone" type="text" placeholder="Your phone number"/>
                </div>
                <div class="grid-item-r">
                	<form:label path="country">Country</form:label>
                </div>
                <div class="grid-item">
                	<form:input path="country" type="text" placeholder="Your country *"/>
                </div>
                <div class="grid-item-r">
                	<form:label path="email">E-mail address</form:label>
                </div>
                <div class="grid-item">	
                	<form:input path="email" id="email" type="text" placeholder="Your e-mail address *"/>
                	<span id="emailError" class="alert"></span>
                </div>
                <div class="grid-item-r">
                	<form:label path="object">Object</form:label>
                </div>
                <div class="grid-item"> 	
                	<form:input path="object" type="text" placeholder="Object of your message *"/>
                </div>
                <div class="grid-item-r">	
                	<form:label path="message">Message</form:label>
                </div>
                <div class="grid-item">
                	<form:textarea path="message" rows="14" placeholder="New account, feedback, ask your questions *"></form:textarea>
                	<input type="submit" id="submit" class="SendContact" value="Send"/>
                </div>	
            </div>
            </form:form>
   </jsp:body>
</t:pageTemplate>
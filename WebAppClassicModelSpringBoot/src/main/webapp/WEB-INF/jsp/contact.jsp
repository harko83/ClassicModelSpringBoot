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
            <div class="form">
                <div class="six columns noleftmargin">
               		<form:label path="firstname">Name</form:label>
                	<form:input path="firstname" type="text"  class="smoothborder" placeholder="Your name *"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="lastname">Lastname</form:label>
                	<form:input path="lastname" type="text"  class="smoothborder" placeholder="Your lastname *"/>
                </div>
                <div class="six columns noleftmargin">
               		<form:label path="phone">Phone</form:label>
                	<form:input path="phone" type="text"  class="smoothborder" placeholder="Your phone number"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="country">Country</form:label>
                	<form:input path="country" type="text"  class="smoothborder" placeholder="Your country *"/>
                </div>
                <div class="six columns">
                    <span id="emailError" class="alert"></span>
                    <br/>
                	<form:label path="email">E-mail address</form:label>
                	<form:input path="email" id="email" type="text"  class="smoothborder" placeholder="Your e-mail address *"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="object">Object</form:label>
                	<form:input path="object" type="text"  class="smoothborder" placeholder="Object of your message *"/>
                </div>
                	<form:label path="message">Message</form:label>
                	<form:textarea path="message" class="smoothborder ctextarea" rows="14" placeholder="New account, feedback, ask your questions *"></form:textarea>
                <input type="submit" id="submit" class="readmore" value="Send"/>
            </div>
            </form:form>
    </section>
   </jsp:body>
</t:pageTemplate>
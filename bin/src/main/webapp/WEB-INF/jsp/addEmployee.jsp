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
		<p>Add a new employee</p>
		<br>
		
        <form:form method="POST" id="contactform" action="/employees/global/addEmployee" modelAttribute="NewEmployee">
            <div class="form">
                <div class="six columns noleftmargin">
               		<form:label path="employeeNumber">Employee number</form:label>
                	<form:input path="employeeNumber" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="lastName">Lastname</form:label>
                	<form:input path="lastName" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns noleftmargin">
               		<form:label path="firstName">Firsname</form:label>
                	<form:input path="firstName" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="extension">Extension</form:label>
                	<form:input path="extension" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns">
                	<form:label path="email">E-mail address</form:label>
                	<form:input path="email" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="officeCode">Office code</form:label>
                	<form:input path="officeCode" type="text"  class="smoothborder"/>
                </div>
                <div class="six columns noleftmargin">
                	<form:label path="reportsTo">Report to</form:label>
                	<form:input path="reportsTo" type="text"  class="smoothborder"/>
                </div>	
                <div class="six columns noleftmargin">
                	<form:label path="jobTitle">Job title</form:label>
                	<form:input path="jobTitle" type="text"  class="smoothborder"/>
                </div>		
                <input type="submit" id="submit" class="readmore" value="Create Employee"/>
            </div>
            </form:form>
            <a href="/employees/global"><button>Cancel</button></a>
    </section>
   </jsp:body>
</t:pageTemplate>
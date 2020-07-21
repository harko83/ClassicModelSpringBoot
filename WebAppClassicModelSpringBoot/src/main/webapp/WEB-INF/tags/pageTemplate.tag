<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="additionalCss" fragment="true" %>
<%@attribute name="additionalJs" fragment="true" %>

<!DOCTYPE HTML>

<html>
   <head>
      <%@ include file="htmlHead.jspf" %>
   </head>
   
   <body class="subpage">
      <%@ include file="header.jspf" %>

      <section class="wrapper">
         <div class="inner">
            <jsp:doBody/>
         </div>
      </section>
         
      <%@ include file="footer.jspf" %>
      
      <%@ include file="jsFooter.jspf" %>
   </body>
</html>
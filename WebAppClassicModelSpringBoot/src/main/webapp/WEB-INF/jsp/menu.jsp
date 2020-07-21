<nav class="menu">
	<h1 class="logo"><a href="/" class="logo">Classic Models</a></h1>
      <ul class="nav-links">
           <li><a href="/">Home</a></li>
           
           <li><a href="/products"> Products</a></li>
           
           	<sec:authorize access="hasAuthority('CLIENT')">
				<li><a href="/cart">Cart</a></li>
				<li><a href="/contact"> Contact</a></li>
			</sec:authorize>
	           	<sec:authorize access="!isAuthenticated()">
	           		<li><a href="/contact"> Contact</a></li>
					 <li><form method="post" action="${contextPath}/login">
					 <span>${message}</span>
				     <input type="text" placeholder="Username" name="login" id="login" size="5%">
				     <input type="password" placeholder="Password" name="pass" id="pass" size="5%">

				     <!--  input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->
				     <button type="submit">Connect</button> 
			    	 </form></li>
			    	 <br><span>${error}</span>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
		            <li><form method="get" action="/logout">
		        	<p>Bienvenue <sec:authentication property="principal.username"/></p>
				    <button type="submit">Disconnect</button>
				    </form></li>
				</sec:authorize>


      </ul>
      <div class="burger">
      		<div class="line1"></div>
      		<div class="line2"></div>
      		<div class="line3"></div>
      </div>
      <script src="${pageContext.request.contextPath}/js/app.js"></script>
</nav>
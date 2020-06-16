<nav class="menu">
	<h1 class="logo"><a href="/" class="logo">Classic Models</a></h1>
      <ul class="nav-links">
           <li><a href="/">Home</a></li>
           
           <li><a href="/categories"> Products</a></li>

           <c:choose>
	           <c:when test="${ !empty sessionScope.login }">
				   <li><a href="/cart">Cart</a></li>
		           <li><form method="get" action="/logout">
				      <p>Bienvenue ${ sessionScope.login }</p>
				      <button type="submit">Disconnect</button>
				   </form></li>
			   </c:when>
			   <c:otherwise>
	           <li><form method="post" action="/login">
	           
			      <input type="text" placeholder="Username" name="login" id="login" size="5%">
			      
			      <input type="password" placeholder="Password" name="pass" id="pass" size="5%">
			      
			      <button type="submit">Connect</button>
			      
			    </form></li>
			    </c:otherwise>
		    </c:choose>
      </ul>
      <div class="burger">
      		<div class="line1"></div>
      		<div class="line2"></div>
      		<div class="line3"></div>
      </div>
      <script src="js/app.js"></script>
</nav>
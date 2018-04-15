<%@ page pageEncoding="UTF-8" %>
<!-- taglibs.jsp -->
<c:import url="includes/header.jsp" />
<title>Produits</title>
</head>
<body>
	<c:import url="includes/menu.jsp" />
	<div class="container">
		<h1>Affichage des produits</h1>
		
		<c:out value="${listeProduits } coucou"/>
		
		<c:forEach items="${produit }" var="i">
			<p>test</p>
			<td><c:out value="${i }"/></td>
		</c:forEach>
	</div>
</body>
</html>


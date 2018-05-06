<%@ page pageEncoding="UTF-8" %>
<!-- taglibs.jsp -->
<c:import url="includes/header.jsp" />
<title>Produits</title>
</head>
<body>
	<c:import url="includes/menu.jsp" />
	<div class="container">
		<h1>Affichage des produits</h1>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Libellé</th>
					<th scope="col">Magasin</th>
					<th scope="col">Poids</th>
					<th scope="col">Prix au kilo</th>
					<th scope="col">Prix</th>
					<th scope="col">En stock</th>
					<th scope="col">Reste en Stock</th>
					<th class="action">Action</th>
				</tr>
			</thead>
			
			<c:forEach items="${produits }" var="produit">
				<tr class="">
					<%-- Affichage des propriétés du bean Pilote, qui est stocké en tant que valeur de l'entrée courante de la map --%>
					<td><c:out value="${produit.libelle }"/></td>
					<td><c:out value="${produit.magasin }"/></td>
					<td><c:out value="${produit.poids } kg"/></td>
					<td><c:out value="${produit.prixKilo } €/kg"/></td>
					<td><c:out value="${produit.prix } €"/></td>
					<td>
						<c:if test="${produit.stock }"><p style="color:olive;"><c:out value="OUI"/></p></c:if>
						<c:if test="${produit.stock == false }"><p style="color:tomato;"><c:out value="NON"/></p></c:if>
					</td>
					<td><c:out value="${produit.reste } kg"/></td>
					<td class="action"><a
						href="<c:url value="/SuppressionProduit"><c:param name="id_produit" value="${ produit.id }" /></c:url>">
							<span class="glyphicon glyphicon-trash" aria-hidden="true">supprimer !</span>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>


<%@ page pageEncoding="UTF-8" %>
<!-- taglibs.jsp -->
<c:import url="includes/header.jsp" />
<title>Créer une recette</title>
</head>
<body>
	<c:import url="includes/menu.jsp" />
	<div class="container">
		<h1>Recette</h1>

		<h2>Enregistrer une recette</h2>
		
		<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }"/></p></c:if>
		
		<form name="formulaire2" method="post" action="Recette">
      
			<div class="form-group">
				<label for="libelle">Titre de la recette</label> 
				<input type="text" class="form-control" id="titre" name="titre" placeholder="Recette" value="<c:out value="${recette.titre}"/>">
			</div>

			<div class="form-group">
				<label for="description">Description</label> 
				<textarea class="form-control" id="description" name="description" placeholder="description"><c:out value="${recette.descripton}"/></textarea>
			</div>
			
			<div class="form-group">
				<label for="nbrepersonnes">Nombre de personnes</label>
				<input type="number" class="form-control" id="nbrepersonnes" name="nbrepersonnes" placeholder="4 personnes">
			</div>

			<div class="form-group">
				<label for="saison">Saison où consommer ce produit</label> <select
					class="form-control" id="saison" name="saison">
					<c:forEach items="${enumSaisons }" var="enumSaisonValue">
						<option value="${enumSaisonValue}">${enumSaisonValue}</option>
					</c:forEach>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary">Enregistrer</button>
			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</form>
	</div>
	<c:import url="includes/scripts.jsp" />
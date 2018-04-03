<%@ page pageEncoding="UTF-8" %>
<!-- taglibs.jsp -->
<c:import url="includes/header.jsp" />
<title>Produit</title>
</head>
<body>
	<c:import url="includes/menu.jsp" />
	<div class="container">
		<h1>Produit</h1>

		<h2>Enregistrer un produit</h2>

		<form method="post" action="produit">
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="radioProduit" id="radio1" value="prodemb" checked>
					<label class="form-check-label" for="radio1">Produit emballé</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="radioProduit" id="radio2" value="prodvrac">
					<label class="form-check-label" for="radio2"> Produit vrac </label>
				</div>
			</div>
			<div class="form-group">
				<label for="libelle">Nom du produit</label> <input type="text"
					class="form-control" id="libelle" name="libelle"
					placeholder="Produit">
			</div>

			<div class="form-group">
				<label for="prixkilo">Prix au kilo</label> 
				<input type="number" class="form-control" id="prixkilo" name="prixkilo" placeholder="0,00 € / kg" 
					<c:if test = "{}">
						<c:out value="disabled"/>
					</c:if>>
			</div>

			<div class="form-group">
				<label for="poids">Poids en kilo</label> <input type="number"
					class="form-control" id="poids" name="poids" placeholder="0,00 kg">
			</div>

			<div class="form-group">
				<label for="prixkilo">Prix</label> <input type="number"
					class="form-control" id="prix" name="prix" placeholder="0,00 €">
			</div>

			<div class="form-group">
				<label for="magasin">Magasin où acheter ce produit</label> <select
					class="form-control" id="magasin" name="magasin">
					<c:forEach items="${enumMagasins }" var="enumMagValue">
						<option value="${enumMagValue}">${enumMagValue}</option>
					</c:forEach>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary">Enregistrer</button>
		</form>
	</div>
	<c:import url="includes/scripts.jsp" />
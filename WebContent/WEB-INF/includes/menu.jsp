<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page isELIgnored="false" %>
<div class="container">	
	<ul class="nav justify-content-center nav-pills">
	  <li class="nav-item">
	    <a class="nav-link <c:out value="${indexActive }"/>" href="/ProjetPerso1">Accueil</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link <c:out value="${afficherProduitActive }"/>" href="produit">Produits</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link <c:out value="${creerProduitActive }"/>" href="creerproduit">Créer un Produit</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link <c:out value="${creerRecetteActive }"/>" href="creerrecette">Créer une Recette</a>
	  </li>
	</ul>
</div>
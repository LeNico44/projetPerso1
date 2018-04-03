<%@page isELIgnored="false" %>
<div class="container">	
	<ul class="nav justify-content-center nav-pills">
	  <li class="nav-item">
	    <a class="nav-link ${ url == urlIndex ? 'active' : ''}" href="/ProjetPerso1">Accueil</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link ${ url == urlProduit ? 'active' : ''}" href="produit">Produit</a>
	  </li>
	</ul>
</div>
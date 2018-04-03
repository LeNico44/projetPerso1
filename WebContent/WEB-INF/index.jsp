<%@ page pageEncoding="UTF-8" %>
<!-- taglibs.jsp -->
<c:import url="includes/header.jsp"/>
<title>Projet Perso One !</title>
</head>
<body>
	<c:import url="includes/menu.jsp"/>
	<div class="container">
		<h1>PROJET PERSO ONE !</h1>
		<p><c:out value="${produit.getMagasin() }" /></p>
	</div>
<c:import url="includes/scripts.jsp"/>
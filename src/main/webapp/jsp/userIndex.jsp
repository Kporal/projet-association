<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Inscription</title>
    <jsp:include page="template/header.jspf" flush="true" />
  </head>
  <body>
	
  	<jsp:include page="template/navbar.jspf"></jsp:include>
	
	<div class="container">
  <h2>Bienvenue sur Bazaar, le site des adhérents de l'association.</h2>
  <p>
	  <ul>
		  <li> <a href="#">Consulter la liste des articles disponibles</a></li>
		  <li> <a href="#">Consulter votre commande</a></li>
	  </ul>
  </p>
  
  	</div><!-- /container -->
  
	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
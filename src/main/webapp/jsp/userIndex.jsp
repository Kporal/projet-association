<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Inscription</title>
    <jsp:include page="template/header.jspf" flush="true" />
  </head>
  <body>
	
  	<jsp:include page="template/navbar.jsp"></jsp:include>
	
	<br>
	<div class="container">
		<div class="well">
		
		  <h1>Bienvenue sur Bazaar, le site des adhérents de l'association.</h1>
		  <ul>
			  <li><a href="items">Consulter la liste des articles disponibles</a></li>
			  <li><a href="order">Consulter votre commande</a></li>
		  </ul>
		  
		</div>
  
  	</div><!-- /container -->
  
	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
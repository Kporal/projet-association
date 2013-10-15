<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Votre commande</title>
    <jsp:include page="template/header.jspf" flush="true" />
    <style type="text/css">
    	.red, .red a {
    		color: red;
    	}
    </style>
  </head>
  <body>
  	
  	<jsp:include page="template/navbar.jspf"></jsp:include>
  	
	<br>
	<div class="container">
		<div class="well">
			
			<h1>Votre panier <small><span class="glyphicon glyphicon-shopping-cart"></span></small></h1>
			
			<table class="table table-hover table-bordered table-striped">
				<tr>
					<th>Code</th>
					<th>Nom</th>
					<th>Prix</th>
				</tr>
				<tr>
					<td>T1</td>
					<td>T1</td>
					<td>T1</td>
				</tr>
				<tr>
					<td>T1</td>
					<td>T1</td>
					<td>T1</td>
				</tr>
				<c:if test="${empty order}">
					<tr>
						<td colspan="5" align="center">
							<em>Votre panier est actuellement vide</em><br>
							<a href="items" title="Ajouter des articles dans mon panier">
								<span class="glyphicon glyphicon-exclamation-sign"></span> Commander maintenant
							</a>
						</td>
					</tr>
				</c:if>
			</table>
			
			<button class="btn btn-danger">
				<span class="glyphicon glyphicon-remove"></span> Annuler la commande
			</button>
			
			<button class="btn btn-success pull-right">
				<span class="glyphicon glyphicon-credit-card"></span> Valider la commande
			</button>
			
		</div><!-- /well -->
	</div><!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  
	<br>
	<div class="container">
		<div class="well">
			
			<h1>Votre commande</h1>
			
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
			</table>
			
			<a href="#" title="Annulez la commande">
				<span class="glyphicon glyphicon-remove red"></span> Annulez la commande
			</a>
			
		</div><!-- /well -->
	</div><!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
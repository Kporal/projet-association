<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Catalogue des articles</title>
<jsp:include page="template/header.jspf" flush="true" />
</head>
<body>

	<jsp:include page="template/navbar.jspf"></jsp:include>

	<br>
	<div class="container">
	
		<c:if test="${!empty msg}">
			<div class="alert alert-${type}">
				${msg}
				<a href="order" class="alert-link">Consulter le panier</a>
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>
		</c:if>
		
		<div class="well">

			<h1>Catalogue des articles</h1>

			<table class="table table-hover table-bordered table-striped">
				<tr>
					<th>Code</th>
					<th>Nom</th>
					<th>Prix</th>
					<th>Stock</th>
					<th><span class="label label-primary">Action</span></th>
				</tr>
				<c:forEach var="article" items="${items}">
					<tr>
						<td>${article.code}</td>
						<td>${article.name}</td>
						<td>${article.price}</td>
						<td>${article.stock}</td>
						<td>
							<a href="items?id=${article.id}" class="btn btn-success" title="Commander">
								<span class="glyphicon glyphicon-ok"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${empty items}">
					<tr><td colspan="5" align="center"><em>Aucun article disponible</em></td></tr>
				</c:if>
			</table>

		</div>
		<!-- /well -->
	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
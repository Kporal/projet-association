<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<td><c:out value="${article.code}" /></td>
						<td><c:out value="${article.name}" /></td>
						<td><c:out value="${article.price}" /></td>
						<td><c:out value="${article.stock}" /></td>
						<td><a href="#" title="Commandez"><span class="glyphicon glyphicon-ok"></span></a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<!-- /well -->
	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
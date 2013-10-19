<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
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

		<c:if test="${!empty msg}">
			<div class="alert alert-${type}">
				${msg} <a href="items" class="alert-link">Consulter les articles</a>
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>
		</c:if>

		<div class="well">

			<h1>Bienvenue sur Bazaar, le site des adhérents de
				l'association.</h1>
			<ul>
				<li><a href="items">Consulter la liste des articles
						disponibles</a></li>
				<li><a href="order">Consulter votre commande</a></li>
			</ul>

		</div>

	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>
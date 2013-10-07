<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Index</title>
<!-- Style -->
<link href="../ressources/css/signin.css" rel="stylesheet"
	media="screen">
<jsp:include page="template/header.jsp" flush="true" />
</head>
<body>

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">Veuillez vous connecter</h2>
			<input type="text" class="form-control" placeholder="Identifiant"
				autofocus> <input type="password" class="form-control"
				placeholder="Mot de passe">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Se
				connecter</button>
		</form>

	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jsp" flush="true" />
</body>
</html>
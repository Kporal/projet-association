<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Inscription</title>
<jsp:include page="template/header.jsp" flush="true" />
</head>
<body>

	<br>
	<div class="container">

		<div class="well">
			<form class="form-horizontal" role="form">

				<legend>Nouvelle inscription</legend>

				<div class="form-group">
					<label for="input-login" class="col-md-2 control-label">Identifiant</label>
					<div class="col-md-3">
						<input type="text" name="login" id="input-login"
							class="form-control" placeholder="identifiant"
							title="identifiant">
					</div>
				</div>

				<div class="form-group">
					<label for="input-password" class="col-md-2 control-label">Mot
						de passe</label>
					<div class="col-md-3">
						<input type="password" name="password" id="input-password"
							class="form-control" placeholder="mot de passe"
							title="mot de passse">
					</div>
				</div>

				<div class="form-group">
					<label for="input-firstName" class="col-md-2 control-label">Nom</label>
					<div class="col-md-3">
						<input type="text" name="firstName" id="input-firstName"
							class="form-control" placeholder="nom" title="nom">
					</div>
				</div>

				<div class="form-group">
					<label for="input-lastName" class="col-md-2 control-label">Prénom</label>
					<div class="col-md-3">
						<input type="text" name="lastName" id="input-lastName"
							class="form-control" placeholder="prénom" title="prénom">
					</div>
				</div>

				<div class="form-group">
					<label for="input-adresse" class="col-md-2 control-label">Adresse</label>
					<div class="col-md-3">
						<input type="text" name="adresse" id="input-adresse"
							class="form-control" placeholder="adresse" title="adresse">
					</div>
				</div>

				<div class="form-group">
					<label for="input-zipCode" class="col-md-2 control-label">Code
						postal</label>
					<div class="col-md-3">
						<input type="text" name="zipCode" id="input-zipCode" maxlength="5"
							class="form-control" placeholder="code postal"
							title="code postal">
					</div>
				</div>

				<div class="form-group">
					<label for="input-city" class="col-md-2 control-label">Ville</label>
					<div class="col-md-3">
						<input type="text" name="city" id="input-city" maxlength="5"
							class="form-control" placeholder="ville" title="ville">
					</div>
				</div>

				<div class="form-group">
					<label for="input-country" class="col-md-2 control-label">Pays</label>
					<div class="col-md-3">
						<select class="form-control" id="input-country" name="country"
							title="pays">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>

			</form>
		</div>
		<!-- /well -->
	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jsp" flush="true" />
</body>
</html>
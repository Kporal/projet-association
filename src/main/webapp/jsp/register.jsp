<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Inscription</title>
<jsp:include page="template/header.jspf" flush="true" />
</head>
<body>

	<br>
	<div class="container">

		<div class="well">
			<form class="form-horizontal" role="form" method="POST" action="register">

				<legend>Nouvelle inscription</legend>
<c:if test="${registerError}">
	<span class="help-block"><font color="red">Erreur : ${errorText}</font></span>
</c:if>
				<div class="form-group">
					<label for="input-login" class="col-md-2 control-label">Identifiant</label>
					<font color="red">*</font>
					<div class="col-md-3">
						<input type="text" name="login" id="input-login"
							class="form-control" placeholder="identifiant"
							title="identifiant" required autofocus>
					</div>
				</div>

				<div class="form-group">
					<label for="input-password" class="col-md-2 control-label">Mot
						de passe</label> <font color="red">*</font>
					<div class="col-md-3">
						<input type="password" name="password" id="input-password"
							class="form-control" placeholder="mot de passe"
							title="mot de passse" required>
					</div>
				</div>

				<div class="form-group">
					<label for="input-passwordConfirm" class="col-md-2 control-label">Mot
						de passe</label> <font color="red">*</font>
					<div class="col-md-3">
						<input type="password" name="passwordConfirm"
							id="input-passwordConfirm" class="form-control"
							placeholder="mot de passe" title="mot de passse" required>
						<span class="help-block">Confirmation du mot de passe</span>
					</div>
				</div>

				<div class="form-group">
					<label for="input-firstName" class="col-md-2 control-label">Prénom</label>
					<font color="red">*</font>
					<div class="col-md-3">
						<input type="text" name="firstName" id="input-firstName"
							class="form-control" placeholder="prénom" title="prénom" required>
					</div>
				</div>

				<div class="form-group">
					<label for="input-lastName" class="col-md-2 control-label">Nom</label>
					<font color="red">*</font>
					<div class="col-md-3">
						<input type="text" name="lastName" id="input-lastName"
							class="form-control" placeholder="nom" title="nom" required>
					</div>
				</div>

				<div class="form-group">
					<label for="input-address" class="col-md-2 control-label">Adresse</label>
					<div class="col-md-3">
						<input type="text" name="address" id="input-address"
							class="form-control" placeholder="adresse" title="adresse">
						<span class="help-block">La rue du lieu de résidence</span>
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
								<c:forEach var="pays" items="${country}"> 
									<option value="${pays.id}">
										${pays.name}
									</option>
								</c:forEach>
						</select>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 col-md-offset-2">
						<input type="submit" class="btn btn-primary" value ="S'enregistrer">
						<a href="signin" class="btn btn-danger">Annuler</a>
					</div>
				</div>

				<span class="help-block"><font color="red">*</font> Champs
					obligatoire</span>

			</form>
		</div>
		<!-- /well -->
	</div>
	<!-- /container -->

	<jsp:include page="template/footer.jspf" flush="true" />
</body>
</html>

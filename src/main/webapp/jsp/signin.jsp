<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Connexion</title>
    <jsp:include page="template/header.jspf" flush="true"/>
    <!-- Style -->
    <link href="ressources/css/signin.css" rel="stylesheet" media="screen">
  </head>
  <body>
  
    <div class="container">

      <form method="post" class="form-signin" action='#'>
      	<h2 class="form-signin-heading">Veuillez vous connecter</h2>
      	<c:if test="${error}"> 
      		<span><font color="red">Identifiant / Mot de passe incorrect</font></span> 
      	</c:if>
        <input type="text" name="login" class="form-control" placeholder="Identifiant" autofocus>
        <input type="password" name="pass" class="form-control" placeholder="Mot de passe">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
        <span class="help-block">
	      	Pas encore enregistré ? 
	      	<a href="register">Créez votre compte</a>
	    </span>
      </form>

    </div> <!-- /container -->

    <jsp:include page="template/footer.jspf" flush="true" />
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="home">Bazaar</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li><a href="items"><span class="glyphicon glyphicon-list"></span> Article</a></li>
      <li><a href="order"><span class="glyphicon glyphicon-shopping-cart"></span> Commande</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
      	<a href="Disconnect">Adherent : ${user.firstName} ${user.lastName} <span class="glyphicon glyphicon-off" title="Se déconnecter"></span></a>
      </li>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>
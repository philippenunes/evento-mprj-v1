<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="negocio.Evento"%>
<%@page import="negocio.EquipamentoPGJ"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css.css">
<link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="script-modelos.js"></script>
<meta charset="ISO-8859-1">
<title>Eventos - MPRJ</title>
</head>

<body>

	<div class="navbar navbar-static-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<div class="nav-bar">
					<ul class="menu-principal">
						<li>
							<div class="dropdown">
								<a href="#" data-toggle="dropdown">Cadastrar</a>
							    <ul class="dropdown-menu">
							      <li><a href="cadastro-evento.html">Eventos</a></li>
							      <li><a href="cadastro-equipamento.html">Equipamento PGJ</a></li>
							    </ul>
							 </div>
						</li>&ensp;
						<li>
							<div class="dropdown">
								<a href="#" data-toggle="dropdown">Listar</a>
							    <ul class="dropdown-menu">
							      <li><a href="lista-evento.jsp?parametro=0">Eventos</a></li>
							      <li><a href="lista-equipamento.jsp?parametro=0">Inventário PGJ</a></li>
							    </ul>
							 </div>
						</li>&ensp;
						<li><a href="suporte.html">Suporte</a></li>
						<li><a href="suporte.html">Sair</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<hr>
	<br>
	
	<div class="container">
	
	
	
	
	
	
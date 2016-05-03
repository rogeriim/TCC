<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>
<script src="../js/jquery.sortelements.js" type="text/javascript"></script>
<script src="../js/jquery.bdt.js" type="text/javascript"></script>

<title>Gerenciador de TCC | FACOM</title>

<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="../css/styles.css" rel="stylesheet" type="text/css">
<link href="../css/mediaqueries.css" rel="stylesheet" type="text/css">
<link href="../css/font-awesome.min.css" type="text/css"
	rel="stylesheet">
<link href="../css/jquery.bdt.css" type="text/css" rel="stylesheet">
<link href="../css/jquery.bdt.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">

		<!-- Start Header-->
		<header id="header">
			<div class="pageWidth">
				<h1 id="logo">
					<a href="#"><img src="../img/logo.png"
						title="Gerenciador de TCC | FACOM" /></a>
				</h1>
			</div>
				
				<nav class="navbar navbar-default" role="navigation">
					<div class="pageWidth">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bar1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="collapse navbar-collapse" id="bar1">
							<ul class="nav navbar-nav">
							<li><a href="trabalhos.html" title="Trabalhos">Trabalhos</a></li>
							<li><a href="bancas.html" title="Bancas">Bancas</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
			<!-- End Header-->  
			
			<!-- Start Middle-->
			<section id="container">
			
				<div class="container" >
					
					<h3 class="page-header">${trabalho.getTitulo() }</h3>
  
					<div class="row">
						<div class="col-sm-12">
							<label><strong>Tema</strong></label>
							<p>${trabalho.getTema().getTema() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
						<div class="col-sm-12">
							<label><strong>Descrição</strong></label>
							<p>${trabalho.getDescricao() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
						<div class="col-sm-12">
							<label><strong>Orientando</strong></label>
							<p>${trabalho.getOrientando().getNome() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
					</div>
					
					<hr />
					
					<div class="col-md-12 form-actions">
						<a href="trabalhos.html" class="btn btn-link">Voltar</a>
					</div>
				
				</div> <!-- /#container -->
						
			</section>
			<!-- End Middle--> 
			
			<!-- Start Footer-->
			<footer id="footer">
				<div class="copyRight">Universidade Federal de Uberlândia |
					Copyright © 2016 | Todos os Direitos Reservados</div>
			</footer>
			<!-- END Footer-->
			
		</div>
		
	</body>
	
</html>

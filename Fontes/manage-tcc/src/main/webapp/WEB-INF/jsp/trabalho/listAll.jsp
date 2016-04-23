<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script src="../js/bootstrap.js"type="text/javascript"></script>
		<script src="../js/jquery.sortelements.js" type="text/javascript"></script>
		<script src="../js/jquery.bdt.js" type="text/javascript"></script>
	
		<title>Gerenciador de TCC | FACOM</title>

		<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />		
		<link href="../css/styles.css" rel="stylesheet" type="text/css">
		<link href="../css/mediaqueries.css" rel="stylesheet" type="text/css">
		<link href="../css/font-awesome.min.css" type="text/css" rel="stylesheet">
		<link href="../css/jquery.bdt.css" type="text/css" rel="stylesheet">
		<link href="../css/jquery.bdt.min.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div id="wrapper"> 
				
			<!-- Start Header-->
			<header id="header">
				<div class="pageWidth">
					<h1 id="logo">
						<a href="#"><img src="../img/logo.png" title="Gerenciador de TCC | FACOM" /></a> 
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
		
			<section id="container">
				<div class="container" >
				
					<div id="top" class="row">
						<div class="col-sm-6" align="center" >
							<h2>Trabalhos</h2>
						</div>
					</div>
					
					<hr />
					
					<table id="bootstrap-table" class="table table-striped table-hover" >
						<thead>
							<tr>
								<th><strong>Título</strong></th>
								<th><strong>Data</strong></th>
								<th class="actions"><a href="trabalhos-adicionar.html" class="btn btn-primary h2">Adicionar novo</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${trabalhoList}" var="trabalho">
								<tr>
									<td>${trabalho.getTitulo() }</td>
									<td>${trabalho.getData() }</td>
									<td class="actions"><a class="btn btn-primary btn-xs"
										href="trabalhos-visualizar.html">Visualizar</a> <a
										class="btn btn-primary btn-xs" href="trabalhos-editar.html">Editar</a>
										<a class="btn btn-danger btn-xs" href="#" data-toggle="modal"
										data-target="#delete-modal">Excluir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="modalLabel">Excluir Item</h4>
								</div>
								<div class="modal-body">
									Deseja realmente excluir este item?
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary" data-dismiss="modal">Sim</button>
									<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
								</div>
							</div>
						</div>
					</div>
				
				</div> <!-- END container -->
				
			</section>
				
				<!-- Start Footer-->
				<footer id="footer">
					<div class="copyRight">Universidade Federal de Uberlândia | Copyright © 2016 | Todos os Direitos Reservados</div>
				</footer>
				<!-- END Footer--> 
		
		</div> <!-- END Wrapper -->
		
	</body>
	
	<script>
		$(document).ready( function () {
			$('#bootstrap-table').bdt();
		});
		
		$(document).ready(function(){
			$("#myBtn").click(function(){
			$("#myModal").modal();
			});
		});
	</script>
</html>
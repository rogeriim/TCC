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
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bar1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="bar1">
						<ul class="nav navbar-nav">
							<li><a href="listar" title="Trabalhos">Trabalhos</a></li>
							<li><a href="bancas.html" title="Bancas">Bancas</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<!-- End Header-->

		<section id="container">
			<div class="container">

				<div id="top" class="row">
					<div class="col-sm-6" align="center">
						<h2>Trabalhos</h2>
					</div>
				</div>

				<hr />

				<table id="bootstrap-table" class="table table-striped table-hover">
					<thead>
						<tr>
							<th><strong>Título</strong></th>
							<th><strong>Data</strong></th>
							<th><strong>Tema</strong></th>
							<th class="actions"><a
								href="<c:url value="/trabalho/novo"/>"
								class="btn btn-primary h2">Adicionar novo</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${trabalhoList}" var="trabalho">
							<tr>
								<td>${trabalho.getTitulo() }</td>
								<td>${trabalho.getData() }</td>
								<td>${trabalho.getTema().getTema() }</td>
								<td class="actions"><a class="btn btn-primary btn-xs"
									href="ver?id=${trabalho.getId()}">Visualizar</a> <a
									class="btn btn-primary btn-xs" href="editar?id=${trabalho.getId()}">Editar</a>
									<!--a class="btn btn-danger btn-xs" data-toggle="modal" href="delete?id=${trabalho.getId()}"
									data-target="#delete-modal">Excluir</a--> 
									<a class="btn btn-danger btn-xs"
									href="remove?id=${trabalho.getId()}">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- END container -->

		</section>

		<!-- Start Footer-->
		<footer id="footer">
			<div class="copyRight">Universidade Federal de Uberlândia |
				Copyright © 2016 | Todos os Direitos Reservados</div>
		</footer>
		<!-- END Footer-->

		<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Excluir Item</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este item?</div>
					<div class="modal-footer">
						<a type="submit" class="btn btn-primary" href="#">Sim</a> <a
							type="button" class="btn btn-default" data-dismiss="modal">Não</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- END Wrapper -->

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
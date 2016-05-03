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

			<div class="container">
				<h3 class="page-header">Editar trabalho</h3>
				
				<form action="altera">
					<div class="row">
						<div class="form-group col-sm-12">
							<label for="titulo">Título</label>
							<input class="form-control"
								type="hidden" id="id" name="trabalho.id" value="${estrutura.trabalho.getId() }"> 
							<input class="form-control"
								id="titulo" name="trabalho.titulo" value="${estrutura.trabalho.getTitulo() }">
						</div>
						<div class="form-group col-sm-12">
							<label for="tema">Tema</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="tema.id">
										<c:forEach items="${estrutura.tema}" var="tema">
											<option value="${tema.getId() }">${tema.getTema() }</option>
										</c:forEach>
										<option>Selecionar Tema</option>
									</select> <a class="btn btn-primary" href="#" data-toggle="modal"
										id="adicionarArea">Adicionar novo Tema</a>
								</div>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="descricao">Descrição</label>
							<textarea class="form-control" rows="10" id="descricao" 
							name="trabalho.descricao">${estrutura.trabalho.getDescricao() }</textarea>
						</div>
						<div class="form-group col-sm-12">
							<label for="orientando">Orientando</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="usuario.id">
										<c:forEach items="${estrutura.usuario}" var="usuario">
											<option value="${usuario.getId() }">${usuario.getNome() }</option>
										</c:forEach>
										<option>Selecionar Orientando</option>
									</select>
								</div>
							</div>
						</div>
					</div>
	
					<hr />

					<div class="row">
						<div class="col-md-12 form-actions">
							<button type="submit" class="btn btn-primary">Atualizar</button>
							<a href="trabalhos.html" class="btn btn-default">Cancelar</a>
						</div>
					</div>

				</form>

			</div>
			<!-- /#container -->

		</section>
		<!-- End Middle-->

		<!-- Start Footer-->
		<footer id="footer">
			<div class="copyRight">Universidade Federal de Uberlândia |
				Copyright © 2016 | Todos os Direitos Reservados</div>
		</footer>
		<!-- END Footer-->

	</div>

	<!-- Modal -->
	<div class="modal fade" id="novaArea" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Adicionar Tema</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action="adicionaTema">
						<div class="form-group">
							<label for="usrname">Tema</label> <input type="text"
								class="form-control" id="area" name="tema.tema" placeholder="Novo Tema">
						</div>
						<button type="submit" class="btn btn-primary btn-block">
							Adicionar</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default"
						data-dismiss="modal">Cancelar</button>
					<a href="<c:url value="/trabalho/novo"/>"  class="btn btn-link">Voltar</a>
				</div>
			</div>
		 </div>
	</div>
	<!-- END modal -->

</body>

<script>
		$(document).ready(function(){
			$("#adicionarArea").click(function(){
			$("#novaArea").modal();
			});
		});
	</script>

</html>
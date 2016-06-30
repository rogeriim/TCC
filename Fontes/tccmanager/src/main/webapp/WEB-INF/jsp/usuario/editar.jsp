<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>

<body>
	<div id="wrapper">

		<jsp:include page="/WEB-INF/jsp/template/header.jsp" />

		<!-- Start Middle-->
		<section id="container">

			<div class="container">
				<h3 class="page-header">Editar usuário</h3>

				<form action="altera" method="POST">
					<div class="row">
						<div class="form-group col-sm-12">
							<label for="matricula">Matricula</label> 
							<input class="form-control" type="hidden" id="matricula" name="usuario.matricula"
								value="${usuario.getMatricula() }"> 
							<label>${usuario.getMatricula() }</label>
						</div>
						<input class="form-control" type="hidden" id="senha" name="usuario.senha"
								value="${usuario.getSenha() }"> 
						<input class="form-control" type="hidden" id="primeiroAcesso" name="usuario.primeiroAcesso"
								value="${usuario.isPrimeiroAcesso() }"> 
						<div class="form-group col-sm-12">
							<label for="nome">Nome</label>
							<input class="form-control" type="text" id="nome"
								name="usuario.nome" value="${usuario.getNome() }">
						</div>
						<div class="form-group col-sm-12">
							<label for="email">E-mail</label>
							<input class="form-control" type="text" id="email"
								name="usuario.email" value="${usuario.getEmail() }">
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

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

</body>

</html>
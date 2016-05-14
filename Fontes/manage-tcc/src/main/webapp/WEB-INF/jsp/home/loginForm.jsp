<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>

<body>
	<div id="wrapper">

		<jsp:include page="/WEB-INF/jsp/template/header.jsp" />

		<!-- Start Middle-->
		<section id="container">

			<div class="container">

				<div class="row">

					<!-- INSERINDO QUEBRAS DE LINHA PARA AJUSTAR A PÁGINA -->
					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>
					<!-- FIM QUEBRAS DE LINHA -->

					<div class="col-sm-4"></div>

					<form class="col-sm-4" action="login" method="POST">
						<div class="row">
							<fieldset class="col-sm-12">
								<legend class="text-center h2">Login </legend>

								<div class="form-group">
									<label for="matricula">Matricula</label> <input type="text"
										class="form-control" id="matricula" name="usuario.matricula">
								</div>

								<div class="form-group">
									<label for="senha">Password</label> <input type="password"
										class="form-control" id="senha" name="usuario.senha">
								</div>

							</fieldset>
						</div>

						<button type="submit" class="btn btn-primary pull-right">
							Entrar</button>
						<a class="btn btn-link pull-right" style="margin-right: 10px"
							href="cadastro.html">Cadastrar</a>
					</form>
				</div>

			</div>

		</section>

		<!-- End Middle-->

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
	</div>
</body>
</html>

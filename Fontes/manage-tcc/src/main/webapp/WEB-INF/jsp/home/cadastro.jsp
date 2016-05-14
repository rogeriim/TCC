<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<!DOCTYPE html>
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
					<!-- FIM QUEBRAS DE LINHA -->

					<div class="col-sm-4"></div>

					<form class="col-sm-4" action="professor/trabalhos.html"
						method="POST">
						<div class="row">
							<fieldset class="col-sm-12">
								<legend class="text-center h2">Cadastro de Usuário</legend>

								<div class="form-group">
									<label for="nome">Nome</label> <input type="text"
										class="form-control" id="username" name="username">
								</div>
								<div class="form-group">
									<label for="matricula">Matricula</label> <input type="text"
										class="form-control" id="matricula" name="matricula">
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" id="email" name="email">
								</div>
								<div class="form-group">
									<label for="senha">Senha</label> <input type="password"
										class="form-control" id="senha" name="senha">
								</div>
								<div class="form-group">
									<label for="confirmar-senha">Confirmar Senha</label> <input
										type="password" class="form-control" id="confirmar-senha"
										name="confirmar-senha">
								</div>

							</fieldset>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn btn-primary pull-right">
								Cadastrar</button>
							<button type="reset" class="btn btn-default pull-right"
								style="margin-right: 10px">Limpar</button>
							<a class="btn btn-link pull-right" href="login.html">Voltar</a>
						</div>
					</form>
				</div>


			</div>

		</section>

		<!-- End Middle-->

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
	</div>
</body>
</html>

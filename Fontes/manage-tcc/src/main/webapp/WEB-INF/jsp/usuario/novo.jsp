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

				<div id="top" class="row">
					<div class="col-sm-6" align="center">
						<h2>Adicionar Usuário</h2>
					</div>
				</div>

				<hr />

				<form action="adiciona" method="POST">
					<div class="row">
						<div class="form-group col-sm-8">
							<label for="matricula">Matrícula</label> <input class="form-control"
								id="matricula" name="usuario.matricula">
						</div>
						<div class="form-group col-sm-8">
							<label for="email">E-mail</label> <input class="form-control"
								id="email" name="usuario.email">
						</div>
						<div class="form-group col-sm-8">
							<label for="nome">Nome</label> <input class="form-control"
								id="nome" name="usuario.nome">
						</div>
						<div class="form-group col-sm-8">
							<label for="perfil">Perfil</label>
							<div class="row">
								<div class="col-md-8 form-actions">
									<select class="btn btn-default" name="perfil.id">
										<c:forEach items="${perfilList}" var="perfil">
											<option value="${perfil.getId() }"> ${perfil.getPerfil() }</option>
										</c:forEach>
										<option>Selecionar Perfil</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<hr />

					<div class="row">
						<div class="col-md-8 form-actions">
							<button type="submit" class="btn btn-primary">Adicionar</button>
							<button type="reset" class="btn btn-default">Limpar</button>
							<a href="trabalhos.html" class="btn btn-link">Voltar</a>
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

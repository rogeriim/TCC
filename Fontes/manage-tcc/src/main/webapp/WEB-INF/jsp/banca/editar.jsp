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
				<h3 class="page-header">Editar Banca</h3>

				<form action="altera" method="POST">
					<div class="row">
						<input class="form-control" type="hidden" id="id"
							name="banca.id" value="${estruturaBanca.getId() }">
						<div class="form-group col-sm-12">
							<label for="tema">Status</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="banca.status">
										<option value="Em aberto">Em aberto</option>
										<option value="Fechada">Fechada</option>
									</select> 
								</div>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="tema">Avaliador 1</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="avaliador1.matricula">
										<c:forEach items="${estruturaBanca.avaliador1}" var="avaliador1">
											<option value="${avaliador1.getMatricula() }">${avaliador1.getNome() }</option>
										</c:forEach>
										<option>Selecionar Avaliador 1</option>
									</select> 
								</div>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="tema">Avaliador 2</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="avaliador2.matricula">
										<c:forEach items="${estruturaBanca.avaliador2}" var="avaliador2">
											<option value="${avaliador2.getMatricula() }">${avaliador2.getNome() }</option>
										</c:forEach>
										<option>Selecionar Avaliador 2</option>
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

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

</body>

</html>
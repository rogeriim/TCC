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
						<h2>Adicionar Banca</h2>
					</div>
				</div>

				<hr />

				<c:if test="${empty trabalhoList }">
					<p align="center">Você não possui trabalhos fechados para criar uma nova banca.</p>
				</c:if>

				<c:if test="${not empty trabalhoList }">

					<form action="adiciona" method="POST">
						<div class="row">
							<div class="form-group col-sm-3">
								<label for="resumo">Data Defesa</label> <input
									type="datetime-local" class="form-control" id="data"
									name="data" value="selected"> <input
									class="form-control" type="hidden" id="matricula"
									name="matricula" value="${usuarioWeb.getMatricula()}">
							</div>
							<div class="form-group col-sm-12">
								<label for="trabalho">Trabalho</label>
								<div class="row">
									<div class="col-md-12 form-actions">
										<select class="btn btn-default" name="trabalho.id">
											<c:forEach items="${trabalhoList }" var="trabalho">
												<option value="${trabalho.getId() }">${trabalho.getTitulo() }</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>

						<hr />

						<div class="row">
							<div class="col-md-12 form-actions">
								<button type="submit" class="btn btn-primary">Adicionar</button>
								<button type="reset" class="btn btn-default">Limpar</button>
								<a href="trabalhos.html" class="btn btn-link">Voltar</a>
							</div>
						</div>

					</form>

				</c:if>

			</div>
			<!-- /#container -->

		</section>
		<!-- End Middle-->

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

</body>

</html>

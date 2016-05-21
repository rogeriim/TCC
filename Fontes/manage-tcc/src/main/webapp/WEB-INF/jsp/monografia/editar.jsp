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
				<h3 class="page-header">Editar Monografia</h3>

				<form action="altera" method="POST">
					<div class="row">
						<input class="form-control" type="hidden" id="id"
							name="monografia.id" value="${monografia.getId() }">
						<div class="form-group col-sm-12">
							<label for="nome">Resumo</label> <input class="form-control"
								type="text" id="resumo" name="monografia.resumo"
								value="${monografia.getResumo() }">
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
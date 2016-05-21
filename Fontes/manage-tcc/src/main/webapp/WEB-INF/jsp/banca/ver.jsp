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

				<h3 class="page-header">Banca ${banca.getId() }</h3>

				<div class="row">
					<div class="col-sm-12">
						<label><strong>Data Defesa</strong></label>
						<p>${banca.getData() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Trabalho</strong></label>
						<p>${banca.getTrabalho().getTitulo() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Desenvolvido por</strong></label>
						<p>${monografia.getTrabalho().getOrientando() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Orientado por</strong></label>
						<p>${monografia.getTrabalho().getOrientador().getNome() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Avaliador 1</strong></label>
						<p>${banca.getAvaliador1().getNome() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Avaliador 2</strong></label>
						<p>${banca.getAvaliador2().getNome() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Status</strong></label>
						<p>${banca.getStatus() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

				</div>

				<hr />

				<div class="col-md-12 form-actions">
					<a href="trabalhos.html" class="btn btn-link">Voltar</a>
				</div>

			</div>
			<!-- /#container -->

		</section>
		<!-- End Middle-->

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>

<body>
	<div id="wrapper">

		<jsp:include page="/WEB-INF/jsp/template/header.jsp" />

		<!-- Start Middle-->
		<section id="container">

			<div class="container">

				<h3 class="page-header">${trabalho.getTitulo() }</h3>

				<div class="row">
					<div class="col-sm-12">
						<label><strong>Tema</strong></label>
						<p>${trabalho.getTema().getTema() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<div class="col-sm-12">
						<label><strong>Descrição</strong></label>
						<p>${estruturaTrabalho.trabalho.getDescricao() }</p>
					</div>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

					<c:if test="${usuarioWeb.professor || usuarioWeb.administrador }">
						<div class="col-sm-12">
							<label><strong>Orientando</strong></label>
							<p>${estruturaTrabalho.trabalho.getOrientando().getNome() }</p>
						</div>
					</c:if>

					<c:if test="${usuarioWeb.aluno }">
						<div class="col-sm-12">
							<label><strong>Orientador</strong></label>
							<p>${estruturaTrabalho.trabalho.getOrientador().getNome() }</p>
						</div>
					</c:if>

					<div class="row">
						<div class="col-sm-12 breakline">
							<br>
						</div>
					</div>

				</div>

				<hr />

				<div id="actions" class="row">
					<div class="col-sm-7">
						<a href="<c:url value="/trabalho/listar"/>" class="btn btn-link">Voltar</a>

						<c:if test="${usuarioWeb.aluno }">
							<c:if test="${fn:length(estruturaTrabalho.candidato) lt 1}">
								<div class="btn-group pull-right">
									<span class="carret"> <a
										href="<c:url value="/candidato/criar?id=${trabalho.getId()}
																	&matricula=${usuarioWeb.getMatricula() }" />"
										class="btn btn-primary" type="submit"> Candidatar-me ao
											trabalho </a>
									</span>
								</div>
							</c:if>
						</c:if>
					</div>
				</div>

			</div>
			<!-- /#container -->

		</section>
		<!-- End Middle-->

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

</body>

</html>

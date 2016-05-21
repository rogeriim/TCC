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
				<h3 class="page-header">Editar trabalho</h3>

				<form action="altera" method="POST">
					<div class="row">
						<div class="form-group col-sm-12">
							<label for="titulo">Título</label> <input class="form-control"
								type="hidden" id="id" name="trabalho.id"
								value="${estruturaTrabalho.trabalho.getId() }"> <input
								class="form-control" id="titulo" name="trabalho.titulo"
								value="${estruturaTrabalho.trabalho.getTitulo() }">
						</div>
						<div class="form-group col-sm-12">
							<label for="tema">Tema</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="tema.id">
										<c:forEach items="${estruturaTrabalho.tema}" var="tema">
											<option value="${tema.getId() }">${tema.getTema() }</option>
										</c:forEach>
										<option>Selecionar Tema</option>
									</select> <a class="btn btn-primary" data-toggle="modal"
										id="${estruturaTrabalho.trabalho.getId() }" data-target="#insere-tema">Adicionar
										novo Tema</a>
								</div>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="descricao">Descrição</label>
							<textarea class="form-control" rows="10" id="descricao"
								name="trabalho.descricao">${estruturaTrabalho.trabalho.getDescricao() }</textarea>
						</div>
						<div class="form-group col-sm-12">
							<label for="orientando">Orientando</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="usuario.id">
										<c:forEach items="${estruturaTrabalho.usuario}" var="usuario">
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

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>

	<!-- Modal -->
	<div class="modal fade" id="insere-tema" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Adicionar Tema</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action="adicionaTema" method="POST">
						<div class="form-group">
							<label for="usrname">Tema</label> <input type="text"
								class="form-control" id="tema" name="tema.tema"
								placeholder="Novo Tema"> <input type="hidden"
								name="pagina" value="editar"> <input type="hidden"
								id="trabalhoId" name="trabalhoId">
						</div>
						<button type="submit" class="btn btn-primary btn-block">
							Adicionar</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default"
						data-dismiss="modal">Cancelar</button>
					<a href="<c:url value="/trabalho/novo"/>" class="btn btn-link">Voltar</a>
				</div>
			</div>
		</div>
	</div>
	<!-- END modal -->

</body>

</html>
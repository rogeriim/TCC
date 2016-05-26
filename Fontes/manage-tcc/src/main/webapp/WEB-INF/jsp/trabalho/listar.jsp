<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>
<body>
	<div id="wrapper">
		<!-- START wrapper -->

		<jsp:include page="/WEB-INF/jsp/template/header.jsp" />

		<section id="container">

			<div class="container">
				<!-- START container -->

				<div id="top" class="row">
					<div class="col-sm-6" align="center">
						<h2>Trabalhos</h2>
					</div>
				</div>

				<hr />

				<table id="bootstrap-table" class="table table-striped table-hover">
					<thead>
						<tr>
							<th><strong>Título</strong></th>
							<c:if test="${usuarioWeb.professor || usuarioWeb.administrador }">
								<th><strong>Data</strong></th>
								<th><strong>Status</strong></th>
								<th><strong>Orientando</strong></th>
							</c:if>
							<th><strong>Tema</strong></th>
							<c:if test="${usuarioWeb.aluno }">
								<th><strong>Orientador</strong></th>
							</c:if>
							<th class="actions">
							 	<c:if test="${usuarioWeb.professor || usuarioWeb.administrador }">
									<a href="<c:url value="/trabalho/novo"/>"
										class="btn btn-primary h2">Adicionar novo</a>
								</c:if></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${trabalhoList}" var="trabalho">
							<tr>
								<td>${trabalho.getTitulo() }</td>
								<c:if test="${usuarioWeb.professor || usuarioWeb.administrador }">
									<td>${trabalho.getData() }</td>
									<td>${trabalho.getStatus() }</td>
									<td>
										<c:if test="${empty trabalho.getOrientando().getNome() }">
											Não possui
										</c:if>
										<c:if test="${not empty trabalho.getOrientando().getNome() }">
											${trabalho.getOrientando().getNome() }
										</c:if>
									</td>
								</c:if>
								<td>${trabalho.getTema().getTema() }</td>
								<c:if test="${usuarioWeb.aluno }">
									<td>${trabalho.getOrientador().getNome() }</td>
								</c:if>
								<td class="actions"><a class="btn btn-primary btn-xs"
									href="ver?id=${trabalho.getId()}&matricula=${usuarioWeb.getMatricula() }">Visualizar</a> 
									<c:if test="${(usuarioWeb.professor || usuarioWeb.administrador) and
												trabalho.getStatus() == 'ABERTO' }">
										<a class="btn btn-primary btn-xs" data-toggle="modal"
											id="${trabalho.getId()}" data-target="#save-modal">Salvar</a>
										<a class="btn btn-primary btn-xs"
											href="editar?id=${trabalho.getId()}">Editar</a>
										<a class="btn btn-danger btn-xs" data-toggle="modal"
											id="${trabalho.getId()}" data-target="#delete-modal">Excluir</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- END container -->

		</section>

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

		<div id="delete-modal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Excluir Trabalho</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este
						trabalho?</div>
					<div class="modal-footer">
						<a type="submit" class="btn btn-primary" id="deletar">Sim</a> <a
							type="button" class="btn btn-default" data-dismiss="modal">Não</a>
					</div>
				</div>
			</div>
		</div>
		
		<div id="save-modal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Salvar Trabalho</h4>
					</div>
					<div class="modal-body">Se você salvar esse trabalho, ele ficará com status FECHADO e 
						 não será possível alterá-lo nem excluí-lo posteriormente. Deseja realmente salvá-lo?</div>
					<div class="modal-footer">
						<a type="submit" class="btn btn-primary" id="salvar">Sim</a> <a
							type="button" class="btn btn-default" data-dismiss="modal">Não</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- END wrapper -->

</body>
</html>
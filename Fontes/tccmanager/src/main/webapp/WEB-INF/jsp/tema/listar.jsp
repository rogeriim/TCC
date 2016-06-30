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
						<h2>Temas</h2>
					</div>
				</div>

				<hr />

				<table id="bootstrap-table" class="table table-striped table-hover">
					<thead>
						<tr>
							<th><strong>Id</strong></th>
							<th><strong>Tema</strong></th>
							<th><strong>Status</strong></th>
							<th class="actions"><a class="btn btn-primary" href="#"
								data-toggle="modal" id="adicionarTema">Adicionar novo</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${temaList}" var="tema">
							<tr>
								<td>${tema.getId() }</td>
								<td>${tema.getTema() }</td>
								<td>${tema.getStatus() }</td>
								<td class="actions"><c:if
										test="${tema.getStatus() != 'APROVADO'}">
										<a class="btn btn-primary btn-xs"
											href="aprovar?id=${tema.getId()}">Aprovar</a>
									</c:if> <a class="btn btn-danger btn-xs" data-toggle="modal"
									id="${tema.getId()}" data-target="#delete-modal">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- END container -->

		</section>

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

		<!-- Modal -->
		<div class="modal fade" id="novoTema" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Adicionar Tema</h4>
					</div>
					<div class="modal-body" style="padding: 40px 50px;">
						<form role="form" action="adiciona" method="POST">
							<div class="form-group">
								<label for="tema">Tema</label> <input type="text"
									class="form-control" id="area" name="tema.tema"
									placeholder="Novo Tema"> <input type="hidden"
									name="matricula" value="${usuarioWeb.getMatricula() }">
								<input type="hidden" name="pagina" value="novo">
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

		<div id="delete-modal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Excluir Item</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este item?</div>
					<div class="modal-footer">
						<a type="submit" class="btn btn-primary" id="deletar">Sim</a> <a
							type="button" class="btn btn-default" data-dismiss="modal">Não</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- END wrapper -->

</body>
</html>
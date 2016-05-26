<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
						<h2>Minhas opções</h2>
					</div>
				</div>

				<hr />

				<c:if test="${empty candidatoList }">
					<p align="center">Você ainda não demonstrou interesse em
						realizar algum dos trabalhos disponíveis.</p>
					<div class="col-sm-7">
						<div class="btn-group pull-right">
							<a
								href="<c:url value="/candidato/criar?matricula=${usuarioWeb.getMatricula() }"/>"
								class="btn btn-primary h2 ">Adicionar novo</a>
						</div>
					</div>

				</c:if>

				<c:if test="${not empty candidatoList }">
					<table id="bootstrap-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th><strong>Título trabalho</strong></th>
								<th><strong>Prioridade</strong></th>
								<th><strong>Orientador</strong></th>
								<th><strong>Status</strong></th>
								<th class="actions">
									<c:if test="${candidatoList[0].getStatus() == 'ABERTO' }">
										<c:if test="${fn:length(candidatoList) lt 3}">
											<a href="<c:url value="/candidato/criar?matricula=${usuarioWeb.getMatricula() }"/>"
												class="btn btn-primary h2">Adicionar novo</a>
										</c:if>
									</c:if>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${candidatoList}" var="candidato">
								<tr>
									<td>${candidato.getTrabalho().getTitulo() }</td>
									<td>${candidato.getPrioridade() }</td>
									<td>${candidato.getTrabalho().getOrientador().getNome() }</td>
									<td>${candidato.getStatus() }</td>
									<c:if test="${candidato.getStatus() == 'ABERTO' }">
										<td class="actions"><a class="btn btn-danger btn-xs"
											data-toggle="modal" id="${candidato.getId()}"
											data-target="#delete-modal">Excluir</a></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<c:if test="${candidatoList[0].getStatus() == 'ABERTO' }">
						<div class="col-sm-7">
							<div class="btn-group pull-right">
								<a href="<c:url value="/candidato/salvar?matricula=${usuarioWeb.getMatricula() }"/>"
								class="btn btn-primary h2 ">Salvar Interesses</a>
							</div>
						</div>
					</c:if>

				</c:if>

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
						<h4 class="modal-title" id="myModalLabel">Excluir Interesse</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir sua
						candidatura para realizar o trabalho?</div>
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
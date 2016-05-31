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
						<h2>Solicitações abertas</h2>
					</div>
				</div>

				<hr />

				<c:if test="${empty solicitacaoList }">
					<p align="center">Você não possui nenhuma solicitação para
						compor uma banca.</p>
				</c:if>

				<c:if test="${not empty solicitacaoList }">
					<table id="bootstrap-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th><strong>Banca</strong></th>
								<th><strong>Professor solicitante</strong></th>
								<th><strong>Minha resposta</strong></th>
								<th class="actions"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${solicitacaoList}" var="solicitacao">
								<tr>
									<td>Banca ${solicitacao.getBanca().getId() }</td>
									<td>${solicitacao.getAbertoPor().getNome() }</td>
									<td>${solicitacao.getResposta() }</td>
									<td>
										<a class="btn btn-default btn-xs" data-toggle="modal"
											id="${solicitacao.getBanca().getId() }"
											data-target="#verBanca">Visualizar Banca</a> 
										<a class="btn btn-primary btn-xs" data-toggle="modal"
											id="${solicitacao.getId()}" data-target="#responder">Responder</a>
									</td>
								</tr>

								<!-- Modal -->
								<div class="modal fade" id="verBanca" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>Banca</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<label for="bancaId">Banca
													${solicitacao.getBanca().getId() }</label> 
													<br><br>
												<label><strong>Trabalho</strong></label>
												<p>${solicitacao.getBanca().getTrabalho().getTitulo() }</p>
												<label><strong>Data</strong></label>
												<p>${solicitacao.getBanca().getData() }</p>
											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-default btn-default"
													data-dismiss="modal">Cancelar</button>
												<a href="<c:url value="/trabalho/novo"/>"
													class="btn btn-link">Voltar</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</tbody>
					</table>

				</c:if>

			</div>
			<!-- END container -->

		</section>

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
		
			<div id="responder" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Responder solicitação</h4>
						</div>
						<div class="modal-body">Você tem disponibilidade para compor a banca solicitada?</div>
						<div class="modal-footer">
							<a type="submit" class="btn btn-primary" id="aceitar">Sim</a>
							<a type="submit" class="btn btn-primary" id="recusar">Não</a>
							<a type="button" class="btn btn-default" data-dismiss="modal">Cancelar</a>
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
							<h4 class="modal-title" id="myModalLabel">Excluir Perfil</h4>
						</div>
						<div class="modal-body">Deseja realmente excluir este perfil?</div>
						<div class="modal-footer">
							<a type="submit" class="btn btn-primary" id="deletar">Sim</a>
							<a type="button" class="btn btn-default" data-dismiss="modal">Não</a>
						</div>
					</div>
				</div>
			</div>

	</div>
	<!-- END wrapper -->

</body>
</html>
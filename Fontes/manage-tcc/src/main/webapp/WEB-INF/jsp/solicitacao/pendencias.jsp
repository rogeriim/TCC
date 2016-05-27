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
					<p align="center">Você ainda não abriu solicitações para encontrar professores para compor as bancas 
					de seus trabalhos disponibilizados.</p>
					<div class="col-sm-7">
						<div class="btn-group pull-right">
							<a
								href="<c:url value="/solicitacao/criar?matricula=${usuarioWeb.getMatricula() }"/>"
								class="btn btn-primary h2 ">Adicionar novo</a>
						</div>
					</div>

				</c:if>

				<c:if test="${not empty solicitacaoList }">
					<table id="bootstrap-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th><strong>Banca</strong></th>
								<th><strong>Professor</strong></th>
								<th><strong>Resposta</strong></th>
								<th class="actions">
									<a href="<c:url value="/candidato/criar?matricula=${usuarioWeb.getMatricula() }"/>"
												class="btn btn-primary h2">Adicionar novo</a>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${solicitacaoList}" var="solicitacao">
								<tr>
									<td>Banca ${solicitacao.getBanca().getId() }</td>
									<td>${solicitacao.getProfessor().getNome }</td>
									<td>${solicitacao.getResposta() }</td>
									<td class="actions"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</c:if>

			</div>
			<!-- END container -->

		</section>

		<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />

	</div>
	<!-- END wrapper -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>
	<body>
		<div id="wrapper"> <!-- START wrapper -->
	
			<jsp:include page="/WEB-INF/jsp/template/header.jsp" />
	
			<section id="container">
			
				<div class="container"> <!-- START container -->
	
					<div id="top" class="row">
						<div class="col-sm-6" align="center">
							<h2>Bancas</h2>
						</div>
					</div>
	
					<hr />
	
					<table id="bootstrap-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th><strong>Id</strong></th>
								<th><strong>Titulo Trabalho</strong></th>
								<th><strong>Orientando</strong></th>
								<th><strong>Data defesa</strong></th>
								<th><strong>Status</strong></th>
								<th class="actions"><a
									href="<c:url value="/banca/novo?matricula=${usuarioWeb.getMatricula()}"/>"
									class="btn btn-primary h2">Adicionar novo</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bancaList}" var="banca">
								<tr>
									<td>Banca ${banca.getId() }</td>
									<td>${banca.getTrabalho().getTitulo() }</td>
									<td>${banca.getTrabalho().getOrientando().getNome()  }</td>
									<td>${banca.getData()  }</td>
									<td>${banca.getStatus() }</td>
									<td class="actions">
										<c:if test="${banca.getStatus() == 'FECHADO' }"> 
											<a class="btn btn-primary btn-xs" href="ver?id=${banca.getId()}">Visualizar</a>
										</c:if>
										<c:if test="${banca.getStatus() == 'ABERTO' }"> 
											<a class="btn btn-primary btn-xs" 
												href="<c:url value="/solicitacao/criar?id=${banca.getId()}"/>" >Criar Solicitação</a>
											<a class="btn btn-primary btn-xs" href="fechar?id=${banca.getId()}">Fechar Banca</a>
											<a class="btn btn-primary btn-xs" href="editar?id=${banca.getId()}">Selecionar Avaliadores</a> 
											<a class="btn btn-danger btn-xs" data-toggle="modal" id="${banca.getId()}" data-target="#delete-modal">Excluir</a>
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
							<h4 class="modal-title" id="myModalLabel">Excluir Banca</h4>
						</div>
						<div class="modal-body">Deseja realmente excluir esta banca?</div>
						<div class="modal-footer">
							<a type="submit" class="btn btn-primary" id="deletar">Sim</a>
							<a type="button" class="btn btn-default" data-dismiss="modal">Não</a>
						</div>
					</div>
				</div>
			</div>
	
		</div> <!-- END wrapper -->
	
	</body>
</html>
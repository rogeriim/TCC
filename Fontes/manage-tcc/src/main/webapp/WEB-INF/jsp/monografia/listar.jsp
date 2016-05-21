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
							<h2>Monografias</h2>
						</div>
					</div>
	
					<hr />
	
					<table id="bootstrap-table" class="table table-striped table-hover">
						<thead>
							<tr>
								<th><strong>Título</strong></th>
								<th class="actions"><a
									href="<c:url value="/monografia/novo"/>"
									class="btn btn-primary h2">Adicionar novo</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${monografiaList}" var="monografia">
								<tr>
									<td>${monografia.getTrabalho().getTitulo() }</td>
									<td class="actions">
										<a class="btn btn-primary btn-xs" href="ver?id=${monografia.getId()}">Visualizar</a> 
										<a class="btn btn-primary btn-xs" href="editar?id=${monografia.getId()}">Editar</a> 
										<a class="btn btn-danger btn-xs" data-toggle="modal" id="${monografia.getId()}" data-target="#delete-modal">Excluir</a>
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
							<h4 class="modal-title" id="myModalLabel">Excluir Monografia</h4>
						</div>
						<div class="modal-body">Deseja realmente excluir esta monografia?</div>
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
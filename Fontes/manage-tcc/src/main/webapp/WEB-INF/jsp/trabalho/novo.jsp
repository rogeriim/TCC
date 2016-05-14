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

				<div id="top" class="row">
					<div class="col-sm-6" align="center">
						<h2>Adicionar Trabalho</h2>
					</div>
				</div>

				<hr />

				<form action="adiciona" method="POST">
					<div class="row">
						<div class="form-group col-sm-12">
							<label for="titulo">Titulo</label> <input class="form-control"
								id="titulo" name="trabalho.titulo">
						</div>
						<div class="form-group col-sm-12">
							<label for="tema">Tema</label>
							<div class="row">
								<div class="col-md-12 form-actions">
									<select class="btn btn-default" name="tema.id">
										<c:forEach items="${temaList}" var="tema">
											<option value="${tema.getId() }"> ${tema.getTema() }</option>
										</c:forEach>
										<option>Selecionar Tema</option>
									</select> <a class="btn btn-primary" href="#" data-toggle="modal"
										id="adicionarArea">Adicionar novo Tema</a>
								</div>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="descricao">Descrição</label>
							<textarea class="form-control" rows="10"
								id="descricao" name="trabalho.descricao"></textarea>
						</div>
					</div>

					<hr />

					<div class="row">
						<div class="col-md-12 form-actions">
							<button type="submit" class="btn btn-primary">Adicionar</button>
							<button type="reset" class="btn btn-default">Limpar</button>
							<a href="trabalhos.html" class="btn btn-link">Voltar</a>
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
	<div class="modal fade" id="novaArea" role="dialog">
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
							<label for="usrname">Tema</label> 
							<input type="text" class="form-control" id="area" name="tema.tema" placeholder="Novo Tema">
							<input type="hidden" name="pagina" value="novo">
						</div>
						<button type="submit" class="btn btn-primary btn-block">
							Adicionar</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default"
						data-dismiss="modal">Cancelar</button>
					<a href="<c:url value="/trabalho/novo"/>"  class="btn btn-link">Voltar</a>
				</div>
			</div>
		 </div>

		</div>
</body>

</html>

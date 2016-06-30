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
			
				<div class="container" >
					
					<h3 class="page-header">Matrícula ${usuario.getMatricula() }</h3>
  
					<div class="row">
						<div class="col-sm-12">
							<label><strong>Nome</strong></label>
							<p>${usuario.getNome() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
						<div class="col-sm-12">
							<label><strong>E-mail</strong></label>
							<p>${usuario.getEmail() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
						<div class="col-sm-12">
							<label><strong>Senha</strong></label>
							<p>${usuario.getSenha() }</p>
						</div>
						
						<div class="row">
							<div class="col-sm-12 breakline">
								<br>
							</div>
						</div>
						
					</div>
					
					<hr />
					
					<div class="col-md-12 form-actions">
						<a href="trabalhos.html" class="btn btn-link">Voltar</a>
					</div>
				
				</div> <!-- /#container -->
						
			</section>
			<!-- End Middle--> 
			
			<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
			
		</div>
		
	</body>
	
</html>

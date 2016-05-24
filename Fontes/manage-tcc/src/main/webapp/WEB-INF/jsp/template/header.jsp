<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header id="header">

	<div class="pageWidth">
		<h1 id="logo">
			<a href="#"><img src="../img/logo.png"
				title="Gerenciador de TCC | FACOM" /></a>
		</h1>
	</div>

	<c:if test="${(usuarioWeb.logado and !usuarioWeb.primeiroAcesso)}">
		<nav class="navbar navbar-default" role="navigation">
			<div class="pageWidth">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bar1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="bar1">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/trabalho/listar"/>" title="Trabalhos">Trabalhos</a></li>
						<li><a href="<c:url value="/monografia/listar"/>" title="Monografias">Monografias</a></li>
						<c:if test="${usuarioWeb.aluno }">
							<li><a href="<c:url value="/candidato/listar"/>" title="Candidaturas">Minhas opções</a></li>
						</c:if>
						<c:if test="${usuarioWeb.administrador }">
							<li><a href="<c:url value="/usuario/listar"/>" title="Usuários">Usuários</a></li>
							<li><a href="<c:url value="/perfil/listar"/>" title="Perfis">Perfis</a></li>
							<li><a href="<c:url value="/tema/listar"/>" title="Temas">Temas</a></li>
						</c:if>
						<c:if test="${usuarioWeb.professor || usuarioWeb.administrador }">
							<li><a href="<c:url value="/banca/listar"/>" title="Bancas">Bancas</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</c:if>

</header>
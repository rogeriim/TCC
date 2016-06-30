<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="br.com.tccmanager.controller.HomeController" %>
<%@ page import="br.com.caelum.vraptor.Result" %>

<jsp:include page="/WEB-INF/jsp/template/head.jsp" />

<html>
<body>
<%
	response.sendRedirect("../tccmanager/home/loginForm");
    /* result.redirectTo(HomeController.class).loginForm(); */
%>
</body>
</html>

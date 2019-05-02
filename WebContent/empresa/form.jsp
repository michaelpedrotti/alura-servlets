<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${ message }</p>

<!-- 	<form action="/alura/empresa/form" method="post"> -->

	<c:url value="/empresa/form" var="url" />
	<fmt:formatDate var="date" value="${empresa.createAt}" pattern="dd/MM/yyyy" />
	
	<form action="${url}" method="post">
		<input type="hidden" name="id" value="${empresa.id}">
		<p>Nome: <input type="text" name="name" value="${empresa.name}"></p>
		<p>Dt Cadastro: <input type="text" name="createAt" value="${date}"></p>
		<p><input type="submit" value="Salvar"></p>
	</form>

</body>
</html>
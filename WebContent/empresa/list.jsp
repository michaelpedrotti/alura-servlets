<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.empresas.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Standard Taglib</title>
<script type="text/javascript">

function add(){
	
	window.location='/alura/empresa/form';
}

function edit(){
	
	window.location='/alura/empresa/form?id=' + document.querySelector('input[name="id"]:checked').value;
}

function rem(){
	
	var form = document.forms['crud-form'];
	
	form['id'].value = document.querySelector('input[name="id"]:checked').value; 
	form.action = '/alura/empresa';
	form.submit();
}


</script>
</head>
<body>

	<form action="" method="post" name="crud-form">
		<input type="hidden" name="id" value="50" />
	</form>
	
	<p>${ message }</p>
	
	<%-- 
	<% List<Empresa> rows = (List<Empresa>)request.getAttribute("rows"); %>
	
	<table border="1" width="380">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt cadastro</th>
			</tr>
		</thead>
		<tbody>
			<% if(rows.isEmpty()){ %>
				<tr>
					<td colspan="2">Nenhum resultado foi localizado</td>
				</tr>
			<% } else { %>
				<% for(Empresa e : (List<Empresa>)request.getAttribute("rows")) { %>
					<tr>
						<td><%= e.getId() %></td>
						<td><%= e.getName() %></td>
					</tr>
				<% } %>
			<% } %>
		</tbody>
	</table>	
	--%>
	
	<%--
		core - controle de fluxo
		fmt = formatação / i18n
		sql = comandos sql
		xml = comandos xml
	--%>
	
	
	<div>
		<button type="button" onclick="add()">Cadastrar</button>			
		<button type="button" onclick="edit()">Editar</button>
		<button type="button" onclick="rem()">Remover</button>
	</div>

	<table border="1" width="380">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt cadastro</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty rows}">
				<tr>
					<td colspan="3">Nenhum resultado foi localizado</td>
				</tr>
			</c:if>
			<%-- Não tem else :( --%>
			<c:if test="${not empty rows}">
				<c:forEach var="row" items="${rows}">
					<fmt:formatDate value="${row.createAt}" var="createAt" type="date" pattern="dd/MM/yyyy" />
					<tr>
						<td>
							<input type="radio" name="id" value="${row.id}" />
						</td>
						<td>${row.name}</td>
						<td>${createAt}</td>
					</tr>
				</c:forEach>
			</c:if>		
		</tbody>
	</table>
	
	
	<%--
	<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
   	</c:forEach>
   	--%>

</body>
</html>
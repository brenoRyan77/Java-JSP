<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>

	<%@ page  import="com.crudjsp.dao.UsuarioDAO, com.crudjsp.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1>Lista de Usuários</h1>
	
	<%
	List<Usuario> lista = UsuarioDAO.listarUsuarios();
	request.setAttribute("lista", lista);
	%>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Idade</th>
			<th>Estado</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>	
			<c:forEach items="${lista}" var="usuario">
				<tr>
					<td>${usuario.getId()}</td>
					<td>${usuario.getNome()}</td>
					<td>${usuario.getEmail()}</td>
					<td>${usuario.getIdade()}</td>
					<td>${usuario.getEstado()}</td>
					<td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
					<td><a href="deleteusuario.jsp?id=${usuario.getId()}">Excluir</a></td>	
				</tr>
			</c:forEach>
	</table>
	<br>
	<a href="addusuarioform.jsp">Adicionar novo Usuário</a>
</body>
</html>
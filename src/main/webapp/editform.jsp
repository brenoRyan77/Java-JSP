<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuários</title>
</head>
<body>

	<%@ page import="com.crudjsp.bean.Usuario, com.crudjsp.dao.UsuarioDAO" %>
	
	<%
		String id = request.getParameter("id");
		Usuario usuario = UsuarioDAO.obterRegistroId(Integer.parseInt(id));
	%>
	
	<h1>Editar Usuário</h1>
	
	<form action="editusuario.jsp" method="post">
		<input type="hidden" name="id" value="<%=usuario.getId()%>"/>
		<table >
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%=usuario.getNome() %>"></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="email" name="email" value="<%=usuario.getEmail() %>"></td>
			</tr>
			<tr>
				<td>Idade: </td>
				<td><input type="number" name="idade" value="<%=usuario.getIdade() %>"></td>
			</tr>
			<tr>
				<td>Estado: </td>
				<td><input type="text" name="estado" value="<%=usuario.getEstado() %>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Editar"></td>
			</tr>
			
		</table>
		
			
	</form>
	<a href="viewusuarios.jsp"><button>Voltar</button></a>

</body>
</html>
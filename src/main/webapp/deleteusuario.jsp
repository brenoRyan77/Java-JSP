<%@ page import="com.crudjsp.dao.UsuarioDAO"%>
<jsp:useBean id="u" class="com.crudjsp.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<% 
	UsuarioDAO.deletarUsuario(u);
	response.sendRedirect("viewusuarios.jsp");
%>
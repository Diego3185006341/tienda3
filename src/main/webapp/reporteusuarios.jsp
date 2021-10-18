<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="modelo.UsuarioDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->



<%@page import="modelo.UsuarioDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="reportes.jsp">Reportes</a></li>
    <li class="breadcrumb-item active" aria-current="page">Listado de Usuarios</li>
  </ol>
</nav>
<br>
<br>
<h3>Listado de Usuarios</h3>
  
<%
List<UsuarioDTO> lista=UsuarioDAO.consultar();
request.setAttribute("lista",lista);
%>

<table  class="table">
<thead class="table-dark"><th>Cedula</th><th>Nombre</th><th>Correo electónico</th><th>Usuario</th><th>Password</th></thead>
<c:forEach items="${lista}" var="usu">
<tr><td><strong>${usu.getCedula_usuario()}</strong></td><td>${usu.getNombre_usuario()}</td><td>${usu.getEmail_usuario()}</td>
<td>${usu.getUsuario()}</td><td>${usu.getPassword()}</td>

</tr>
</c:forEach>
</table>
<!-- fin contenido  -->


<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />

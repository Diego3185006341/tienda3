<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->


<%@page import="modelo.ClientesDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="reportes.jsp">Reportes</a></li>
    <li class="breadcrumb-item active" aria-current="page">Listado de Clientes</li>
  </ol>
</nav>
<br>
<br>
<h3>Listado de Clientes</h3>
  
<%
List<ClientesDTO> lista=ClientesDAO.consultar();
request.setAttribute("lista",lista);
%>

<table  class="table">
<thead class="table-dark"><th>Cedula</th><th>Nombre</th><th>Correo Electrónico</th><th>Dirección</th><th>Teléfono</th></thead>
<c:forEach items="${lista}" var="cldo">
<tr><td><strong>${cldo.getCedula_cliente()}</strong></td><td>${cldo.getNombre_cliente()}</td><td>${cldo.getEmail_cliente()}</td>
<td>${cldo.getDireccion_cliente()}</td><td>${cldo.getTelefono_cliente()}</td>

</tr>
</c:forEach>
</table>

<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
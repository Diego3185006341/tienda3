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
    <li class="breadcrumb-item active" aria-current="page">Total de ventas por Cliente</li>
  </ol>
</nav>
<br>
<br>

<h3>Total de ventas por Cliente</h3>
  
<%
List<VentasReporteDTO> lista=VentasDAO.reporteventas();
request.setAttribute("lista",lista);

Double totalventas = VentasDAO.totalventas();

%>

<table  class="table">
<thead class="table-dark"><th>Cedula</th><th>Nombre</th><th>Valor Total Ventas</th></thead>
<c:forEach items="${lista}" var="cldo">
<tr><td><strong>${cldo.getCedula_cliente()}</strong></td><td>${cldo.getNombre_cliente()}</td><td>${cldo.getTotal_ventas()}</td>

</tr>
</c:forEach>
</table>
<br>
<br>
<table  class="table">
<tr>

<td>&nbsp;</td>
<td><h4>Total ventas $</h4></td>

<td><input type="number" name="total" value="<%=totalventas%>"
								placeholder="Total ventas" disabled /></td>

</tr>

</table>


<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
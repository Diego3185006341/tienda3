<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->

<%
	
//Conexion con=new Conexion();
//con.conexiondb();
String d="",u="",c="",r="",e="";
if(request.getParameter("do")!=null){
d=request.getParameter("do");
u=request.getParameter("us");
c=request.getParameter("cl");
r=request.getParameter("ro");
e=request.getParameter("es");
}
%>
<div class= "usuario">
<form action="servletcliente" method="post">

<table width="55%" align="center" class="table">
  <thead>
    <tr>
      <th colspan="5" scope="col"><center>
        <h5>Formulario de  Registro Clientes</h5></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th colspan="5" scope="row"><input type="submit" name="btnins" value="Registrar" class="btn btn-primary" />
        <input type="submit" name="btncon" value="Consultar" class="btn btn-secondary" />
        <input type="submit" name="btnact" value="Actualizar" class="btn btn-success" />
        <input type="submit" name="btneli" value="Eliminar" class="btn btn-danger" onclick="return confirm('¿Seguro quiere borrar?, esta acción no se puede deshacer.')"/></th>
    </tr>
    <tr>
      <th scope="row">Cedula Cliente</th>
      <td>direccion cliente</td>
      <td>email cliente</td>
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="number" name="cedula_cliente"  value="<%=d%>" placeholder = " # CEDULA" required/></th>
      <td><input type="text" name="direccion"  value="<%=u%>"placeholder = "direccion" /></td>
      <td><input type="text" name="email"  value="<%=c%>"placeholder = "email" /></td>
      </tr>
    <tr>
      <th width="36%" scope="row">nombre cliente</th>
      <td width="28%">telefono cliente</td>
      <td width="25%">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="nombre"  value="<%=r%>" placeholder = " # NOMBRE COMPLETO" /></th>
      <td><input type="text" name="telefono"  value="<%=e%>"placeholder = "telefono" /></td>
      <td>&nbsp;</td>
      </tr>
    <tr>
      <th scope="row">&nbsp;</th>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      </tr>
  </tbody>
</table>


</form>
</div>


<div class="row">

	<c:set var="mensaje_error" value="${requestScope.mensaje_error}" />
	<c:if test="${not empty mensaje_error}">
		<div class="alert alert-danger alert-dismissible">
			<p>${mensaje_error}</p>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_success" value="${requestScope.mensaje_success}" />
	<c:if test="${not empty mensaje_success}">
		<div class="alert alert-success alert-dismissible">
			<p>${mensaje_success}</p>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_warning" value="${requestScope.mensaje_warning}" />
	<c:if test="${not empty mensaje_warning}">
		<div class="alert alert-warning alert-dismissible">
			<p>${mensaje_warning}</p>
		</div>
	</c:if>

</div>


<%@page import="modelo.ClientesDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>LISTADO DE CLIENTES</h3>
  
<%
List<ClientesDTO> lista=ClientesDAO.consultar();
request.setAttribute("lista",lista);
%>

<table  class="table">
<thead class="table-dark"><th>Identificación</th><th>Nombre</th><th>Email</th><th>Dirección</th><th>Teléfono</th></thead>
<c:forEach items="${lista}" var="cldo">
<tr><td><strong>${cldo.getCedula_cliente()}</strong></td><td>${cldo.getNombre_cliente()}</td><td>${cldo.getEmail_cliente()}</td>
<td>${cldo.getDireccion_cliente()}</td><td>${cldo.getTelefono_cliente()}</td>

</tr>
</c:forEach>
</table>

<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
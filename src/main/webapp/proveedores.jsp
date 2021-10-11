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
<form action="servletproveedores" method="post">

<table width="55%" align="center" class="table">
  <thead>
    <tr>
      <th colspan="5" scope="col"><center>
        <h5>Formulario de Registro de Proveedores</h5></th>
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
      <th scope="row">Nit Proveedor</th>
      <td>Ciudad Proveedor</td>
      <td>Dirección Proveedor</td>
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="number" name="nitproveedor"  value="<%=d%>" placeholder = "NIT" required/></th>
      <td><input type="text" name="ciudad_proveedor"  value="<%=u%>"placeholder = "Ciudad" /></td>
      <td><input type="text" name="direccion_proveedor"  value="<%=c%>"placeholder = "Dirección" /></td>
      </tr>
    <tr>
      <th width="36%" scope="row">Nombre Proveedor</th>
      <td width="28%">Teléfono Proveedor</td>
      <td width="25%">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="nombre_proveedor"  value="<%=r%>" placeholder = "NOMBRE" /></th>
      <td><input type="text" name="telefono_proveedor"  value="<%=e%>"placeholder = "Teléfono" /></td>
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
		
		
<%@page import="modelo.ProveedoresDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>LISTADO DE PROVEEDORES</h3>
  
<%
List<ProveedoresDTO> lista=ProveedoresDAO.consultar();
request.setAttribute("lista",lista);
%>

<table  class="table">
<thead class="table-dark"><th>Nit</th><th>Nombre</th><th>Ciudad</th><th>Dirección</th><th>Teléfono</th></thead>
<c:forEach items="${lista}" var="pvdo">
<tr><td><strong>${pvdo.getnitproveedor()}</strong></td><td>${pvdo.getnombre_proveedor()}</td><td>${pvdo.getciudad_proveedor()}</td>
<td>${pvdo.getdireccion_proveedor()}</td><td>${pvdo.gettelefono_proveedor()}</td>

</tr>
</c:forEach>
</table>
		
<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
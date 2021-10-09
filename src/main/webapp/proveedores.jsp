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
        <input type="submit" name="btneli" value="Eliminar" class="btn btn-danger" /></th>
    </tr>
    <tr>
      <th scope="row">Nit Proveedor</th>
      <td>Ciudad Proveedor</td>
      <td>Direccion Proveedor</td>
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="nitproveedor"  value="<%=d%>" placeholder = " # CEDULA" /></th>
      <td><input type="text" name="ciudad_proveedor"  value="<%=u%>"placeholder = "ciudad_proveedor" /></td>
      <td><input type="text" name="direccion_proveedor"  value="<%=c%>"placeholder = "direccion_proveedor" /></td>
      </tr>
    <tr>
      <th width="36%" scope="row">nombre cliente</th>
      <td width="28%">telefono cliente</td>
      <td width="25%">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="nombre_proveedor"  value="<%=r%>" placeholder = " # NOMBRE COMPLETO" /></th>
      <td><input type="text" name="telefono_proveedor"  value="<%=e%>"placeholder = "telefono_proveedor" /></td>
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
		
		
<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
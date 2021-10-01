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
        <input type="submit" name="btneli" value="Eliminar" class="btn btn-danger" /></th>
    </tr>
    <tr>
      <th scope="row">Cedula Cliente</th>
      <td>direccion cliente</td>
      <td>email cliente</td>
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="cedula_cliente"  value="<%=d%>" placeholder = " # CEDULA" /></th>
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

<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
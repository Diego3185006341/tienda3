<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="modelo.UsuarioDAO,modelo.*,java.util.*"%>  
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
<form action="servletusuario" method="post">

<table width="55%" align="center" class="table">
  <thead>
    <tr>
      <th colspan="5" scope="col"><center>
        <h5>Formulario de  Registro Usuarios</h5></th>
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
      <th scope="row">Cedula</th>
      <td>email</td>
      <td>nombre</td>
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="text" name="cedula"  value="<%=d%>" placeholder = " # CEDULA" /></th>
      <td><input type="text" name="email"  value="<%=u%>"placeholder = "email" /></td>
      <td><input type="text" name="nombre"  value="<%=c%>"placeholder = "nombre" /></td>
      </tr>
    <tr>
      <th width="36%" scope="row">password</th>
      <td width="28%">usuario</td>
      <td width="25%">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="password" name="password"  value="<%=r%>" placeholder = " # password" /></th>
      <td><input type="text" name="usuario"  value="<%=e%>"placeholder = "usuario" /></td>
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

<h3>LISTADO DE USUARIOS</h3>  
  
<%  
List<UsuarioDTO> lista=UsuarioDAO.consultar();  
request.setAttribute("lista",lista);  
%>  
  
<table  class="table">  
<thead class="table-dark"><th>Identificación</th><th>email usuario</th><th>nombre usuario</th><th>usuario</th></thead>  
<c:forEach items="${lista}" var="usu">  
<tr><td><strong>${usu.getCedula_usuario()}</strong></td><td>${usu.getEmail_usuario()}</td><td>${usu.getNombre_usuario()}</td>  
<td>${usu.getUsuario()}</td> 




</tr>  
</c:forEach>  
</table>
<!-- fin contenido  -->
				
				
<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
	
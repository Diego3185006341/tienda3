<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->

<%
//Conexion con=new Conexion();
//con.conexiondb();
String cedula = "", cliente = "", consecut = "", c1 = "", c2 = "", c3 = "",n1="",n2="",n3="";
double vr_total1=0,vr_total2=0,vr_total3=0,totalventa=0,ivaventa=0,total_con_iva;
int cant1=0,cant2=0,cant3=0;
if (request.getParameter("cedula") != null) {
	cedula = request.getParameter("cedula");
	consecut = request.getParameter("consecut");
	c1 = request.getParameter("codigo1");
	c2 = request.getParameter("es");
	c3= request.getParameter("av");
	cliente=request.getParameter("nombre");
	n1=request.getParameter("nombre_producto1");
	vr_total1=Double.parseDouble(request.getParameter("vr_total1"));
	cant1=Integer.parseInt(request.getParameter("cantidad1"));
}
%>
<div class="usuario">
	<form action="servletventas" method="post">

		<table width="60%"  >
			<thead>
				<tr>
					<th colspan="5" scope="col"><center>
							<h2>Formulario  ventas</h2></th>
				</tr>
			</thead>
			<tbody>
				
				<table class="table">
				<thead class="table-light">
					<th >cedula</th>
					
					<th>cliente</th>
					<th>consecutivo</th>
					<th> clientes</th>
					
				
				<tr>
					<th scope="row"><input type="number" name="cedula"value="<%=cedula%>" placeholder=" # cedula" required/></th>
				
					<td><input type="text" name="cliente" value="<%=cliente%>"placeholder="cliente" disabled /></td>
					<td><input type="text" name="consect" value="<%=consecut%>"placeholder="consect" disabled /></td>
						<td><button name="consultar_cliente" align="left"type="submit" class="btn btn-secondary">consultar</button></td>	
				</tr>
				
				</thead>
				</table>
				<br>
				<br>
				
		<table class="table">
			<thead class="table-light">
				<th>Código</th>
				<th></th>
				<th>nombre producto</th>
				<th>cantidad</th>
				<th>Ivr total</th>
				
						
					<tr>
						<th scope="row"><input type="text" name="codigo_producto1"value="<%=c1%>" placeholder="codigo producto" /></th>
						<td><input type="submit"name="consultarp1" value="Consultar" class="btn btn-secondary" /></td>		
						<td><input type="text" name="nombre_producto" value="<%=n1%>"placeholder="nombre producto" /></td>
						<td><input type="text" name="cantidad1" value="<%=cant1%>"placeholder="cant" /></td>
						<td><input type="text" name="total" value="<%=vr_total1%>"placeholder="vr total" /></td>
							
					</tr>
				
					
				
					<tr>
						<th scope="row"><input type="text" name="codigo_producto2"value="<%=c2%>" placeholder="codigo producto" /></th>
						<td><input type="submit"name="consultarp2" value="Consultar" class="btn btn-secondary" /></td>		
						<td><input type="text" name="nombre_producto2" value="<%=n2%>"placeholder="nombre producto" /></td>
						<td><input type="text" name="cantidad2" value="<%=cant2%>"placeholder="cant" /></td>
						<td scope="row"><input  type="text" name="total" value="<%=vr_total2%>"placeholder="vr total" /></td>
						
					</tr>
					<tr>
					<th scope="row"><input type="text" name="codigo_producto3"value="<%=c3%>" placeholder="codigo producto" /></th>	
					<td><input type="submit"name="consultarp3" value="Consultar" class="btn btn-secondary" /></td>
						<td><input type="text" name="nombre_producto2" value="<%=n3%>"placeholder="nombre producto" /></td>
						<td><input type="text" name="cantidad3" value="<%=cant3%>"placeholder="cant" /></td>
						<td><input type="text" name="total" value="<%=vr_total3%>"placeholder="vr total" /></td>
						
					
					</tr>
					</table>
					<br>
					<table class="table">
				<thead class="table-light">
					<th >total venta</th>
				
					<th>total iva</th>
					<th>total con iva</th>
					<th> venta total</th>
					
				
				<tr>
					<th scope="row"><input type="number" name="totalventa"value="<%=c1%>" placeholder=" # total venta" /></th>
					
					<td><input type="text" name="totaliva" value="<%=n1%>"placeholder="total iva" /></td>
					<td><input type="text" name="total_con_iva" value="<%=c3%>"placeholder="total con iva" /></td>
					<td><button align="left"type="submit" class="btn btn-secondary btn-lg">confirmar</button></td>	
				</tr>
				
				</thead>
				</table>
			
			</tbody>
		</table>


	</form>
	<br>

</div>



<br>

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

<%@page import="modelo.ProductosDAO,modelo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>LISTADO DE PRODUCTOS</h3>

<%
List<ProductosDTO> lista = ProductosDAO.consultar();
request.setAttribute("lista", lista);
%>

<table class="table">
	<thead class="table-dark">
		<th>Código</th>
		<th>Nombre</th>
		<th>Nit Proveedor</th>
		<th>Precio compra</th>
		<th>Iva compra</th>
		<th>Precio venta</th>
	</thead>
	<c:forEach items="${lista}" var="prod">
		<tr>
			<td><strong>${prod.getCodigo_productos()}</strong></td>
			<td>${prod.getNombre_producto()}</td>
			<td>${prod.getNitproveedor()}</td>
			<td>${prod.getPrecio_compra()}</td>
			<td>${prod.getIvacompra()}</td>
			<td>${prod.getPrecio_venta()}</td>

		</tr>
	</c:forEach>
</table>
<!-- fin contenido  -->


<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
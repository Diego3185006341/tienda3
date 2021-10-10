<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->

<%
//Conexion con=new Conexion();
//con.conexiondb();
String d = "", u = "", c = "", r = "", e = "", a = "";
if (request.getParameter("do") != null) {
	d = request.getParameter("do");
	u = request.getParameter("us");
	c = request.getParameter("cl");
	r = request.getParameter("ro");
	e = request.getParameter("es");
	a = request.getParameter("av");
}
%>
<div class="usuario">
	<form action="servletproductos" method="post">

		<table width="55%" align="center" class="table">
			<thead>
				<tr>
					<th colspan="5" scope="col"><center>
							<h2>Formulario de Registro de Productos</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="5" scope="row"><input type="submit" name="btnins"
						value="Registrar" class="btn btn-primary" /> <input type="submit"
						name="btncon" value="Consultar" class="btn btn-secondary" /> <input
						type="submit" name="btnact" value="Actualizar"
						class="btn btn-success" /> <input type="submit" name="btneli"
						value="Eliminar" class="btn btn-danger" /></th>
				</tr>
				<tr>
					<th scope="row">codigo producto</th>
					<td>iva compra</td>
					<td>nit Proveedor</td>
					<td width="11%" colspan="2" rowspan="5">&nbsp;</td>
				</tr>
				<tr>
					<th scope="row"><input type="text" name="codigo_producto"
						value="<%=d%>" placeholder=" # codigo" /></th>
					<td><input type="text" name="ivacompra" value="<%=u%>"
						placeholder="iva" /></td>
					<td><input type="text" name="nit_proveedor" value="<%=c%>"
						placeholder="nit" /></td>
				</tr>
				<tr>
					<th width="36%" scope="row">nombre producto</th>
					<td width="28%">precio compra</td>
					<td width="25%">precio venta</td>
				</tr>
				<tr>
					<th scope="row"><input type="text" name="nombre_producto"
						value="<%=r%>" placeholder="Nombre proveedor" /></th>
					<td><input type="text" name="precio_compra" value="<%=e%>"
						placeholder="Precio compra" /></td>
					<td><input type="text" name="precio_venta" value="<%=a%>"
						placeholder="Precio venta" /></td>
				</tr>
				<tr>
					<th scope="row">&nbsp;</th>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>


	</form>
	<br>

</div>
<!-- <div class="row" align="center"> -- TODO: Para sprint 4
	<h2>Cargar masiva por archivo .csv</h2>
	<form action="servletproductos" method="post"
		enctype="multipart/form-data">

		<input type="file" name="file" accept=".csv" class="btn btn-primary" />
		<input type="submit" name="btn_archivo" value="cargar archivo csv"
			class="btn btn-primary" />
	</form>
</div> -->


<br>

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->

<%
//Conexion con=new Conexion();
//con.conexiondb();
String cedula = "", cliente = "", consecut = "", c1 = "", c2 = "", c3 = "", n1 = "", n2 = "", n3 = "";
String mensaje_error = "", mensaje_success = "", mensaje_warning = "";
double vr_total1 = 0, vr_total2 = 0, vr_total3 = 0, totalventa = 0, totaliva = 0, total_con_iva = 0;
int cant1 = 0, cant2 = 0, cant3 = 0;
if (request.getParameter("cedula") != null) {
	cedula = request.getParameter("cedula");
	consecut = request.getParameter("consecut");
	c1 = request.getParameter("codigo1");
	c2 = request.getParameter("codigo2");
	c3 = request.getParameter("codigo3");
	cliente = request.getParameter("cliente");
	n1 = request.getParameter("nombre_producto1");
	n2 = request.getParameter("nombre_producto2");
	n3 = request.getParameter("nombre_producto3");
	vr_total1 = Double.parseDouble(request.getParameter("vr_total1"));
	vr_total2 = Double.parseDouble(request.getParameter("vr_total2"));
	vr_total3 = Double.parseDouble(request.getParameter("vr_total3"));
	cant1 = Integer.parseInt(request.getParameter("cantidad1"));
	cant2 = Integer.parseInt(request.getParameter("cantidad2"));
	cant3 = Integer.parseInt(request.getParameter("cantidad3"));
	totalventa = Double.parseDouble(request.getParameter("totalventa"));
	totaliva = Double.parseDouble(request.getParameter("totaliva"));
	total_con_iva = Double.parseDouble(request.getParameter("total_con_iva"));
}

if (request.getParameter("mensaje_error") != null) {
	mensaje_error = request.getParameter("mensaje_error");
}
if (request.getParameter("mensaje_success") != null) {
	mensaje_success = request.getParameter("mensaje_success");
}
if (request.getParameter("mensaje_warning") != null) {
	mensaje_warning = request.getParameter("mensaje_warning");
}
%>
<div class="usuario">
	<form action="servletventas" method="post">

		<table width="100%">
			<thead>
				<tr>
					<th colspan="5" scope="col"><center>
					<br> <br>
							<h1>Formulario ventas</h1></th>
				</tr>
			</thead>
			<tbody>

				<table class="table">
					<thead class="table-light">
						<th>cedula</th>

						<th>cliente</th>
						<th>consecutivo</th>
						<th>clientes</th>


						<tr>
							<th scope="row"><input type="number" name="cedula"
								value="<%=cedula%>" placeholder=" # cedula" required /></th>

							<td><input type="text" name="cliente" value="<%=cliente%>"
								placeholder="cliente" disabled /></td>
							<td><input type="text" name="consect" value="<%=consecut%>"
								placeholder="consect" disabled /></td>
							<td><button name="consultar_cliente" align="left"
									type="submit" class="btn btn-secondary">consultar</button></td>
						</tr>

					</thead>
				</table>
				<br>
				<br>

				<table class="table">
					<thead class="table-light">
						<th>Código</th>
						<th>nombre producto</th>
						<th>cantidad</th>
						<th>Ivr total</th>


						<tr>
							<th scope="row"><input type="number" name="codigo_producto1"
								value="<%=c1%>" placeholder="codigo producto" /></th>
							<td><input type="text" name="nombre_producto"
								value="<%=n1%>" placeholder="nombre producto" disabled /></td>
							<td><input type="number" name="cantidad1" value="<%=cant1%>"
								placeholder="cant" /></td>
							<td><input type="number" name="total" value="<%=vr_total1%>"
								placeholder="vr total" disabled /></td>

						</tr>

						<tr>
							<th scope="row"><input type="number" name="codigo_producto2"
								value="<%=c2%>" placeholder="codigo producto" /></th>
							<td><input type="text" name="nombre_producto2"
								value="<%=n2%>" placeholder="nombre producto" disabled /></td>
							<td><input type="number" name="cantidad2" value="<%=cant2%>"
								placeholder="cant" /></td>
							<td scope="row"><input type="number" name="total"
								value="<%=vr_total2%>" placeholder="vr total" disabled /></td>

						</tr>
						<tr>
							<th scope="row"><input type="number" name="codigo_producto3"
								value="<%=c3%>" placeholder="codigo producto" /></th>
							<td><input type="text" name="nombre_producto2"
								value="<%=n3%>" placeholder="nombre producto" disabled /></td>
							<td><input type="number" name="cantidad3" value="<%=cant3%>"
								placeholder="cant" /></td>
							<td><input type="number" name="total" value="<%=vr_total3%>"
								placeholder="vr total" disabled /></td>


						</tr>

						<tr>
							<td><input type="submit" name="consultarp"
								value="Consultar y calcular productos" class="btn btn-secondary" /></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
				</table>
				<br>
				<table class="table">
					<thead class="table-light">
						<th>total venta</th>

						<th>total iva</th>
						<th>total con iva</th>
						<th>venta total</th>


						<tr>
							<th scope="row"><input type="number" name="totalventa"
								value="<%=totalventa%>" placeholder=" # total venta" disabled /></th>

							<td><input type="number" name="totaliva" value="<%=totaliva%>"
								placeholder="total iva" disabled /></td>
							<td><input type="number" name="total_con_iva"
								value="<%=total_con_iva%>" placeholder="total con iva" disabled /></td>
							<td><button align="left" type="submit" name="btnconfirm"
									class="btn btn-secondary btn-lg">Confirmar</button></td>
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

	<c:set var="mensaje_error" value="<%=mensaje_error%>" />
	<c:if test="${not empty mensaje_error}">
		<div class="alert alert-danger alert-dismissible">
			<p>${mensaje_error}</p>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_success" value="<%=mensaje_success%>" />
	<c:if test="${not empty mensaje_success}">
		<div class="alert alert-success alert-dismissible">
			<p>${mensaje_success}</p>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p align="center">
					<a href="ventas.jsp"><button align="center" type="submit"
							class="btn btn-success btn-lg">Registrar otra venta</button></a>
				</p>
			</div>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_warning" value="<%=mensaje_warning%>" />
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
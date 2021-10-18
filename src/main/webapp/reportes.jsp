<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->


<main class="row">

	<div class="row">

		<div class="col-md-12">

			<h2>REPORTES</h2>
			<br> <br>

		</div>

	</div>


	<div class="row">

		<div class="col-md-12">

			<a href="reporteusuarios.jsp" class="btn btn-primary">Listado de
				Usuarios</a> <br> <br>

		</div>

	</div>



	<div class="row">

		<div class="col-md-12">

			<a href="reporteclientes.jsp" class="btn btn-primary">Listado de
				Clientes</a> <br> <br>

		</div>

	</div>

	<br>

	<div class="row">

		<div class="col-md-12">

			<a href="reporteventas.jsp" class="btn btn-primary">Ventas por
				Cliente</a>

		</div>

	</div>



</main>

<!-- fin contenido  -->


<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
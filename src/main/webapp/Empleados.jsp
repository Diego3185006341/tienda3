<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLEADOS</title>
<link rel="stylesheet" href="css/estilos_1.css">
<link rel="stylesheet" href="css/estilos_2.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	
	
	
<!-- CAPA CONTENEDORA PRINCIPAL -->
<div id="main-content">
		<!-- CAPA CONTENEDORA CABEZOTE WEB -->
		<header id="header">
			<jsp:include page="encabezado.jsp" />
			Bienvenido ${sessionScope.usuario.nombre}
		</header>
		
		<!-- CAPA CONTENEDORA MENU DE NAVEGACION WEB -->
		<nav id="nav">
				<nav class="navbar navbar-expand-lg navbar-light bg-info">
				  <div class="container-fluid">
				    <a class="navbar-brand" href="#">Menu Tienda</a>
				    <div class="collapse navbar-collapse" id="navbarSupportedContent">
				      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				        <li class="nav-item">
				          <a style="margin-left:10px; border:none" class="btn btn-outline-light" aria-current="page" href="principal.jsp">Inicio</a>
				        </li>
				        <li class="nav-item">
				          <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Productos.jsp">Productos</a>
				        </li>
				        <li class="nav-item">
				          <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Empleados.jsp">Empleados</a>
				        </li>
				        <li class="nav-item">
				          <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Clientes.jsp">Clientes</a>
				        </li>
				        <li class="nav-item">
				          <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="RegistrarVenta.jsp">Nueva Venta</a>
				        </li>
				        </ul>
				    </div>
				  </div>
			</nav>
		</nav>

		<!-- CAPA CONTENEDORA CONTENIDO CENTRAL - WEB -->
			<h5>FORMULARIO EMPLEADOS</h5>
<div class="d-flex">
				<div class="card" col-sm-6>
				<div class="card-body">
					<form>
						<div class="form-group">
							<label>DNI</label>
							<input type="text" name="txtDni" class="form-control">
						</div>
						<div class="form-group">
							<label>Nombres</label>
							<input type="text" name="txtNombres" class="form-control">
						</div>
						<div class="form-group">
							<label>Telefono</label>
							<input type="text" name="txtTel" class="form-control">
						</div>
						<div class="form-group">
							<label>Estado</label>
							<input type="text" name="txtestado" class="form-control">
						</div>
						<div class="form-group">
							<label>Usuario</label>
							<input type="text" name="txtUsuario" class="form-control">
						</div>
						<input type="submit" name="accion" value="Agregar" class="btn btn-info">
					</form>
				</div>
			</div>				
<div class="col-sm-8">
<table class="table table-hover">
  <thead class="thead-dark">
  <tr>
      <th scope="col">DNI</th>
      <th scope="col">NOMBRES</th>
      <th scope="col">TELEFONO</th>
      <th scope="col">ESTADO</th>
      <th scope="col">USER</th>
      <th scope="col">ACCIONES</th>
  </tr>
  </thead>
  <tbody>
  <tr>
  	<td>001</td>
    <td>FREDY ALEXANDER CASTELLANOS AVILA</td>
    <td>630-4182926</td>
    <td>ACTIVO</td>
    <td>facastellanos</td>
    <td>Editar - Eliminar</td>
  </tr>
    <tr>
  	<td>002</td>
    <td>NANCY BRISEIDA SANABRIA</td>
    <td>430-7182927</td>
    <td>ACTIVO</td>
    <td>Nsananbria</td>
    <td>Editar - Eliminar</td>
  </tr>
      <tr>
  	<td>003</td>
    <td>VALERY CAMILA CASTELLANOS R.</td>
    <td>620-7182927</td>
    <td>ACTIVO</td>
    <td>Wawita728</td>
    <td>Editar - Eliminar</td>
  </tr>
  </tbody>
</table>
</div>	
</div>
			
			
		

        
        <footer id="footer">
			<p>Pie de pagina</p>
        </footer>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<meta name=viewport content="width=device-width,initial-scale=1">
<meta http-equiv=X-UA-Compatible content="IE=edge">
<title>Tienda genérica</title>
<link rel="stylesheet" href="css/tienda_login.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body class="bg-image">

	<div class="containerlogin">
		<div class="container">
			<div class="row">
				<div
					class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
					<div class="row">
						<div class="col-lg-6 col-md-8 mx-auto">

							<!-- form card login -->
							<div class="card rounded shadow shadow-sm">

								<div class="card-body">
									<form class="form" role="form" autocomplete="off"
										id="formLogin" novalidate="" action="usuario" method="POST">
										<input type="hidden" name="tipo" value="iniciarSesion" />
										<div class="form-group">
											<label for="nombre">Usuario</label> <input type="text"
												class="form-control form-control-lg rounded-0" name="nombre"
												placeholder="Nombre de usuario" required="">
											<div class="invalid-feedback">Ingresa tu nombre de
												usuario.</div>
										</div>
										<div class="form-group">
											<label for="clave">Contraseña</label> <input type="password"
												class="form-control form-control-lg rounded-0" name="clave"
												required="" placeholder="Contraseña"
												autocomplete="new-password">
											<div class="invalid-feedback">¡Ingresa tu contraseña
												también!</div>
										</div>
										<div>
											<br>
										</div>

										<c:set var="mensaje" value="${requestScope.mensaje}" />
										<c:if test="${not empty mensaje}">
											<div class="alert alert-danger alert-dismissible">
												<p>${mensaje}</p>
											</div>
										</c:if>
										<p align="right">
											<button type="submit"
												class="btn btn-primary btn-lg float-right" id="btnLogin">Iniciar
												sesión</button>
										</p>
									</form>
								</div>
								<!--/card-block-->
							</div>
							<!-- /form card login -->

						</div>

					</div>
					<!--/row-->

					<br>

					<div class="row">
						<h1 style="text-align: center; color: white;">Proyecto tienda
							genérica</h1>
						<h2 style="text-align: center; color: white;">misiontic2022 -
							Universidad El Bosque</h2>
						<h2 style="text-align: center; color: white;">ciclo 3, grupo
							40, equipo 05</h2>

					</div>

				</div>
				<!--/col-->
			</div>
			<!--/row-->
		</div>
		<!--/container-->

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="js/tienda_login.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<meta name=viewport content="width=device-width,initial-scale=1">
<meta http-equiv=X-UA-Compatible content="IE=edge">
<title>Tienda genérica</title>
<link rel="stylesheet" href="css/estilos_2.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<div class="container-fluid overflow-hidden">
		<div class="row vh-100 overflow-auto">
			<div
				class="col-12 col-sm-3 col-xl-2 px-sm-2 px-0 bg-dark d-flex sticky-top">
				<div
					class="d-flex flex-sm-column flex-row flex-grow-1 align-items-center align-items-sm-start px-3 pt-2 text-white">
					<a href="#"
						class="d-flex align-items-center pb-sm-3 mb-md-0 me-md-auto text-white text-decoration-none">
						<span class="fs-5">T<span class="d-none d-sm-inline">ienda genérica</span></span>
					</a>
					<ul
						class="nav nav-pills flex-sm-column flex-row flex-nowrap flex-shrink-1 flex-sm-grow-0 flex-grow-1 mb-sm-auto mb-0 justify-content-center align-items-center align-items-sm-start"
						id="menu">
						<li class="nav-item"><a href="principal.jsp"
							class="nav-link px-sm-0 px-2"> <i class="fs-5 bi-house"></i><span
								class="ms-1 d-none d-sm-inline">Inicio</span>
						</a></li>
						<li><a href="usuario.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-people"></i><span
								class="ms-1 d-none d-sm-inline">Usuarios</span>
						</a></li>
						<li><a href="Clientes.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-person-check"></i><span
								class="ms-1 d-none d-sm-inline">Clientes</span></a>
						</li>
						<li><a href="proveedores.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-building"></i><span
								class="ms-1 d-none d-sm-inline">Proveedores</span></a>
						</li>
						<li><a href="productos.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-grid"></i><span
								class="ms-1 d-none d-sm-inline">Productos</span></a>
						</li>
						<li><a href="ventas.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-bag-check"></i><span
								class="ms-1 d-none d-sm-inline">Ventas</span>
						</a></li>
						<li><a href="reportes.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-card-checklist"></i><span
								class="ms-1 d-none d-sm-inline">Reportes</span>
						</a></li>
					</ul>
					<div
						class="dropdown py-sm-4 mt-sm-auto ms-auto ms-sm-0 flex-shrink-1">
						<a href="#"
							class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img src="..." onerror="this.src='img/defaultavatar.jpg';this.onerror='';"
							width="28" height="28" class="rounded-circle">
							<span class="d-none d-sm-inline mx-1">
							${sessionScope.usuario.nombre_usuario}
							</span>
						</a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
							aria-labelledby="dropdownUser1">
							<li><a class="dropdown-item" href="usuario?tipo=cerrarSesion">Cerrar sesión</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col d-flex flex-column h-100">
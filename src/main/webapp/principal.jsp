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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<div class="container-fluid overflow-hidden">
		<div class="row vh-100 overflow-auto">
			<div
				class="col-12 col-sm-3 col-xl-2 px-sm-2 px-0 bg-dark d-flex sticky-top">
				<div
					class="d-flex flex-sm-column flex-row flex-grow-1 align-items-center align-items-sm-start px-3 pt-2 text-white">
					<a href="principal.jsp"
						class="d-flex align-items-center pb-sm-3 mb-md-0 me-md-auto text-white text-decoration-none">
						<span class="fs-5">T<span class="d-none d-sm-inline">ienda genérica</span></span>
					</a>
					<ul
						class="nav nav-pills flex-sm-column flex-row flex-nowrap flex-shrink-1 flex-sm-grow-0 flex-grow-1 mb-sm-auto mb-0 justify-content-center align-items-center align-items-sm-start"
						id="menu">
						<li class="nav-item"><a href="#"
							class="nav-link px-sm-0 px-2"> <i class="fs-5 bi-house"></i><span
								class="ms-1 d-none d-sm-inline">Inicio</span>
						</a></li>
						<li><a href="usuarios.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-people"></i><span
								class="ms-1 d-none d-sm-inline">Usuarios</span>
						</a></li>
						<li><a href="Clientes.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-person-check"></i><span
								class="ms-1 d-none d-sm-inline">Clientes</span></a>
						</li>
						<li><a href="Clientes.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-building"></i><span
								class="ms-1 d-none d-sm-inline">Proveedores</span></a>
						</li>
						<li><a href="Productos.jsp" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-grid"></i><span
								class="ms-1 d-none d-sm-inline">Productos</span></a>
						</li>
						<li><a href="#" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-bag-check"></i><span
								class="ms-1 d-none d-sm-inline">Ventas</span>
						</a></li>
						<li><a href="#" class="nav-link px-sm-0 px-2"> <i
								class="fs-5 bi-card-checklist"></i><span
								class="ms-1 d-none d-sm-inline">Reportes</span>
						</a></li>
					</ul>
					<div
						class="dropdown py-sm-4 mt-sm-auto ms-auto ms-sm-0 flex-shrink-1">
						<a href="#"
							class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img src="https://github.com/mdo.png"
							alt="hugenerd" width="28" height="28" class="rounded-circle">
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
				<main class="row">
					<div class="col pt-4">
						<h3>Vertical Sidebar that switches to Horizontal Navbar</h3>
						<p class="lead">An example multi-level sidebar with collasible
							menu items. The menu functions like an "accordion" where only a
							single menu is be open at a time.</p>
						<hr />
						<h3>More content...</h3>
						<p>Sriracha biodiesel taxidermy organic post-ironic,
							Intelligentsia salvia mustache 90's code editing brunch. Butcher
							polaroid VHS art party, hashtag Brooklyn deep v PBR narwhal
							sustainable mixtape swag wolf squid tote bag. Tote bag cronut
							semiotics, raw denim deep v taxidermy messenger bag. Tofu YOLO
							Etsy, direct trade ethical Odd Future jean shorts paleo. Forage
							Shoreditch tousled aesthetic irony, street art organic Bushwick
							artisan cliche semiotics ugh synth chillwave meditation. Shabby
							chic lomo plaid vinyl chambray Vice. Vice sustainable cardigan,
							Williamsburg master cleanse hella DIY 90's blog.</p>
						<p>Ethical Kickstarter PBR asymmetrical lo-fi. Dreamcatcher
							street art Carles, stumptown gluten-free Kickstarter artisan Wes
							Anderson wolf pug. Godard sustainable you probably haven't heard
							of them, vegan farm-to-table Williamsburg slow-carb readymade
							disrupt deep v. Meggings seitan Wes Anderson semiotics, cliche
							American Apparel whatever. Helvetica cray plaid, vegan brunch
							Banksy leggings +1 direct trade. Wayfarers codeply PBR selfies.
							Banh mi McSweeney's Shoreditch selfies, forage fingerstache food
							truck occupy YOLO Pitchfork fixie iPhone fanny pack art party
							Portland.</p>
					</div>
				</main>
				<footer class="row bg-light py-4 mt-auto">
					<div class="col">Bottom footer content here...</div>
				</footer>
			</div>
		</div>
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

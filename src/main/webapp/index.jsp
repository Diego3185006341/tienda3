<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
<link rel="stylesheet" href="css/estilos_1.css">
<link rel="stylesheet" href="css/estilos_2.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>

<!-- CAPA CONTENEDORA PRINCIPAL -->
<div id="main-content">
		<!-- CAPA CONTENEDORA CABEZOTE WEB -->
		<header id="header">
			<p>NOMBRES</p>
		</header>
		
		<!-- CAPA CONTENEDORA MENU DE NAVEGACION WEB -->
		
			<nav class="navbar navbar-expand-lg navbar-dark- bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
		<!-- CAPA CONTENEDORA MENU IZQUIERDO WEB -->
		<sidebar id="sidebar">

		</sidebar>
		<!-- CAPA CONTENEDORA CONTENIDO CENTRAL - WEB -->
<content id="content">
<div class="container">
		<div class="form-container">
			<h2>Inicio de sesión</h2>
			<form id="formLogin" action="usuario" method="post">
				<input type="hidden" name="tipo" value="iniciarSesion" />
				<div class="form-group">
					<label for="nombre">Usuario</label>
					<input type="text" class="form-control" name="nombre" placeholder="Nombre de usuario" />
				</div>
				
				<div class="form-group">
					<label for="clave">Clave</label>
					<input type="password" class="form-control" name="clave" placeholder="Contraseña" />
				</div>
				
				<button type="submit" class="btn btn-success btn-block btn-lg">Iniciar sesión</button>
				<c:set var="mensaje" value="${requestScope.mensaje}" />
				<c:if test="${not empty mensaje}">
					<div id="alertLogin" class="alert alert-danger alert-dismissible fade in">
						${mensaje}
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					</div>
				</c:if>
			</form>
		</div>
	</div>

</content>
        
        <footer id="footer">

        </footer>
	</div>

	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
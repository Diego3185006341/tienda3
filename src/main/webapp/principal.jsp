<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->


<main class="row">


	<div class="row row-cols-1 row-cols-md-3 g-4">
		<div class="col">
			<div class="card h-100">
				<img
					src="https://misionticueb.myopenlms.net/pluginfile.php/1/tool_themeassets/assets/0/logo-mision-ubosque.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Ciclo 3 Desarrollo de software</h5>
					<p class="card-text">Proyecto de software para gestionar
						transacciones comerciales de una tienda genérica.</p>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card h-100">
				<img
					src="https://blog.trello.com/hubfs/Imported%20images/Global%20Footer%20CTA%20Image.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Avance del proyecto</h5>
					<p class="card-text">Sigue el progreso del proyecto en nuestro
						tablero de trello.</p>
				</div>
				<div class="card-footer bg-transparent border-white">
					<a
						href="https://trello.com/b/uVuJJHeL/equipo-05-del-grupo-40-para-el-proyecto-tienda-generica-del-ciclo-iii-mintic"
						target="_blank" class="btn btn-primary">Ir al tablero</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card h-100">
				<img
					src="https://github.githubassets.com/images/modules/site/icons/footer/github-logo.svg"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Repositorio</h5>
					<p class="card-text">Este es nuestro repositorio en Github.com
						para este proyecto.</p>
				</div>
				<div class="card-footer bg-transparent border-white">
					<a href="https://github.com/Diego3185006341/tienda3"
						target="_blank" class="btn btn-primary">Ir al repo</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card h-100">
				<img src="https://misionticueb.myopenlms.net/pluginfile.php/91348/theme_snap/coverimage/1630177066/course-image.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Equipo 05</h5>
					<p class="card-text">Diego Galindo <a href="https://interacpedia.com/user/diego-galindo-useche" target="_blank">Interacpedia</a><br>
					Manuel Gómez <a href="https://interacpedia.com/user/manuel-eduardo-gomez-ortiz" target="_blank">Interacpedia</a><br>
					Norbey García <a href="https://interacpedia.com/user/talent-sys" target="_blank">Interacpedia</a><br>
					Rafael Freay <a href="https://interacpedia.com/user/rafael-antonio-freay-avila" target="_blank">Interacpedia</a></p>
				</div>
			</div>
		</div>
	</div>

</main>


<!-- fin contenido  -->


<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENEDOR HEADER Y MENU DE NAVEGACION WEB -->
<jsp:include page="header.jsp" />


<!-- inicio de contenido  -->

<div class="container w-100">
  <div class="row h-100 justify-content-center align-items-center">
    <div class="col-12">
      <div class="form-group">
      <br> <br>
        <h2 class="text-center">REPORTES</h2>
      </div>
      <div class="form-group">
      <br> <br>
        <p class="text-center"><a href="reporteusuarios.jsp" class="btn btn-primary">Listado de
				Usuarios</a></p><br> <br>
      </div>
      
      <div class="form-group">
        <p class="text-center"><a href="reporteclientes.jsp" class="btn btn-primary">Listado de
				Clientes</a></p><br> <br>
      </div>
      
      <div class="form-group">
        <p class="text-center"><a href="reporteventas.jsp" class="btn btn-primary">Ventas por
				Cliente</a></p><br> <br>
      </div>
    </div>   
  </div>
</div>



<!-- fin contenido  -->


<!-- CONTENEDOR FOOTER -->
<jsp:include page="footer.jsp" />
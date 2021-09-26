<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
//Conexion con=new Conexion();
//con.conexiondb();

String d="",u="",c="",r="",e="";
if(request.getParameter("do")!=null){
d=request.getParameter("do");
u=request.getParameter("us");
c=request.getParameter("cl");
r=request.getParameter("ro");
e=request.getParameter("es");
}
%>
<form action="servletusuario" method="post">
<h1>Formulario de  ingreso</h1>
<select>
<option></option>
</select>
	<input type="text" name="doc"  value="<%=d%>">
	<input type="text" name="usu"  value="<%=u%>">
	<input type="password" name="cla"  value="<%=c%>">
	<input type="text" name="rol"  value="<%=r%>">
	<input type="text" name="est"  value="<%=e%>">
	<input type="submit" name="btnins" value="Registrar">
	<input type="submit" name="btncon" value="Consultar">
	<input type="submit" name="btnact" value="Actualizar">
	<input type="submit" name="btneli" value="Eliminar">
</form>

</body>
</html>
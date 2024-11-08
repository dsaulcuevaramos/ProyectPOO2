<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%String URL="http://localhost:8080/ProyectPOO2/"; %>

<body>
	
	<div>
	
		<form role="form" action="<%=URL%>EditorialController" method="POST">
		<input type="hidden" name="op" value=insertar>
		
		<label for="nombre">nombre:</label>
		<input type="text" name="nombre" id="nombre">
		<label for="contacto">contacto:</label>
		<input type="text" name="contacto" id="contacto">
		<label for="telefono">telefono:</label>
		<input type="text" name="telefono" id="telefono">
		
		<input type="submit" name="Guardar" id="Guardar" value="Agregar Editorial">		
		</form>
		<hr>
		<a href="<%=URL%>EditorialController?op=listar">CANCELAR</a>
	</div>
	
</body>
</html>
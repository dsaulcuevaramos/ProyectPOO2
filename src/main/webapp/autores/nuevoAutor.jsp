<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<% String url = "http://localhost:8080/ProyectPOO2/"; %>

<body>

	<h3>NUEVO AUTOR</h3>
	<form role="form" action="<%=url%>AutorController" method="POST">
	
	<input type="hidden" name="op" value="insertar">
	<div style="display:inline-block; color:red; background: gray; text-align: center;" >
	
		<label  for="nombre">Nombre:</label>
		<input type=text name="nombre" id="nombre">
		<br>
		<label for="nacionalidad">Nacionalidad: </label>
		<input type=text name="nacionalidad" id="nacionalidad">
		<br><br>
		<input type="submit" name="guardar" id="guardar" value="Agregar Autor">
		<br><br>
	
	</div>
	
	</form>
		<b> <a href="<%=url%>AutorController?op=listar">RETORNAR</a></b>
		<hr>
		hola
		<hr>
		carajo
		<hr>
		:)
</body>
</html>
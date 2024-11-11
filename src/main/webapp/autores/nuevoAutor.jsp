<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	
	<%@ include file='/cabecera.jsp' %>

	<h3>NUEVO AUTOR</h3>
	<form role="form" action="<%=URL%>AutorController" method="POST">
	
	<input type="hidden" name="op" value="insertar">
	
		<label  for="nombre">Nombre:</label>
		<input type=text name="nombre" id="nombre">
		<br>
		<label for="nacionalidad">Nacionalidad: </label>
		<input type=text name="nacionalidad" id="nacionalidad">
		<br><br>
		<input type="submit" name="guardar" id="guardar" value="Agregar Autor">
		<br><br>
	</form>
	<b> <a href="<%=URL%>AutorController?op=listar">RETORNAR</a></b>
	
	
		<hr>
		hola
		<hr>
		como está
		<hr>
		:)
</body>
</html>
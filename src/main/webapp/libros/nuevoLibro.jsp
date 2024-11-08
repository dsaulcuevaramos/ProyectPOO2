<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.Autor"%>
<%@ page import="com.unu.poo2.beans.Editorial"%>
<%@ page import="com.unu.poo2.util.util"%>
<%@ page import="com.unu.poo2.beans.Genero"%>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%String URL="http://localhost:8080/ProyectPOO2/"; %>

<body>

	<%
	List<Autor> la = (List<Autor>) request.getAttribute("listaAutores");
	List<Editorial> le = (List<Editorial>) request.getAttribute("listaEditoriales");
	List<Genero> lg = (List<Genero>) request.getAttribute("listaGeneros");
	%>

	<h1>FORMULARIO LIBROS</h1>
	<hr>
	<form role="form" action="<%=URL%>LibroController" method="POST">
		<input type="hidden" name="op" value="insertar">
		
		nombre: <input type="text" name="nombre">
		existencia: <input type="number" name="existencia">
		precio: <input type="number" name="precio">
		descripcion: <input type="text" name="descripcion">
		autor: 
		<select name="idautor">
			<% 		
				for (Autor atemp : la){			
			%>
				<option name="<%=atemp.getId()%>"><%=atemp.getNombre()%></option>
			<% }%>	
		</select>
		editorial: 
		<select name="ideditorial">
			<% 		
				for (Editorial etemp : le){
			%>
				<option name="<%=etemp.getIdEditorial()%>"><%=etemp.getNombre()%></option>
			<% }%>	
		</select>
		
		genero: 
		<select name="idgeneros">
			<% 		
				for (Genero gtemp : lg){
			%>
				<option name="<%=gtemp.getIdGenero()%>"><%=gtemp.getNombre()%></option>
			<% }%>	
		</select>
		
		<input type="submit" name="guardar" id="guardar" value="Agregar libro">
			<br><br>
	
	</form>
	
	<b> <a href="<%=URL%>LibroController?op=listar">RETORNAR</a></b>
</body>
</html>
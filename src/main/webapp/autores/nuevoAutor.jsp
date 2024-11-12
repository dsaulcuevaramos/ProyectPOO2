<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<script>
	function validarFormulario(){
		
		const respuesta = confirm('estas seguro de guardar?');
		const nombre = document.getElementById('nombre').value.trim();
		const nacionalidad = document.getElementById('nacionalidad').value.trim();
		
		if(respuesta){
			if(nombre === ''){
			alert('ingrese nombre del autor');
			document.getElementById('nombre').focus();
			return false;
			}
			if(nacionalidad === ''){
				alert('Ingese la nacionalidad del autor');
				document.getElementById('nacionalidad').focus();
				return false;
			}
			return true;
		}else{
			return false;
		}
		
	}
</script>


<body>
	
	<%@ include file='/cabecera.jsp' %>

	<h3>NUEVO AUTOR</h3>
	
	<%
	if(request.getAttribute("respuesta") != null){
		boolean res = (boolean) request.getAttribute("respuesta");
		if(res){
			List<String> listaError = (List<String>) request.getAttribute("listaError");
			
			for(String error : listaError){
	%>
	<span><%=error %></span>
	<%		
	}	
	}
	}
	%>
	
	<form role="form" action="<%=URL%>AutorController" method="POST" onsubmit="return validarFormulario()">
	
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
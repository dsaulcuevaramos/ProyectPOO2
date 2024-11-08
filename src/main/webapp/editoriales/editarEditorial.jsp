<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.Editorial" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<%String URL = "http://localhost:8080/ProyectPOO2/"; %>

<body>
	
	
<% 	Editorial editorial;
	HttpSession sesion = request.getSession();
	
	if(request.getAttribute("editorial")==null){
		editorial = new Editorial();
	}else{
		editorial = (Editorial) request.getAttribute("editorial");
	}
	
%>
	
	<form role="form" action="<%=URL%>EditorialController" method="POST">
		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="ideditorial" value="<%=editorial.getIdEditorial()%>">
		
		<h1>REGISTRO DE EDITORIAL</h1>
		
		id <input contenteditable="false" type="text" name="ideditorial" value="<%=editorial.getIdEditorial()%>"/>
		nombre<input type="text" name="nombre" value="<%=editorial.getNombre()%>">
		contacto<input type="text" name="contacto" value="<%=editorial.getContacto()%>">
		telefono<input type="text" name="telefono" value="<%=editorial.getTelefono()%>">
		
		<input type="submit" value="Guardar" name="Guardar">
		
	</form>
	<a href="<%=URL%>EditorialController?op=listar" >CANCELAR</a>
	
</body>
</html>









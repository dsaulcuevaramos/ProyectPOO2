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

<body>
	<%@ include file='/cabecera.jsp' %>
	
<% 	Editorial editorial;
	HttpSession sesion = request.getSession();
	
	if(request.getAttribute("editorial")==null){
		editorial = new Editorial();
	}else{
		editorial = (Editorial) request.getAttribute("editorial");
	}
	
%>
	
	<div class="container">
	
	<form role="form" action="<%=URL%>EditorialController" method="POST">
		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="ideditorial" value="<%=editorial.getIdEditorial()%>">
		
		<h1>REGISTRO DE EDITORIAL</h1>
		
		<div class="form-group">
			id <input class="form-control"  type="text" name="ideditorial" value="<%=editorial.getIdEditorial()%>"/>
		</div>
		<div class="form-group">
			nombre<input class="form-control"  type="text" name="nombre" value="<%=editorial.getNombre()%>">
		</div>
		<div class="form-group">
			contacto<input class="form-control"  type="text" name="contacto" value="<%=editorial.getContacto()%>">
		</div>
		<div class="form-group">
			telefono<input class="form-control" type="text" name="telefono" value="<%=editorial.getTelefono()%>">
		</div>
		
		<hr>
		
		<input type="submit" value="Guardar" name="Guardar">
		
	</form>
	<a href="<%=URL%>EditorialController?op=listar" >CANCELAR</a>
	
	
	</div>
	
</body>
</html>









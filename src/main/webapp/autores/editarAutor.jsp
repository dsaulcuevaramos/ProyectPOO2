<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.Autor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<% String URL = "http://localhost:8080/ProyectPOO2/"; 

	Autor autor;
	HttpSession sesion = request.getSession();
	
	if(request.getAttribute("autor") == null){
		autor = new Autor();
	}else{
		autor = (Autor) request.getAttribute("autor");
		System.out.println(autor.getNombre());
		System.out.println(autor.getNacionalidad());

	}
%>

<body>

	<form role="form" action="<%=URL%>AutorController" method="POST">
	
		<input type="hidden" name="op" value="modificar"/>
		<input type="hidden" name="idautor" value="<%=autor.getId()%>" />
		
		<h1>REGISTRO DE AUTOR</h1>
		
		id <input contenteditable="false" type="text" name="idautor" value="<%=autor.getId()%>"/>
		nombre <input type="text" name="nombre" value="<%=autor.getNombre()%>" />
		nacionalidad <input type="text" name="nacionalidad" value="<%=autor.getNacionalidad()%>" />
		<br>
		<input type="submit" class="btn btn-info" value="Guardar" name="Guardar"/>
		<a class="btn btn-danger" href="<%=URL%>AutorController?op=listar">Cancelar</a>
	
	</form>

</body>
</html>
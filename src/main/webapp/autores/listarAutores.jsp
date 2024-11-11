<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.unu.poo2.beans.Autor" %>


<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="../bootstrap/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body>
	
	<%@ include file='/cabecera.jsp' %>
	<!-- <jsp:include page="../cabecera.jsp"/> -->
	
	<div class="container">

		<a type="button" href="<%=URL%>AutorController?op=nuevo">_ NUEVO _</a>	
		<hr>
		<div>
		<table border=1 id="tabla" style="padding: 50px">
			<thead>
				<tr>
					<th>Codigo del autor</th>
					<th>Nombre del autor</th>
					<th>Nacionalidad</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody> 
				<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
				
				// Verificar si la lista no es nula
				if (listaAutores != null) {
					// Iterar sobre la lista de autores
					for (Autor autor : listaAutores) {
				%>
					<tr>
						<td><%= autor.getId() %></td>
						<td><%= autor.getNombre()%></td>
						<td><%= autor.getNacionalidad()%></td>
						<td>
							<a type="button" href="<%=URL%>AutorController?op=obtener&id=<%=autor.getId()%>"> MODIFICAR </a>
							<a type="button" href="<%=URL%>AutorController?op=eliminar&id=<%=autor.getId()%>"> ELIMINAR </a>
						</td>
					</tr>
				<%
					}
				} else {
				%>
				
					<tr>
						<td>No hay datos</td>
						<td>No hay datos</td>
						<td>No hay datos</td>
						<td></td>
					</tr>
				
				<%
					}
				%>
					
				
			</tbody>
		</table>
		
		
		</div>

	</div>
	
	
</body>
</html>
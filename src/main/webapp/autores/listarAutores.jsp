<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.unu.poo2.beans.Autor" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link href="autorStyle.css" type="text/css" rel="styleheet">
</head>

<% String URL = "http://localhost:8080/ProyectPOO2/"; %>



<body>

	<div id="hola">
		<div  style="display: flex;">
		<img alt="IMAGEN" src="">		
		<div>
			<a type="button" href="<%=URL%>AutorController?op=nuevo">_ NUEVO _</a>
		</div>	
		</div>	
		
	</div>

	<hr>
	<div >
	
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
	
</body>
</html>
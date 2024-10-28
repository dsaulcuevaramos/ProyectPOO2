<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.unu.poo2.beans.Autor" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>

</head>


<% String URL = "http://localhost:8080/ProyectPOO2/"; %>
<a type="button" href="<%=URL%>AutorController?op=nuevo"> NUEVO </a>


<body>
	<hr>
	<table border=1 id="tabla">
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
	
</body>
</html>
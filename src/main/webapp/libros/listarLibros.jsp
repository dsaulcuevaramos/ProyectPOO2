<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.Libro"%>    
<%@ page import="java.util.List"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%String URL = "http://localhost:8080/ProyectPOO2/";%>


<body>

	<a href="<%=URL%>LibroController?op=nuevo">NUEVO</a>
	<br>
	<table border=1>
		<thead>
			<tr>
				<th>id</th>
				<th>nombre</th>
				<th>existencia</th>
				<th>precio</th>
				<th>descipcion</th>
				<th>autor</th>
				<th>editorial</th>
				<th>genero</th>
				<th>operaciones</th>
			</tr>
		</thead>
		
		
		<% 
		List<Libro> listLibro = (List<Libro>) request.getAttribute("listarLibros");
		
		if(listLibro!=null){
			
			for(Libro libros : listLibro){
	
		%>	
		<tbody>
			<tr>
				<td><%=libros.getIdLibro() %></td>
				<td><%=libros.getNombre() %></td>
				<td><%=libros.getExistencia()%></td>
				<td><%=libros.getPrecio() %></td>
				<td><%=libros.getDescipcion() %></td>
				<td><%=libros.getLibro_autor().getNombre()%></td>
				<td><%=libros.getLibro_editorial().getNombre()%></td>
				<td><%=libros.getLibro_genero().getNombre()%></td>
				<td>
					<a>MODIFICAR</a>
					<a  type="button" href="<%=URL%>LibroController?op=eliminar&id=<%=libros.getIdLibro()%>">ELIMINAR</a>
				</td>
			</tr>
		</tbody>
		
		<%			
			}
		}
		 %>
	</table>

</body>
</html>
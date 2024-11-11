<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.unu.poo2.beans.Editorial"%>
<%@page import="java.util.List"%>

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

		<a type="button" href="<%=URL%>EditorialController?op=nuevo">NUEVO</a>
		<hr>
		
		<%
			List<Editorial> listaEditoriales  = (List<Editorial>) request.getAttribute("listaEditoriales");		
		%>
		<table border=1>
			<thead>
				<tr>
					<th>id</th>
					<th>nombre</th>
					<th>contacto</th>
					<th>telefono</th>
					<th>operaciones</th>
				</tr>
			</thead>	
			<tbody>
			<%
			if(listaEditoriales!=null){
				
				for(Editorial editorial : listaEditoriales){
					
		
			%>
				<tr>
					<td><%=editorial.getIdEditorial() %></td>
					<td><%=editorial.getNombre() %></td>
					<td><%=editorial.getContacto() %></td>
					<td><%=editorial.getTelefono() %></td>
					<td>
						<a type="button" href="<%=URL%>EditorialController?op=obtener&id=<%=editorial.getIdEditorial()%>">MODIFICAR</a>
						<a type="button" href="<%=URL%>EditorialController?op=eliminar&id=<%=editorial.getIdEditorial()%>">ELIMINAR</a>
					</td>
				</tr>
				
				
			<%		
			}
			}else{%>	
			<tr>
				<th rowspan="4">NO se encontraron datos</th>
			</tr>	
			<%}%>	
			</tbody>
		</table>
			

	</div>

	
</body>
</html>
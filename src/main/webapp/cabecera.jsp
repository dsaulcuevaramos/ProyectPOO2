<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Insert title here</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="../bootstrap/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    <meta name ="viewport" content="width=device-width, initial-scale=1, shrink-to-fitm-no">
    
    </head>

	<% String URL="http://localhost:8080/ProyectPOO2/";%>

    <body>
        
        <div class="container">
            
          <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=URL%>AutorController?op=listar">AUTOR</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<%=URL%>LibroController?op=listar">LIBRO</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<%=URL%>EditorialController?op=listar">EDITORIAL</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      REPORTE
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="">POR AUTOR</a></li>
                      <li><a class="dropdown-item" href="">POR LIBRO</a></li>
                      <li><a class="dropdown-item" href="">POR EDITORIAL</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>

        </div>
        
    </body>
</html>
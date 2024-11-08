package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Editorial;
import com.unu.poo2.beans.Genero;
import com.unu.poo2.beans.Libro;
import com.unu.poo2.models.LibroModel;
import com.unu.poo2.util.util;

/**
 * Servlet implementation class LibroController
 */
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static String listarURL = "/libros/listarLibros.jsp";
	LibroModel modeloL = new LibroModel();
	
    public LibroController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException{
    	
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()){
    		if(request.getParameter("op") == null) {
    			listar(request, response);
    		}
    		String operacion = request.getParameter("op");
    		
    		switch (operacion) {
			case "listar": 
				listar(request, response);
				break;
			
			case "nuevo":
				nuevo(request, response);
				break;
				
			case "insertar":
				
				break;

			case "obtener":
		
				break;
			case "modificar":
	
				break;
			case "eliminar":
				eliminar(request, response);
				break;	
			}
    	
    	}	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listarLibros", modeloL.listarLibros());
			request.getRequestDispatcher(listarURL).forward(request, response);
		} catch (Exception e) {
			Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	
	protected void nuevo(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setAttribute("listaAutores", modeloL.obtenerAutor());
			request.setAttribute("listaEditoriales", modeloL.obtenereditorial());
			request.setAttribute("listaGeneros", modeloL.obtenerGenero());
			request.getRequestDispatcher("/libros/nuevoLibro.jsp").forward(request, response);
		} catch (Exception e) {
			Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	protected void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Libro temp = new Libro();
			temp.setNombre(request.getParameter("nombre"));
			temp.setExistencia(Integer.parseInt( request.getParameter("existencia")));
			temp.setPrecio(Double.parseDouble(request.getParameter("precio")));
			temp.setDescipcion(request.getParameter("descripcion"));
			
			Autor atemp = new Autor();
			Editorial etemp = new Editorial();
			Genero gtemp = new Genero();
			
			atemp.setId(Integer.parseInt(request.getParameter("idautor")));
			temp.setLibro_autor(atemp);
			
			etemp.setIdEditorial(Integer.parseInt(request.getParameter("ideditorial")));
			temp.setLibro_editorial(etemp);
			
			gtemp.setIdGenero(Integer.parseInt(request.getParameter("idgenero")));
			temp.setLibro_genero(gtemp);
			
			if(modeloL.insertarLibro(temp)>0) {
				request.getSession().setAttribute("exito", "autor registrado correctamente");
			}else {
				request.getSession().setAttribute("fracaso", "autor no registrado");
			}
			response.sendRedirect(request.getContextPath() + "/LibroController?op=listar");

		} catch (Exception e) {
			Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			int idtemp = Integer.parseInt(request.getParameter("id"));
			if(modeloL.eliminarLibro(idtemp)>0) {
				request.getSession().setAttribute("exito", "autor eliminado correctamente");
			}else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido eliminado" + "ya hay un autor con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/AutorController?op=listar"); 
		}catch (SQLException | IOException ex) {
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
}

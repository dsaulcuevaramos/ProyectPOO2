package com.unu.poo2.controllers;
import com.unu.poo2.beans.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.models.AutorModel;

/**
 * Servlet implementation class AutorController
 */
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ListarURL = "/autores/listarAutores/.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    AutorModel modelo = new AutorModel();
    
    public void request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		if(request.getParameter("op") == null){
			listar(request,response);
		}
		String operacion = request.getParameter("op");	
		
		switch (operacion) {
		case "listar": {
			listar(request,response);
			break;
		}
		 /*
		 case "nuevo":
			 request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
		 break;
		 case "insertar":
			 insertar(request, response);
		 break;
		 case "obtener":
			 obtener(request, response);
		 break;
		 case "modificar":
			 modificar(request, response);
		 break;
		 case "eliminar":
			 eliminar(request, response);
		 break;*/
		 }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaAutores", modelo.listarAutores());

		
		try {
			Iterator<Autor> it = modelo.listarAutores().iterator();
			while(it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getNombre()+" "+a.getId()+" "+a.getNacionalidad());
			}
			request.getRequestDispatcher(ListarURL).forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
}

package com.unu.poo2.controllers;

import com.unu.poo2.beans.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.unu.poo2.beans.Autor;
import com.unu.poo2.models.AutorModel;


/**
 * Servlet implementation class AutorController
 */
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ListarURL = "/autores/listarAutores.jsp";

	/**	
	 * @see HttpServlet#HttpServlet()
	 */
	public AutorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	AutorModel modelo = new AutorModel();

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}

			String operacion = request.getParameter("op");

			switch (operacion) {
			case "listar":
				listar(request, response);
				break;

			case "nuevo":
				request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
				break;

			case "insertar":
				insertar(request, response);
				// listar(request, response); //ojo revisar esto en clase
				break;

			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {

			request.setAttribute("listaAutores", modelo.listarAutores());
			
			/*
			Iterator<Autor> it = modelo.listarAutores().iterator();
			while (it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getNombre() + " " + a.getId() + " " + a.getNacionalidad());
			}
			*/
			request.getRequestDispatcher(ListarURL).forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	protected void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Autor autor = new Autor();
			autor.setNombre(request.getParameter("nombre"));
			autor.setNacionalidad(request.getParameter("nacionalidad"));

			if (modelo.insertarAutor(autor) > 0) {
				request.getSession().setAttribute("exito", "autor registrado correctamente");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido ingresado" + "ya hay un autor con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/AutorController?op=listar"); // ojo revisar esto

		} catch (SQLException | IOException ex) { //
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
			String id = request.getParameter("id");
			Autor autortemp = modelo.obtenerAutor(Integer.parseInt(id));		
		try {
			System.out.println(autortemp.getNombre());
			System.out.println(autortemp.getNacionalidad());
			
			if(autortemp != null) {
				request.setAttribute("autor", autortemp);
				request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
			
		} catch (Exception ex) {
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	protected void modificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			Autor autor = new Autor();
			autor.setNombre(request.getParameter("nombre"));
			autor.setNacionalidad(request.getParameter("nacionalidad"));

			if (modelo.modificarAutor(autor) > 0) {
				request.getSession().setAttribute("exito", "autor registrado correctamente");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido ingresado" + "ya hay un autor con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/AutorController?op=listar"); // ojo revisar esto

		} catch (SQLException | IOException ex) { //
			Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

	}

}

package com.unu.poo2.controllers;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.models.EditorialModel;
import com.mysql.cj.log.Log;
import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Editorial;

/**
 * Servlet implementation class EditorialController
 */
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static final String ListarURL = "/editoriales/listarEditoriales.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	EditorialModel modeloE = new EditorialModel();
    
    public void proccesRequest (HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException, SQLException{
    	response.setContentType("text/html;charset=UTF-8");
    	
    	try (PrintWriter out = response.getWriter()){
    		if(request.getParameter("op") == null) {
    			listar(request,response);
    		}
    		
    		String operacion = request.getParameter("op");
    		switch (operacion){
			case "listar": 
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
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
				break;
			}
    	
		} 
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			proccesRequest(request, response);
		} catch (ServletException | IOException | SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			proccesRequest(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			request.setAttribute("listaEditoriales", modeloE.listarEditoriales());
			request.getRequestDispatcher(ListarURL).forward(request, response);
		} catch (Exception ex) {
			Logger.getLogger(EditorialController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	protected void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			Editorial editorial = new Editorial();
			editorial.setNombre(request.getParameter("nombre"));
			editorial.setContacto(request.getParameter("contacto"));
			editorial.setTelefono(request.getParameter("telefono"));
			if(modeloE.insertarEditorial(editorial)>0) {
				request.getSession().setAttribute("exito", "editorial registrado correctamente");
			}else {
				request.getSession().setAttribute("fracaso", "editorial no registrado");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialController?op=listar");
			
		} catch (Exception  ex) {
			Logger.getLogger(EditorialController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, SQLException, IOException {
		try {
			Editorial temp = new Editorial();
			temp.setIdEditorial(Integer.parseInt(request.getParameter("ideditorial")));
			temp.setNombre(request.getParameter("nombre"));
			temp.setContacto(request.getParameter("contacto"));
			temp.setTelefono(request.getParameter("telefono"));
			
			if(modeloE.modificarEditorial(temp)>0) {
				request.getSession().setAttribute("exito", "editorial modificado correctamente");
			}else {
				request.getSession().setAttribute("fracaso", "editorial no modificado correctamente");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialController?op=listar");
			
		} catch (SQLException |IOException ex) {
			Logger.getLogger(EditorialController.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
	
	protected void obtener(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
			//System.out.println(request.getParameter("id"));
			String id = request.getParameter("id");
			//System.out.println(id);
			Editorial temp = modeloE.obtenerEditorial(Integer.parseInt(id));
			
		try {
			System.out.println(temp.getNombre());
			System.out.println(temp.getContacto());
			if(temp!=null) {
				request.setAttribute("editorial", temp);
				request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/editoriales/listarEditoriales.jsp").forward(request, response);
			}
					
		} catch (Exception ex) {
			Logger.getLogger(EditorialController.class.getName()).log(Level.SEVERE,null,ex);
		}
	
		
		
		
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		try {
			int idtemp = Integer.parseInt(request.getParameter("id"));
			if(modeloE.eliminarEditorial(idtemp)>0) {
				request.getSession().setAttribute("exito", "editorial eliminado");
			}
			else {
				request.getSession().setAttribute("fracaso", "editorial no eliminado");
			}
			
			response.sendRedirect(request.getContextPath() + "/EditorialController?op=listar");
		} catch (Exception ex) {
			Logger.getLogger(EditorialController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

}

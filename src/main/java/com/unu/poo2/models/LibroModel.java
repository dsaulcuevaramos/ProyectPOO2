package com.unu.poo2.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.Result;
import com.unu.poo2.beans.Libro;
import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Editorial;
import com.unu.poo2.beans.Genero;

public class LibroModel extends Conexion{

	PreparedStatement ps;
	CallableStatement cs;
	ResultSet rs;
	String sql;
	
	public List<Libro> listarLibros() throws SQLException{
		sql = "CALL sp_listarLibros()";
		List<Libro> librosList = new ArrayList<Libro>();
		try {		
			this.openConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Autor a = new Autor();
				Editorial e = new Editorial();
				Genero g = new Genero();
				
				Libro librotemp = new Libro();
				librotemp.setIdLibro(rs.getInt("idlibro"));
				librotemp.setNombre(rs.getString("nombre"));
				librotemp.setExistencia(rs.getInt("existencia"));
				librotemp.setPrecio(rs.getDouble("precio"));
				librotemp.setDescipcion(rs.getString("descripcion"));
				
					a.setId(rs.getInt("idautor"));
					a.setNombre(rs.getString(10));
					a.setNacionalidad(rs.getString(11));
					librotemp.setLibro_autor(a);		
					
					e.setIdEditorial(rs.getInt("ideditorial"));
					e.setNombre(rs.getString(13));
					e.setContacto(rs.getString(14));
					e.setTelefono(rs.getString(15));
					librotemp.setLibro_editorial(e);
					
					g.setIdGenero(rs.getInt("idgenero"));
					g.setNombre(rs.getString(17));
					g.setDescipcion(rs.getString(18));
					librotemp.setLibro_genero(g);
						
					librosList.add(librotemp);	
			}
			this.closeConnexion();
			return librosList;
		} catch (Exception e) {
			e.getStackTrace();
			this.closeConnexion();
			return null;
		}
		
	}
	
	public int insertarLibro(Libro libro) {
		sql = "CALL sp_insertarLibro(?,?,?,?,?,?,?,?)";
		int filasAfectadas = 0;
		try {
			cs = conexion.prepareCall(sql);
			cs.setString(1, libro.getNombre());
			cs.setInt(2, libro.getExistencia());
			cs.setDouble(3, libro.getPrecio());
			cs.setString(4, libro.getDescipcion());
			cs.setInt(5, libro.getLibro_autor().getId());
			cs.setInt(6, libro.getLibro_editorial().getIdEditorial());
			cs.setInt(7, libro.getLibro_genero().getIdGenero());
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (Exception e) {
			e.getStackTrace();
			this.closeConnexion();
			return 0;
		}
	}
	
	public int modificarLibro() {
		return 0;
	}
	
	public int eliminarLibro() {
		return 0;
	}
	
	public Libro obtenerLibro() {
		return null;
	}
	
	
	public List<Autor> obtenerAutor(){
		sql = "SELECT * FROM autor";
		List<Autor> lautor = new ArrayList<Autor>();	
		try {
			this.openConexion();
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Autor temp = new Autor();
				temp.setId(rs.getInt("idautor"));
				temp.setNombre(rs.getString("nombre"));
				temp.setNacionalidad(rs.getString("nacionalidad"));	
				lautor.add(temp);
			}
			this.closeConnexion();
			return lautor;
		} catch (Exception e) {
			e.getStackTrace();
			this.closeConnexion();
			return null;
		}
	}
	
	public List<Editorial> obtenereditorial(){
		sql = "SELECT * FROM editorial";
		List<Editorial> leditorial = new ArrayList<Editorial>();
		try {
			this.openConexion();
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Editorial temp = new Editorial();
				temp.setIdEditorial(rs.getInt(1));
				temp.setNombre(rs.getString(2));
				temp.setContacto(rs.getString(3));
				temp.setTelefono(rs.getString(4));
				leditorial.add(temp);
			}
			this.closeConnexion();
			return leditorial;
		} catch (Exception e) {
			this.closeConnexion();
			return null;
		}
	}
	
	public List<Genero> obtenerGenero(){
		sql = "SELECT * FROM genero";
		List<Genero> lgenero = new ArrayList<Genero>();
		try {
			this.openConexion();
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Genero temp = new Genero();
				temp.setIdGenero(rs.getInt(1));
				temp.setNombre(rs.getString(2));
				temp.setDescipcion(rs.getString(3));
				lgenero.add(temp);
			}
			this.closeConnexion();
			return lgenero;
		} catch (Exception e) {
			this.closeConnexion();
			return null;
		}
	}
	

	public int eliminarLibro(int idlibro) throws SQLException {	
		int filasAfectadas = 0;
		sql = "CALL sp_eliminarLibro(?)";
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idlibro);
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);
			this.closeConnexion();
			return 0;
		}
		
	}
	
}

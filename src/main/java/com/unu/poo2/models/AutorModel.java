package com.unu.poo2.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Autor;

import oracle.jdbc.driver.parser.util.Array;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AutorModel extends Conexion{

	CallableStatement cs;
	ResultSet rs;
	Statement st;
	
	private String sql;
	
	public List<Autor> listarAutores() throws SQLException {
		
		List<Autor> lista = new ArrayList<>();	
		sql = "CALL sp_listarAutores()";
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Autor autorTemp = new Autor();
				autorTemp.setId(rs.getInt("idAutor"));
				autorTemp.setNombre(rs.getString("nombre"));
				autorTemp.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autorTemp);
			}
			this.closeConnexion();
			return lista;
		} catch (SQLException ex) {
			ex.printStackTrace();
			this.closeConnexion();
			return null;
		}	
	}

	
	public int insertarAutor(Autor autor) throws SQLException {
		
		int filasAfectadas = 0;
		sql = "CALL sp_insertarAutor(?,?)";
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, autor.getNombre());
			cs.setString(2, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);
			this.closeConnexion();
			return 0;
		}
	}
	
	public int modificarAutor(Autor autor) throws SQLException {
		
		int filasAfectadas = 0;
		sql = "CALL sp_modificarAutor(?,?,?)";
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getId());
			cs.setString(2, autor.getNombre());
			cs.setString(3,autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);	
			this.closeConnexion();
			return 0;
		}
	}
	
	public int eliminarAutor(int idAutor) throws SQLException {
		
		int filasAfectadas = 0;
		sql = "CALL sp_eliminarAutor(?)";
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idAutor);
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);
			this.closeConnexion();
			return 0;
		}
		
	}
	
	public Autor obtenerAutor(int idAutor) throws SQLException {
		
		sql = "CALL sp_obtenerAutor(?)";

		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);	
			cs.setInt(1, idAutor);
			rs = cs.executeQuery();
			if(rs.next()) {
				Autor autorTemp = new Autor();
				autorTemp.setId(rs.getInt("idAutor"));
				autorTemp.setNombre(rs.getString("nombre"));
				autorTemp.setNacionalidad(rs.getString("nacionalidad"));
				this.closeConnexion();
				return autorTemp;
			}
			this.openConexion();
			return null;
			
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);
			this.closeConnexion();
			return null;
		}
		
	}
	
	public int totalAutores() throws SQLException {
		
		int totala = 0;	
		sql = "SELECT COUNT(codigo) as totala FROM autor";
		
		try {		
			this.openConexion();
			st = conexion.prepareStatement(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				totala = rs.getInt("totala");
			}
			return totala;
		} catch (SQLException ex) {
			Logger.getLogger(AutorModel.class.getName()).log(Level.SEVERE, null, ex);
				return 0;
			
			} finally {
				this.closeConnexion();
			}
		}	
	
}

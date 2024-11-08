package com.unu.poo2.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Editorial;

public class EditorialModel extends Conexion{

	CallableStatement cs;
	ResultSet rs;
	Statement st;
	
	private String sql;
	
	public List<Editorial> listarEditoriales()  throws SQLException{
		
		sql = "CALL sp_listarEditoriales()";
		ArrayList<Editorial> lista = new ArrayList<Editorial>();
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Editorial temp = new Editorial();
				temp.setIdEditorial(rs.getInt("ideditorial"));
				temp.setNombre(rs.getString("nombre"));
				temp.setContacto(rs.getString("contacto"));
				temp.setTelefono(rs.getString("telefono"));
				lista.add(temp);
			}
			this.closeConnexion();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeConnexion();
			return null;
		}
	}
	
	
	public int insertarEditorial(Editorial editorial) throws SQLException {
		
		sql = "CALL sp_insertarEditorial(?,?,?)";
		int filasAfectadas;
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, editorial.getNombre());
			cs.setString(2, editorial.getContacto());
			cs.setString(3, editorial.getTelefono());
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeConnexion();
			return 0;
		}
		
	}
	
	public int modificarEditorial(Editorial editorial) throws SQLException{
		
		sql = "CALL sp_modificarEditorial(?,?,?,?)";
		int filasAfectadas = 0;
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);	
			cs.setInt(1, editorial.getIdEditorial());
			cs.setString(2, editorial.getNombre());
			cs.setString(3, editorial.getContacto());
			cs.setString(4, editorial.getTelefono());
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeConnexion();
			return 0;
		}
	}
	
	public int eliminarEditorial(int id) throws SQLException{

		sql = "CALL sp_eliminarEditorial(?)";
		int filasAfectadas;
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, id);
			filasAfectadas = cs.executeUpdate();
			this.closeConnexion();
			return filasAfectadas;
		} catch (Exception e) {
			e.printStackTrace();
			this.closeConnexion();
			return 0;
		}
		
	}
	
	public Editorial obtenerEditorial(int id) throws SQLException {
		
		sql = "CALL sp_obtenerEditorial(?)";
		Editorial temp = new Editorial();
		
		try {
			this.openConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				temp.setIdEditorial(rs.getInt("ideditorial"));
				temp.setNombre(rs.getString("nombre"));
				temp.setContacto(rs.getString("contacto"));
				temp.setTelefono(rs.getString("telefono"));	
			}
			this.closeConnexion();
			return temp;
		} catch (Exception e) {
			this.closeConnexion();
			return null;
		}
		
	}
	
}

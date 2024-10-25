package com.unu.poo2.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Autor;

import oracle.jdbc.driver.parser.util.Array;

public class AutorModel extends Conexion{

	CallableStatement cs;
	ResultSet rs;
	
	public List<Autor> listarAutores(){
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listarAutores()";
			this.openConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Autor autor = new Autor();
				autor.setId(rs.getInt("idAutor"));
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			this.closeConnexion();
			return lista;
		} catch (SQLException ex) {
			ex.printStackTrace();
			this.closeConnexion();
			return null;
		}	
	}

	
	public int agregarAutor(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}

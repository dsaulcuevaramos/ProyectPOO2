package com.unu.poo2.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String bd = "bibliotecapoo2";
	private String url = "jdbc:mysql://localhost/"+bd;
	private String usuario = "root";
	private String contrasena = "123456";
	protected Connection conexion = null;
	
	public void openConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,contrasena);
			System.out.println("Conexion exitosa a la base de datos");
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeConnexion() {
		try {
			if(conexion!= null && !conexion.isClosed()) {
				conexion.close();
				System.out.println("Conexion Cerrada");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
}}}


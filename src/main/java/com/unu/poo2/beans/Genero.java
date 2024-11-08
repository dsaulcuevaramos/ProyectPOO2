package com.unu.poo2.beans;

public class Genero {

	private int idGenero;
	private String nombre;
	private String descipcion;

	public Genero(int idGenero, String nombre, String descipcion) {
		this.idGenero = idGenero;
		this.nombre = nombre;
		this.descipcion = descipcion;
	}

	public Genero() {
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	
	
	
	
}

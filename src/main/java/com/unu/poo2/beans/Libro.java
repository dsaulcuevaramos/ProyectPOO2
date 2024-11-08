package com.unu.poo2.beans;

public class Libro {
	
	private int idLibro;
	private String nombre;
	private int existencia;
	private Double precio;
	private String descipcion;
	private Autor libro_autor; 
	private Editorial libro_editorial; 
	private Genero libro_genero; 

	public Libro(int idLibro, String nombre, int existencia, Double precio, String descipcion, 
			Autor libro_autor, Editorial libro_editorial, Genero libro_genero) {
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.existencia = existencia;
		this.precio = precio;
		this.descipcion = descipcion;
		this.libro_autor = libro_autor;
		this.libro_editorial = libro_editorial;
		this.libro_genero = libro_genero;
	}

	public Libro() {
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public Autor getLibro_autor() {
		return libro_autor;
	}

	public void setLibro_autor(Autor libro_autor) {
		this.libro_autor = libro_autor;
	}

	public Editorial getLibro_editorial() {
		return libro_editorial;
	}

	public void setLibro_editorial(Editorial libro_editorial) {
		this.libro_editorial = libro_editorial;
	}

	public Genero getLibro_genero() {
		return libro_genero;
	}

	public void setLibro_genero(Genero libro_genero) {
		this.libro_genero = libro_genero;
	}
	
	
	
}

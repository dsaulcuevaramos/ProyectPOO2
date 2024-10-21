package com.unu.poo2.models;

import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Autor;

import oracle.jdbc.driver.parser.util.Array;

public class AutorModel {

	public List<Autor> listarAutores(){
		
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor(1, "Gomez", "Colombiano"));
		autores.add(new Autor(2, "Carlos", "Argentino"));
		autores.add(new Autor(3, "Raul", "Chileno"));
		return autores;
	}	
	
}

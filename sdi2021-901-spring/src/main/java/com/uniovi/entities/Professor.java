package com.uniovi.entities;


public class Professor {
	
	private Long id;
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private String Categoria;

	public Professor() {

	}

	public Professor(Long id, String dNI, String nombre, String apellidos, String categoria) {
		this.id = id;
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
				+ ", Categoria=" + Categoria + "]";
	}
}

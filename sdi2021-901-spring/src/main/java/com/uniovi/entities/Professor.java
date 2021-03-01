package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String dni;
	private String nombre;
	private String apellido;
	private String categoria;

	public Professor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor(String dNI, String nombre, String apellidos, String categoria) {
		super();
		this.dni = dNI;
		this.nombre = nombre;
		this.setApellido(apellidos);
		this.categoria = categoria;
	}

	public Professor(Long id, String dNI, String nombre, String apellidos, String categoria) {
		super();
		this.id = id;
		dni = dNI;
		this.nombre = nombre;
		this.setApellido(apellidos);
		this.categoria = categoria;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}

package com.bordafederico.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "funcion")
public class Funcion {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_funcion")
	private int id_funcion;
	
	
	@Column(name="nombre_funcion")
	@NotEmpty
	private String nombre_funcion;

	
	@Column(name="descripcion_funcion")
	@NotEmpty
	private String descripcion_funcion;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private GrupoFuncion grupofuncion_funcion;


	public int getId_funcion() {
		return id_funcion;
	}


	public void setId_funcion(int id_funcion) {
		this.id_funcion = id_funcion;
	}


	public String getNombre_funcion() {
		return nombre_funcion;
	}


	public void setNombre_funcion(String nombre_funcion) {
		this.nombre_funcion = nombre_funcion;
	}


	public String getDescripcion_funcion() {
		return descripcion_funcion;
	}


	public void setDescripcion_funcion(String descripcion_funcion) {
		this.descripcion_funcion = descripcion_funcion;
	}
	
	
	
	

}

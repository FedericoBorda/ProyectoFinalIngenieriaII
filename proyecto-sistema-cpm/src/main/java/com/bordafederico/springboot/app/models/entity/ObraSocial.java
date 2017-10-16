package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="obra_social")
public class ObraSocial implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_obra_social;
	
	private String nombre_obra_social;
	private String direccion_obra_social;
	
	
	
	
	
	public Long getId_obra_social() {
		return id_obra_social;
	}
	public void setId_obra_social(Long id_obra_social) {
		this.id_obra_social = id_obra_social;
	}
	public String getNombre_obra_social() {
		return nombre_obra_social;
	}
	public void setNombre_obra_social(String nombre_obra_social) {
		this.nombre_obra_social = nombre_obra_social;
	}
	public String getDireccion_obra_social() {
		return direccion_obra_social;
	}
	public void setDireccion_obra_social(String direccion_obra_social) {
		this.direccion_obra_social = direccion_obra_social;
	}
	
	
	
	
	
	
	

}

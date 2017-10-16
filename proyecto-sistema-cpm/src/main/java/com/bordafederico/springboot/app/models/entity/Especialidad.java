package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
//@Table(name="especialidad")
public class Especialidad implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_especialida;
	
	private String nombre_especialidad;
	private String descripcion_esp;
	
	
	
	
	public Long getId_especialida() {
		return id_especialida;
	}
	public void setId_especialida(Long id_especialida) {
		this.id_especialida = id_especialida;
	}
	public String getNombre_especialidad() {
		return nombre_especialidad;
	}
	public void setNombre_especialidad(String nombre_especialidad) {
		this.nombre_especialidad = nombre_especialidad;
	}
	public String getDescripcion_esp() {
		return descripcion_esp;
	}
	public void setDescripcion_esp(String descripcion_esp) {
		this.descripcion_esp = descripcion_esp;
	}
	
	
	
	
	
	
	

}

package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="especialidad")
public class Especialidad implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_especialida;
	
	@NotEmpty
	private String nombre_especialidad;
	
	@NotEmpty
	private String descripcion_esp;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Medico medico_especialidad;
	
	
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
	
	
	public Medico getMedico() {
		return medico_especialidad;
	}
	public void setMedico(Medico medico) {
		this.medico_especialidad = medico;
	}
	
	
	
	
	
	
	

}

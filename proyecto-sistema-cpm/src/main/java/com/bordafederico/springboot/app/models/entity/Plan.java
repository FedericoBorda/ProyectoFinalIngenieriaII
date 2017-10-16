package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="plan")
public class Plan implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_plan;
	
	
	private String tipo_plan;
	private String descripcion_plan;
	
	
	
	
	public Long getId_plan() {
		return id_plan;
	}
	public void setId_plan(Long id_plan) {
		this.id_plan = id_plan;
	}
	public String getTipo_plan() {
		return tipo_plan;
	}
	public void setTipo_plan(String tipo_plan) {
		this.tipo_plan = tipo_plan;
	}
	public String getDescripcion_plan() {
		return descripcion_plan;
	}
	public void setDescripcion_plan(String descripcion_plan) {
		this.descripcion_plan = descripcion_plan;
	}
	
	
	

}

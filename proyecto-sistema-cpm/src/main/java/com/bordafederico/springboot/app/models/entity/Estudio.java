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
@Table(name="estudio")
public class Estudio implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estudio;
	
	@NotEmpty
	private String nombre_estudio;
	
	@NotEmpty
	private String descipcion_estudio;
	
	@NotEmpty
	private String contenido_estudio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TurnoConsulta turnoConsulta;
	
	public Long getId_estudio() {
		return id_estudio;
	}
	public void setId_estudio(Long id_estudio) {
		this.id_estudio = id_estudio;
	}
	public String getNombre_estudio() {
		return nombre_estudio;
	}
	public void setNombre_estudio(String nombre_estudio) {
		this.nombre_estudio = nombre_estudio;
	}
	public String getDescipcion_estudio() {
		return descipcion_estudio;
	}
	public void setDescipcion_estudio(String descipcion_estudio) {
		this.descipcion_estudio = descipcion_estudio;
	}
	public String getContenido_estudio() {
		return contenido_estudio;
	}
	public void setContenido_estudio(String contenido_estudio) {
		this.contenido_estudio = contenido_estudio;
	}
	
	
	
	public TurnoConsulta getTurnoConsulta() {
		return turnoConsulta;
	}
	public void setTurnoConsulta(TurnoConsulta turnoConsulta) {
		this.turnoConsulta = turnoConsulta;
	}
	
	

}

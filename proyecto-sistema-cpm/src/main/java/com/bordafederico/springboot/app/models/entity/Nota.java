package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="nota")
public class Nota implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_nota;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fecha_nota;
	
	@NotEmpty
	private String nombre_nota;
	
	@NotEmpty
	private String contenido_nota;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nro_matricula")
	private Medico medico_nota;
	
	
	
	public Long getId_nota() {
		return id_nota;
	}
	public void setId_nota(Long id_nota) {
		this.id_nota = id_nota;
	}
	public Date getFecha_nota() {
		return fecha_nota;
	}
	public void setFecha_nota(Date fecha_nota) {
		this.fecha_nota = fecha_nota;
	}
	public String getNombre_nota() {
		return nombre_nota;
	}
	public void setNombre_nota(String nombre_nota) {
		this.nombre_nota = nombre_nota;
	}
	public String getContenido_nota() {
		return contenido_nota;
	}
	public void setContenido_nota(String contenido_nota) {
		this.contenido_nota = contenido_nota;
	}
	
	
	
	public Medico getMedico_nota() {
		return medico_nota;
	}
	public void setMedico_nota(Medico medico_nota) {
		this.medico_nota = medico_nota;
	}
	
	
	
	

}

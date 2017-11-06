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
@Table(name = "grupo_funciones_x_rol")
public class GrupoFuncionxRol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_grupofunciones_x_rol")
	private int id;
	
	
	@Column(name="nombre_gfr")
	@NotEmpty
	private String nombre_gfr;

	//comento ésto para separarlo del ROL
	//@ManyToOne(fetch=FetchType.LAZY)
	//private Rol rol_gfr;

	@ManyToOne(fetch=FetchType.LAZY)
	private GrupoFuncion grupofuncion_grupofuncionrol;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_gfr() {
		return nombre_gfr;
	}

	public void setNombre_gfr(String nombre_gfr) {
		this.nombre_gfr = nombre_gfr;
	}

	/*
	public Rol getRol_gfr() {
		return rol_gfr;
	}

	public void setRol_gfr(Rol rol_gfr) {
		this.rol_gfr = rol_gfr;
	}
	*/	
	
	

}

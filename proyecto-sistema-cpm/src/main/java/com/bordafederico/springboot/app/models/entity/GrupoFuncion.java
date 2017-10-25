package com.bordafederico.springboot.app.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "grupo_funcion")
public class GrupoFuncion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_grupo_funcion")
	private int id_grupo_funcion;
	
	
	@Column(name="nombre_gf")
	@NotEmpty
	private String nombre_gf;

	
	@Column(name="descripcion_gf")
	@NotEmpty
	private String descripcion_gf;
	
	
	@OneToMany(mappedBy="grupofuncion_grupofuncionrol", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<GrupoFuncionxRol> gf_x_gfr;	
	
	@OneToMany(mappedBy="grupofuncion_funcion", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Funcion> funcion_x_grupofuncion;	
	
		

	public GrupoFuncion() {
		gf_x_gfr =  new ArrayList<GrupoFuncionxRol>();
		funcion_x_grupofuncion =  new ArrayList<Funcion>();
	}
	
	
	
	public int getId_grupo_funcion() {
		return id_grupo_funcion;
	}
	public void setId_grupo_funcion(int id_grupo_funcion) {
		this.id_grupo_funcion = id_grupo_funcion;
	}
	public String getNombre_gf() {
		return nombre_gf;
	}
	public void setNombre_gf(String nombre_gf) {
		this.nombre_gf = nombre_gf;
	}
	public String getDescripcion_gf() {
		return descripcion_gf;
	}
	public void setDescripcion_gf(String descripcion_gf) {
		this.descripcion_gf = descripcion_gf;
	}


	public List<GrupoFuncionxRol> getGf_x_gfr() {
		return gf_x_gfr;
	}
	public void setGf_x_gfr(List<GrupoFuncionxRol> gf_x_gfr) {
		this.gf_x_gfr = gf_x_gfr;
	}
	
	
	//este metodo lo que hace es agregar un grupo de funcion x rol al grupo de funcion 
	//loagregaria al lis de grupofuncionxrol que esta en esta clase
	public void addGfrAlGf(GrupoFuncionxRol grupofuncionxrol) {
		gf_x_gfr.add(grupofuncionxrol);
	}
	
	//este metodo lo que hace es agregar una funcion al grupo de funcion
	//lo afregaria al list de funcion que esta clase
	public void addmetodo(Funcion funcion) {
		 funcion_x_grupofuncion.add(funcion);
	}



	
	
	
}

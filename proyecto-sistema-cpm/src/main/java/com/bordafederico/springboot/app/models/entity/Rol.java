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
@Table(name = "rol")
public class Rol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_rol")
	private int id;
	
	
	@Column(name="tipo_rol")
	@NotEmpty
	private String tipo_rol;

	@OneToMany(mappedBy="rol_usuario", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Usuario> usuarios_x_rol;
	
	@OneToMany(mappedBy="rol_gfr", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<GrupoFuncionxRol> gfr_x_rol;	
	
	
	public Rol() {
		usuarios_x_rol = new ArrayList<Usuario>();	
		gfr_x_rol =  new ArrayList<GrupoFuncionxRol>();

	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo_rol() {
		return tipo_rol;
	}
	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}
	
	
	public List<Usuario> getUsuarios_x_rol() {
		return usuarios_x_rol;
	}
	public void setUsuarios_x_rol(List<Usuario> usuarios_x_rol) {
		this.usuarios_x_rol = usuarios_x_rol;
	}
	
	
	public void addUsuarioAlRol(Usuario usuario) {
		usuarios_x_rol.add(usuario);
	}
	
	public void addgfrAlRol(GrupoFuncionxRol gfr) {
		gfr_x_rol.add(gfr);
	}
	

}

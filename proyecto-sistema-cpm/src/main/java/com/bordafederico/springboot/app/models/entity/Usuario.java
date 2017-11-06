package com.bordafederico.springboot.app.models.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;





@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private int id_usuario;
	
	@Column(name = "dni")
	@NotEmpty(message = "*Debe ingresar su DNI ")
	private String dni;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Su password debe tener al menos 5 caracteres")
	@NotEmpty(message = "*Debe ingresar un password")
	@Transient
	private String password;
	
	
	@Column(name = "nombre")
	@NotEmpty(message = "*Debe ingresar su nombre")
	private String nombre;
	
	
	@Column(name = "apellido")
	@NotEmpty(message = "*Debe ingresar su apellido")
	private String apellido;
	
	@Column(name = "email")
	@Email(message = "*Ingrese una direccion de correo valida")
	@NotEmpty(message = "*Debe ingresar un direccion de correo ")
	private String email;
	
	
	@Column(name = "activo")
	private int activo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles;

	//comento ésto para hacer el ejemplo de seguridad
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	private Rol rol_usuario;
	*/

	
	
	
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
	
}

package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="medico")
public class Medico implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nro_matricula;
	
	private Long dni_medico;
	private String nombre_medico;
	private String apellido_medico;
	private String direccion_medico;
	private Long tel_medico;
	private String email_medico;	
	
	
	
	
	public Long getNro_matricula() {
		return nro_matricula;
	}
	public void setNro_matricula(Long nro_matricula) {
		this.nro_matricula = nro_matricula;
	}
	public Long getDni_medico() {
		return dni_medico;
	}
	public void setDni_medico(Long dni_medico) {
		this.dni_medico = dni_medico;
	}
	public String getNombre_medico() {
		return nombre_medico;
	}
	public void setNombre_medico(String nombre_medico) {
		this.nombre_medico = nombre_medico;
	}
	public String getApellido_medico() {
		return apellido_medico;
	}
	public void setApellido_medico(String apellido_medico) {
		this.apellido_medico = apellido_medico;
	}
	public String getDireccion_medico() {
		return direccion_medico;
	}
	public void setDireccion_medico(String direccion_medico) {
		this.direccion_medico = direccion_medico;
	}
	public Long getTel_medico() {
		return tel_medico;
	}
	public void setTel_medico(Long tel_medico) {
		this.tel_medico = tel_medico;
	}
	public String getEmail_medico() {
		return email_medico;
	}
	public void setEmail_medico(String email_medico) {
		this.email_medico = email_medico;
	} 
	
	
	
	

}

package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //esto indica que el campo es autoincremental
	private Long dni_paciente;
	
	@NotEmpty  //validacion que indica que el tiene que venir el campo con contenido >0
	private String nombre_paciente;
	
	@NotEmpty
	private String apellido_paciente;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecha_nacimiento_pa;
	
	private String sexo_paciente;
	
	@NotEmpty
	private String direccion_paciente;
	
	@NotNull
	private Long tel_paciente;
	
	@Email
	private String email_paciente;
	
	
	
	public Long getDni_paciente() {
		return dni_paciente;
	}
	public void setDni_paciente(Long dni_paciente) {
		this.dni_paciente = dni_paciente;
	}
	public String getNombre_paciente() {
		return nombre_paciente;
	}
	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}
	public String getApellido_paciente() {
		return apellido_paciente;
	}
	public void setApellido_paciente(String apellido_paciente) {
		this.apellido_paciente = apellido_paciente;
	}
	public Date getFecha_nacimiento_pa() {
		return fecha_nacimiento_pa;
	}
	public void setFecha_nacimiento_pa(Date fecha_nacimiento_pa) {
		this.fecha_nacimiento_pa = fecha_nacimiento_pa;
	}
	public String getSexo_paciente() {
		return sexo_paciente;
	}
	public void setSexo_paciente(String sexo_paciente) {
		this.sexo_paciente = sexo_paciente;
	}
	public String getDireccion_paciente() {
		return direccion_paciente;
	}
	public void setDireccion_paciente(String direccion_paciente) {
		this.direccion_paciente = direccion_paciente;
	}
	public Long getTel_paciente() {
		return tel_paciente;
	}
	public void setTel_paciente(Long tel_paciente) {
		this.tel_paciente = tel_paciente;
	}
	public String getEmail_paciente() {
		return email_paciente;
	}
	public void setEmail_paciente(String email_paciente) {
		this.email_paciente = email_paciente;
	}
	
	
	
	
	
	
	
	
	

}

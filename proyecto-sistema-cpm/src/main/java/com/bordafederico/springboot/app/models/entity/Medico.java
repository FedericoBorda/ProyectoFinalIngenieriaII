package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="medico")
public class Medico implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nro_matricula;
	
	@NotNull
	private Long dni_medico;
	
	@NotEmpty
	private String nombre_medico;
	
	@NotEmpty
	private String apellido_medico;
	
	private String direccion_medico;
	
	private Long tel_medico;
	
	private String email_medico;	
	
	
	@OneToMany(mappedBy="medico", fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private List<TurnoConsulta> turnosConsulta_x_medico;
	
	@OneToMany(mappedBy="medico_especialidad", fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private List<Especialidad> especialidades_x_medico;
	
	@OneToMany(mappedBy="medico_nota", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Nota> notas_x_medico;
	
	@OneToMany(mappedBy="medico_td", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TurnoDisponible> td_x_medico;

	
	
	public Medico() {
		turnosConsulta_x_medico = new ArrayList<TurnoConsulta>();
		especialidades_x_medico = new ArrayList<Especialidad>();
		notas_x_medico = new ArrayList<Nota>();
		td_x_medico = new ArrayList<TurnoDisponible>();
	}
	
	
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
	
	
	public List<TurnoConsulta> getTurnosConsulta_x_medico() {
		return turnosConsulta_x_medico;
	}	
	public void setTurnosConsulta_x_medico(List<TurnoConsulta> turnosConsulta_x_medico) {
		this.turnosConsulta_x_medico = turnosConsulta_x_medico;
	}


	public List<Especialidad> getEspecialidades_x_medico() {
		return especialidades_x_medico;
	}

	public void setEspecialidades_x_medico(List<Especialidad> especialidades_x_medico) {
		this.especialidades_x_medico = especialidades_x_medico;
	}


	public List<Nota> getNotas_x_medico() {
		return notas_x_medico;
	}


	public void setNotas_x_medico(List<Nota> notas_x_medico) {
		this.notas_x_medico = notas_x_medico;
	} 
	
		
	public List<TurnoDisponible> getTd_x_medico() {
		return td_x_medico;
	}


	public void setTd_x_medico(List<TurnoDisponible> td_x_medico) {
		this.td_x_medico = td_x_medico;
	}


	
	
	public void addTurnoConsulta_a_Medico(TurnoConsulta turnoConsulta) {
		turnosConsulta_x_medico.add(turnoConsulta);
		
	}
	public void addEspecialidad_a_Medico(Especialidad especialidad) {
		especialidades_x_medico.add(especialidad);
		
	}
	public void addNota_a_Medico(Nota nota) {
		notas_x_medico.add(nota);
		
	}
	public void addtd_a_Medico(TurnoDisponible td) {
		td_x_medico.add(td);
		
	}
	
	
	
	

}
